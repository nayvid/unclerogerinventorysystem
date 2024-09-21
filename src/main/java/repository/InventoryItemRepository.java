package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.InventoryItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>{

}
