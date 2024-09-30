package repository;

import org.springframework.stereotype.Repository;

import model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
