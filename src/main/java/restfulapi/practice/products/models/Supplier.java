package restfulapi.practice.products.models;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "suppliers")
@Data
public class Supplier implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(length = 150, nullable = false)
  private String name;

  @Column(length = 200, nullable = false)
  private String address;

  @Column(length = 100, nullable = false, unique = true)
  private String email;

  @ManyToMany(mappedBy = "suppliers")
  private Set<Product> products;
}
