package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.StockSucursalEntity;
import com.utp.webintegrado.persistence.repository.StockSucursalPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockSucursalPaginSortRepository stockPaginSortRepository;

    public StockService(StockSucursalPaginSortRepository stockPaginSortRepository) {
        this.stockPaginSortRepository = stockPaginSortRepository;
    }


    public StockSucursalEntity getByID(Integer id) {
        return stockPaginSortRepository.findById(id).orElse(null);
    }

    public Page<StockSucursalEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return stockPaginSortRepository.findAll(pageRequest);
    }

    public StockSucursalEntity save(StockSucursalEntity stock) {
        return stockPaginSortRepository.save(stock);
    }

    public StockSucursalEntity update(Integer id, StockSucursalEntity stock) {
        if (stockPaginSortRepository.existsById(id)) {
            return stockPaginSortRepository.save(stock);
        }
        return null;
    }

    public StockSucursalEntity delete(Integer id) {
        if (stockPaginSortRepository.existsById(id)) {
            StockSucursalEntity stock = stockPaginSortRepository.findById(id).get();
            stockPaginSortRepository.deleteById(id);
            return stock;
        }
        return null;
    }

    public boolean exists(Integer id){
        return stockPaginSortRepository.existsById(id);
    }

}
