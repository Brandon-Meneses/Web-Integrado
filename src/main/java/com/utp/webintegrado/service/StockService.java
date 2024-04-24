package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.repository.StockSucursalPaginSortRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockSucursalPaginSortRepository stockPaginSortRepository;

    public StockService(StockSucursalPaginSortRepository stockPaginSortRepository) {
        this.stockPaginSortRepository = stockPaginSortRepository;
    }




}
