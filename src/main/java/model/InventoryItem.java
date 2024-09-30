package model;

import java.util.Locale.Category;
import java.util.function.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column (nullable = false)
	private String name;
	private String description;
	@Column (nullable = false)
	private int quantity;
	@Column (nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
	
	//Constructors
	public InventoryItem() {}
	
	public InventoryItem(String name, String description, int quantity, double price) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory (Category category) {
		this.category = category;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
