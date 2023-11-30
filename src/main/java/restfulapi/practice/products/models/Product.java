package restfulapi.practice.products.models;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotEmpty(message = "Name is required")
  @Column(length = 100)
  private String name;

  private double price;

  @NotEmpty(message = "Description is required")
  @Column(length = 500)
  private String description;

  @ManyToOne
  private Category category;

  @ManyToMany
  @JoinTable(
    name = "product_supplier",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "supplier_id"))
  private Set<Supplier> suppliers;
}
