package com.example.jpap2.repository;
import com.example.jpap2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {}
