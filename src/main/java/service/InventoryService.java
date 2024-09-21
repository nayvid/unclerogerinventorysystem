package service;

import repository.InventoryItemRepository;
import model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
	private final InventoryItemRepository repository;
	
	
	@Autowired
	public InventoryService(InventoryItemRepository repository) {
		this.repository = repository;
	}
	
	public List<InventoryItem> getAllItems() {
		//findAll is used for retrieving all records from db
		return repository.findAll();
	}
	
	/*
	 * public InventoryItem saveItem(InventoryItem item) { return
	 * repository.save(item); }
	 */
	
	
	//TODO: implement methods here
	
	//1. need to setup the postgres connection - to install the drivers
	//2. fix the save method showing error

}
