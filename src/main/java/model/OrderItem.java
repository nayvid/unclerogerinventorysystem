package model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="inventory_item_id",nullable=false)
	private InventoryItem inventoryItem;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private BigDecimal price;
	
	
	public OrderItem() {}
	
	public OrderItem(Long Id, Order order, InventoryItem inventoryItem, BigDecimal price, int quantity ) {
		this.id = Id;
		this.order = order;
		this.inventoryItem = inventoryItem;
		this.price = price;
		this.quantity = quantity;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	


}
