package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	

}
