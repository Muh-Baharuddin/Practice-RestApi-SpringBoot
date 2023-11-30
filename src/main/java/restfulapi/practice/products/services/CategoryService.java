package restfulapi.practice.products.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import restfulapi.practice.products.models.Category;
import restfulapi.practice.products.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

  public Category findOneById(String id) {
    Optional<Category> category = categoryRepository.findById(id);

    if (!category.isPresent()) {
      return null;
    }
    return category.get();
  }

  public Category findByName(String name) {
    return categoryRepository.findByName(name);
  }

  public Iterable<Category> findAllCategory() {
    return categoryRepository.findAll();
  }

  public Category updateCategory(Category category) {
    return categoryRepository.save(category);
  }

  public void removeCategory(String id) {
    categoryRepository.deleteById(id);
  }
}
