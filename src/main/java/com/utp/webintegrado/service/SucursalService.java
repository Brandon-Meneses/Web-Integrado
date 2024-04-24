package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.SucursalEntity;
import com.utp.webintegrado.persistence.repository.SucursalPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    private final SucursalPaginSortRepository sucursalPaginSortRepository;

    public SucursalService(SucursalPaginSortRepository sucursalPaginSortRepository) {
        this.sucursalPaginSortRepository = sucursalPaginSortRepository;
    }


    public SucursalEntity getByID(Integer id) {
        return sucursalPaginSortRepository.findById(id).orElse(null);
    }

    public Page<SucursalEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return sucursalPaginSortRepository.findAll(pageRequest);
    }

    public SucursalEntity save(SucursalEntity sucursal) {
        return sucursalPaginSortRepository.save(sucursal);
    }

    public SucursalEntity update(Integer id, SucursalEntity sucursal) {
        if (sucursalPaginSortRepository.existsById(id)) {
            return sucursalPaginSortRepository.save(sucursal);
        }
        return null;
    }

    public SucursalEntity delete(Integer id) {
        if (sucursalPaginSortRepository.existsById(id)) {
            SucursalEntity sucursal = sucursalPaginSortRepository.findById(id).get();
            sucursalPaginSortRepository.deleteById(id);
            return sucursal;
        }
        return null;
    }

    public boolean exists(Integer id){
        return sucursalPaginSortRepository.existsById(id);
    }

}
