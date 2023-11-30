package restfulapi.practice.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfulapi.practice.products.models.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
  
  List<Product> findByName(String name);
}
