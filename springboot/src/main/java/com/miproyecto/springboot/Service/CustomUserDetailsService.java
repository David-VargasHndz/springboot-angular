package com.miproyecto.springboot.service;

import com.miproyecto.springboot.model.AppUser;
import com.miproyecto.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        // Buscar usuario por nickname
        AppUser appUser = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nickname: " + nickname));

        // Retornar un objeto UserDetails compatible con Spring Security
        return new User(appUser.getNickname(), appUser.getPassword(), Collections.emptyList());
    }

    // Método adicional para autenticar por nickname y contraseña
    public UserDetails loadUserByNicknameAndPassword(String nickname, String password) throws UsernameNotFoundException {
        // Buscar usuario por nickname y password
        AppUser appUser = userRepository.findByNicknameAndPassword(nickname, password)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario o contraseña incorrectos"));

        // Retornar un objeto UserDetails compatible con Spring Security
        return new User(appUser.getNickname(), appUser.getPassword(), Collections.emptyList());
    }
}
