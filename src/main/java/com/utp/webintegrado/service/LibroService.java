package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.LibroEntity;
import com.utp.webintegrado.persistence.repository.LibroPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    private final LibroPaginSortRepository libroPaginSortRepository;

    public LibroService(LibroPaginSortRepository libroPaginSortRepository) {
        this.libroPaginSortRepository = libroPaginSortRepository;
    }


    public LibroEntity getByID(Integer id) {
        return libroPaginSortRepository.findById(id).orElse(null);
    }

    public Page<LibroEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return libroPaginSortRepository.findAll(pageRequest);
    }

    public LibroEntity save(LibroEntity libro) {
        return libroPaginSortRepository.save(libro);
    }

    public LibroEntity update(Integer id, LibroEntity libro) {
            return libroPaginSortRepository.save(libro);
    }

    public LibroEntity delete(Integer id) {
            LibroEntity libro = libroPaginSortRepository.findById(id).get();
            libroPaginSortRepository.deleteById(id);
            return libro;
    }

    public boolean exists(Integer id){
        return libroPaginSortRepository.existsById(id);
    }

}
