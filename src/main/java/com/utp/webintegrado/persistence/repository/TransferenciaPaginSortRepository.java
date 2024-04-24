package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.TransferenciaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface TransferenciaPaginSortRepository extends ListPagingAndSortingRepository<TransferenciaEntity, Integer>,
        ListCrudRepository<TransferenciaEntity, Integer>{

}
