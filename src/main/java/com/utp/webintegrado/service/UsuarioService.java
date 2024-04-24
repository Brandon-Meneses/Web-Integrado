package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.UsuarioEntity;
import com.utp.webintegrado.persistence.repository.UsuarioPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioPaginSortRepository usuarioPaginSortRepository;

    public UsuarioService(UsuarioPaginSortRepository usuarioPaginSortRepository) {
        this.usuarioPaginSortRepository = usuarioPaginSortRepository;
    }


    public UsuarioEntity getByID(Integer id) {
        return usuarioPaginSortRepository.findById(id).orElse(null);
    }

    public Page<UsuarioEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return usuarioPaginSortRepository.findAll(pageRequest);
    }

    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioPaginSortRepository.save(usuario);
    }

    public UsuarioEntity update(Integer id, UsuarioEntity usuario) {
        if (usuarioPaginSortRepository.existsById(id)) {
            return usuarioPaginSortRepository.save(usuario);
        }
        return null;
    }

    public UsuarioEntity delete(Integer id) {
        if (usuarioPaginSortRepository.existsById(id)) {
            UsuarioEntity usuario = usuarioPaginSortRepository.findById(id).get();
            usuarioPaginSortRepository.deleteById(id);
            return usuario;
        }
        return null;
    }
}
