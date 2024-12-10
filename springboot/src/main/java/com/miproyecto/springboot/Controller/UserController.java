package com.miproyecto.springboot.controller;

import com.miproyecto.springboot.model.User;
import com.miproyecto.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST para manejar solicitudes relacionadas con los usuarios
@RestController
@RequestMapping("/api/users") // Ruta base para los endpoints
public class UserController {

    @Autowired // Inyección de dependencias para el repositorio
    private UserRepository userRepository;

    // Endpoint GET para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Retorna todos los registros de la tabla `users`
    }

    // Endpoint POST para crear un nuevo usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // Guarda el usuario en la base de datos
    }
}
