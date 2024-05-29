package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.UsuarioEntity;
import com.utp.webintegrado.persistence.repository.UsuarioPaginSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSecurityService implements UserDetailsService {

    private final UsuarioPaginSortRepository usuarioRepository;

    @Autowired
    public UsuarioSecurityService(UsuarioPaginSortRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findByEmail(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario "+ id +" no encontrado"));

        String roleName = usuarioEntity.getRol().getRolNombre();

        return User.builder()
                .username(usuarioEntity.getEmail())
                .password(usuarioEntity.getContrasena())
                .roles(roleName)
                .build();
    }
}
