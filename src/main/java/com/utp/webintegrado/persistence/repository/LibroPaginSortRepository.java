package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.LibroEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface LibroPaginSortRepository extends ListPagingAndSortingRepository<LibroEntity, Integer>,
        ListCrudRepository<LibroEntity, Integer>{

}
