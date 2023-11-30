package restfulapi.practice.products.controllers;

import org.modelmapper.ModelMapper;
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
import restfulapi.practice.products.dto.SupplierDto;
import restfulapi.practice.products.models.Supplier;
import restfulapi.practice.products.services.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
  @Autowired
  private SupplierService supplierService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<ResponseDto<Supplier>> createSupplier(@Valid @RequestBody SupplierDto supplierDto, Errors errors) {

    ResponseDto<Supplier> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Supplier supplier = modelMapper.map(supplierDto, Supplier.class);

    responseData.setStatus(true);
    responseData.setPayload(supplierService.createSupplier(supplier));
    return ResponseEntity.ok(responseData);
  }

  @GetMapping
  public Iterable<Supplier> findAllSupplier() {
    return supplierService.findAllSupplier();
  }

  @GetMapping("/{id}")
  public Supplier findSupplierById(@PathVariable String id) {
    return supplierService.findOneById(id);
  }

  public Supplier findByName(String name) {
    return supplierService.findByName(name);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto<Supplier>> updateSupplier(@PathVariable String id, @Valid @RequestBody SupplierDto supplierDto, Errors errors) {
    ResponseDto<Supplier> responseData = new ResponseDto<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Supplier supplier = modelMapper.map(supplierDto, Supplier.class);

    responseData.setStatus(true);
    responseData.setPayload(supplierService.createSupplier(supplier));
    return ResponseEntity.ok(responseData);
  }

  @DeleteMapping("/{id}")
  public void removeSupplier(@PathVariable String id) {
    supplierService.removeSupplier(id);
  }
}
