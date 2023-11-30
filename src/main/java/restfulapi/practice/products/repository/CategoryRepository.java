package restfulapi.practice.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfulapi.practice.products.models.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
  Category findByName(String name);
}
