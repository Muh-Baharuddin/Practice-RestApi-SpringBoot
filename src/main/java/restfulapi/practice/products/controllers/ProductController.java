package restfulapi.practice.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import restfulapi.practice.products.dto.ResponseDto;
import restfulapi.practice.products.models.Product;
import restfulapi.practice.products.services.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<ResponseDto<Product>> createProduct(@Valid @RequestBody Product product, Errors errors) {

    ResponseDto<Product> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
    responseData.setStatus(true);
    responseData.setPayload(productService.createProduct(product));
    return ResponseEntity.ok(responseData);
  }

  @GetMapping
  public Iterable<Product> findAllProduct() {
    return productService.findAllProduct();
  }

  @GetMapping("/{id}")
  public Product findProductById(@PathVariable String id) {
    return productService.findOneById(id);
  }

  public List<Product> findByName(String name) {
    return productService.findByName(name);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto<Product>> updateProduct(@PathVariable String id, @Valid @RequestBody Product product, Errors errors) {
    ResponseDto<Product> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
    responseData.setStatus(true);
    responseData.setPayload(productService.createProduct(product));
    return ResponseEntity.ok(responseData);
  }

  @DeleteMapping("/{id}")
  public void removeProduct(@PathVariable String id) {
    productService.removeProduct(id);
  }
}
