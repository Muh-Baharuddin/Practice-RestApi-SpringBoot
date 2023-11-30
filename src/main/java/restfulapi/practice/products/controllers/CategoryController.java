package restfulapi.practice.products.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import restfulapi.practice.products.dto.ResponseDto;
import restfulapi.practice.products.dto.CategoryDto;
import restfulapi.practice.products.models.Category;
import restfulapi.practice.products.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService ;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<ResponseDto<Category>> createCategory(@Valid @RequestBody CategoryDto categoryDto, Errors errors) {

    ResponseDto<Category> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Category category = modelMapper.map(categoryDto, Category.class);

    responseData.setStatus(true);
    responseData.setPayload(categoryService.createCategory(category));
    return ResponseEntity.ok(responseData);
  }

  @GetMapping
  public Iterable<Category> findAllCategory() {
    return categoryService.findAllCategory();
  }

  @GetMapping("/{id}")
  public Category findCategoryById(@PathVariable String id) {
    return categoryService.findOneById(id);
  }

  public Category findByName(String name) {
    return categoryService.findByName(name);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto<Category>> updateCategory(@PathVariable String id, @Valid @RequestBody CategoryDto categoryDto, Errors errors) {
    ResponseDto<Category> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Category category = modelMapper.map(categoryDto, Category.class);

    responseData.setStatus(true);
    responseData.setPayload(categoryService.createCategory(category));
    return ResponseEntity.ok(responseData);
  }

  @DeleteMapping("/{id}")
  public void removeCategory(@PathVariable String id) {
    categoryService.removeCategory(id);
  }
}
