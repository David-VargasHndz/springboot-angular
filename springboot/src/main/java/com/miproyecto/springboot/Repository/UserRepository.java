package com.miproyecto.springboot.repository;

import com.miproyecto.springboot.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Repositorio que extiende JpaRepository para manejar operaciones CRUD automáticamente
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByNickname(String nickname); // Buscar usuario por su nickname
    Optional<AppUser> findByNicknameAndPassword(String nickname, String password); // Buscar usuario por su nickname y password
}
