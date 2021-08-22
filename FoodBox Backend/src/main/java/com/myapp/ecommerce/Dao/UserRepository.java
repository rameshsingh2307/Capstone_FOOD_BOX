package com.myapp.ecommerce.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
