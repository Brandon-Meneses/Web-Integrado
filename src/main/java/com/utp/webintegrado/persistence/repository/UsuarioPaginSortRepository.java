package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.Optional;

public interface UsuarioPaginSortRepository extends ListPagingAndSortingRepository<UsuarioEntity, Integer>,
        ListCrudRepository<UsuarioEntity, Integer> {

        Optional<UsuarioEntity> findByEmail(String email);

}
