package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface UsuarioPaginSortRepository extends ListPagingAndSortingRepository<UsuarioEntity, Integer>,
        ListCrudRepository<UsuarioEntity, Integer> {

}
