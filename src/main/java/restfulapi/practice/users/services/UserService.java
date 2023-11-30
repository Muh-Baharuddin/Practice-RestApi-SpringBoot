package restfulapi.practice.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfulapi.practice.users.models.User;
import restfulapi.practice.users.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> findUserById(String id) {
    return userRepository.findById(id);
  }

  public User updateUser(String id, User userData) {
    Optional<User> user = userRepository.findById(id);
    System.out.println(user);

    if (user.isPresent()) {
      User existingUser = user.get();
      existingUser.setUsername(userData.getUsername());
      existingUser.setPassword(userData.getPassword());
      existingUser.setName(userData.getName());
      return userRepository.save(existingUser);
    }
    return null;
  }

  public void removeUser(String id) {
    userRepository.deleteById(id);
  }
}
