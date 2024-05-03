package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.StockSucursalEntity;
import com.utp.webintegrado.persistence.entity.StockSucursalId;
import org.springframework.stereotype.Service;

import com.utp.webintegrado.persistence.repository.StockSucursalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockSucursalService {

    private final StockSucursalRepository stockSucursalRepository;

    public StockSucursalService(StockSucursalRepository stockSucursalRepository) {
        this.stockSucursalRepository = stockSucursalRepository;
    }


    public Optional<StockSucursalEntity> getByID(int idSucursal, int idLibro) {
        return stockSucursalRepository.findById(new StockSucursalId(idSucursal, idLibro));
    }

    public List<StockSucursalEntity> getAll() {
        return stockSucursalRepository.findAll();
    }

    public StockSucursalEntity save(StockSucursalEntity stockSucursal) {
        return stockSucursalRepository.save(stockSucursal);
    }

    public StockSucursalEntity update(StockSucursalEntity stockSucursal) {
        return stockSucursalRepository.save(stockSucursal);
    }

    public StockSucursalEntity delete(int idSucursal, int idLibro) {
        StockSucursalEntity stockSucursal = stockSucursalRepository.findById(new StockSucursalId(idSucursal, idLibro)).get();
        stockSucursalRepository.deleteById(new StockSucursalId(idSucursal, idLibro));
        return stockSucursal;
    }

    public boolean exists(int idSucursal, int idLibro){
        return stockSucursalRepository.existsById(new StockSucursalId(idSucursal, idLibro));
    }

}
