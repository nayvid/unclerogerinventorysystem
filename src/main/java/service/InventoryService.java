package service;

import repository.InventoryItemRepository;
import model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryItemRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryItemRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryItem addItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    public Optional<InventoryItem> getItem(Long id) {
        return inventoryRepository.findById(id);
    }

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Optional<InventoryItem> updateItem(Long id, InventoryItem updatedItem) {
        return inventoryRepository.findById(id)
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setDescription(updatedItem.getDescription());
                    item.setQuantity(updatedItem.getQuantity());
                    item.setPrice(updatedItem.getPrice());
                    return inventoryRepository.save(item);
                });
    }

    public boolean deleteItem(Long id) {
        return inventoryRepository.findById(id)
                .map(item -> {
                    inventoryRepository.delete(item);
                    return true;
                })
                .orElse(false);
    }

	
	//TODO: implement methods here
	
	//1. need to setup the postgres connection - to install the drivers
	//2. fix the save method showing error

}
