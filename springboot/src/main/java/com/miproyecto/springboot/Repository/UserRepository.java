package com.miproyecto.springboot.repository;

import com.miproyecto.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio que extiende JpaRepository para manejar operaciones CRUD automáticamente
public interface UserRepository extends JpaRepository<User, Long> {
}
