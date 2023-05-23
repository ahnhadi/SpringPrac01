package me.haeri.springbootdeveloper.repository;

import java.util.Optional;
import me.haeri.springbootdeveloper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
