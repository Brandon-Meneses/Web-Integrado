package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.AdquisicionEntity;
import com.utp.webintegrado.persistence.repository.AdquisicionPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AdquisicionService {

    private final AdquisicionPaginSortRepository adquisicionPaginSortRepository;

    public AdquisicionService(AdquisicionPaginSortRepository adquisicionPaginSortRepository) {
        this.adquisicionPaginSortRepository = adquisicionPaginSortRepository;
    }


    public AdquisicionEntity getByID(Integer id) {
        return adquisicionPaginSortRepository.findById(id).orElse(null);
    }

    public Page<AdquisicionEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("fecha").descending());
        return adquisicionPaginSortRepository.findAll(pageRequest);
    }

    public AdquisicionEntity save(AdquisicionEntity adquisicion) {
        return adquisicionPaginSortRepository.save(adquisicion);
    }

    public AdquisicionEntity update(Integer id, AdquisicionEntity adquisicion) {
        if (adquisicionPaginSortRepository.existsById(id)) {
            return adquisicionPaginSortRepository.save(adquisicion);
        }
        return null;
    }

    public AdquisicionEntity delete(Integer id) {
        if (adquisicionPaginSortRepository.existsById(id)) {
            AdquisicionEntity adquisicion = adquisicionPaginSortRepository.findById(id).get();
            adquisicionPaginSortRepository.deleteById(id);
            return adquisicion;
        }
        return null;
    }

}
