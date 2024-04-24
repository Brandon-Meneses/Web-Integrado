package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.SucursalEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface SucursalPaginSortRepository extends ListPagingAndSortingRepository<SucursalEntity, Integer>,
        ListCrudRepository<SucursalEntity, Integer> {

}
