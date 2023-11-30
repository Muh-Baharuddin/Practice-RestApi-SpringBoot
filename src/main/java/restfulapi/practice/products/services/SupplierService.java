package restfulapi.practice.products.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import restfulapi.practice.products.models.Supplier;
import restfulapi.practice.products.repository.SupplierRepository;

@Service
@Transactional
public class SupplierService {
  @Autowired
  private SupplierRepository supplierRepository;

    public Supplier createSupplier(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  public Supplier findOneById(String id) {
    Optional<Supplier> supplier = supplierRepository.findById(id);

    if (!supplier.isPresent()) {
      return null;
    }
    return supplier.get();
  }

  public Supplier findByName(String name) {
    return supplierRepository.findByName(name);
  }

  public Iterable<Supplier> findAllSupplier() {
    return supplierRepository.findAll();
  }

  public Supplier updateSupplier(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  public void removeSupplier(String id) {
    supplierRepository.deleteById(id);
  }
}
