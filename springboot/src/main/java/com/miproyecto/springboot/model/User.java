package com.miproyecto.springboot.model;

import jakarta.persistence.*;
import lombok.*;

// Anotaciones de Lombok para reducir el código boilerplate (getters, setters, constructores)
@Entity // Marca esta clase como una entidad JPA (tabla en la base de datos)
@Table(name = "users") // Especifica el nombre de la tabla asociada en la base de datos
@Data // Genera automáticamente los getters y setters
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los atributos
public class User {

    @Id // Define la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementa el ID
    private Long id;

    @Column(nullable = false, unique = true) // Campo obligatorio y único
    private String nickname;

    @Column(nullable = false) // Campo obligatorio
    private String password;

    @Column(nullable = false, unique = true) // Campo obligatorio y único
    private String email;
}
