package restfulapi.practice.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfulapi.practice.products.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String>{
  Supplier findByName(String name);
}
