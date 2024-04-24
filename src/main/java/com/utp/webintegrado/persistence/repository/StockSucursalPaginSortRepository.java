package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.StockSucursalEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface StockSucursalPaginSortRepository extends ListPagingAndSortingRepository<StockSucursalEntity, Integer>,
        ListCrudRepository<StockSucursalEntity, Integer>{

}
