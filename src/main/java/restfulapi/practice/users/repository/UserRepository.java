package restfulapi.practice.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfulapi.practice.users.models.User;

public interface UserRepository extends JpaRepository<User, String>{
  
}
