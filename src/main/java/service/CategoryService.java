package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import model.Category;
import repository.CategoryRepository;

@Entity
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Optional<Category> updateCategory(Long id, Category categoryDetails) {
		return categoryRepository.findById(id)
				.map(category -> {
					category.setName(categoryDetails.getName());
					category.setDescription(category.getDescription());
					return categoryRepository.save(category);
				});
		}
	
	
	

}
