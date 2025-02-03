package com.miproyecto.springboot.controller;

import com.miproyecto.springboot.model.AppUser;
import com.miproyecto.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import java.util.List;

// Controlador REST para manejar solicitudes relacionadas con los usuarios
@RestController
@RequestMapping("/api/users") // Ruta base para los endpoints
@CrossOrigin(origins = "http://localhost:4200") // Permitir Angular
public class UserController {

    @Autowired // Inyección de dependencias para el repositorio
    private UserRepository userRepository;

    // Endpoint GET para obtener si se encuentra el usuario
    @GetMapping
    public ResponseEntity<AppUser> loginUser(@RequestParam String nickname, @RequestParam String password) {
        Optional<AppUser> user = userRepository.findByNicknameAndPassword(nickname, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Si no se encuentra, retorna 401
        }
    }

    // Endpoint POST para crear un nuevo usuario
    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userRepository.save(user); // Guarda el usuario en la base de datos
    }
}
