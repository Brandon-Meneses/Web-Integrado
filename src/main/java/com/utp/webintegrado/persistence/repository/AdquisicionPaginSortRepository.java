package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.AdquisicionEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface AdquisicionPaginSortRepository extends ListPagingAndSortingRepository<AdquisicionEntity, Integer>,
        ListCrudRepository<AdquisicionEntity, Integer>{

}
