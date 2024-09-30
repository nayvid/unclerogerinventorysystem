package model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "category")
	private Set<InventoryItem> items;
	
	
	public Category() {}
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	//Getters and setters for all fields
	
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
	
	public Set <InventoryItem> getItems() {
		return items;
	}
	
	public void setItems(Set<InventoryItem> items) {
		this.items = items;
	}

}
