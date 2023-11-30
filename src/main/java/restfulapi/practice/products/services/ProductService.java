package restfulapi.practice.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import restfulapi.practice.products.models.Product;
import restfulapi.practice.products.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product findOneById(String id) {
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) {
      return null;
    }
    return product.get();
  }

  public List<Product> findByName(String name) {
    return productRepository.findByName(name);
  }

  public Iterable<Product> findAllProduct() {
    return productRepository.findAll();
  }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public void removeProduct(String id) {
    productRepository.deleteById(id);
  }
}
