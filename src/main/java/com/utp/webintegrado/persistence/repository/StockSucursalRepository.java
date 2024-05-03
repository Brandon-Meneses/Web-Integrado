package com.utp.webintegrado.persistence.repository;

import com.utp.webintegrado.persistence.entity.StockSucursalEntity;
import com.utp.webintegrado.persistence.entity.StockSucursalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockSucursalRepository extends JpaRepository<StockSucursalEntity, StockSucursalId> {
}
