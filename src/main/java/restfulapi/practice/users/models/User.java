package restfulapi.practice.users.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String username;

  private String password;

  private String name;
}
