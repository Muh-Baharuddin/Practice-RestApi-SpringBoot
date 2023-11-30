package restfulapi.practice.products.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDto {
  @NotEmpty(message = "Name is required")
  private String name;
}
