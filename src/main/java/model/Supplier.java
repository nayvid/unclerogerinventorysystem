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
@Table(name="suppliers")

public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	private String contactPerson;
	
	private String email;
	
	private String phone;
	
	@OneToMany(mappedBy = "supplier")
	private Set<InventoryItem> items;
	
	
	public Supplier() {}
	
	public Supplier(String name, String contactPerson, String email, String phone) {
		this.name=name;
		this.contactPerson = contactPerson;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<InventoryItem> getItems() {
		return items;
	}

	public void setItems(Set<InventoryItem> items) {
		this.items = items;
	}
	

}
