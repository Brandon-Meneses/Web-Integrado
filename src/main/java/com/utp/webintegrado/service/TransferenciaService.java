package com.utp.webintegrado.service;

import com.utp.webintegrado.persistence.entity.TransferenciaEntity;
import com.utp.webintegrado.persistence.repository.TransferenciaPaginSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    private final TransferenciaPaginSortRepository transferenciaPaginSortRepository;

    public TransferenciaService(TransferenciaPaginSortRepository transferenciaPaginSortRepository) {
        this.transferenciaPaginSortRepository = transferenciaPaginSortRepository;
    }


    public TransferenciaEntity getByID(Integer id) {
        return transferenciaPaginSortRepository.findById(id).orElse(null);
    }

    public Page<TransferenciaEntity> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return transferenciaPaginSortRepository.findAll(pageRequest);
    }

    public TransferenciaEntity save(TransferenciaEntity transferencia) {
        return transferenciaPaginSortRepository.save(transferencia);
    }

    public TransferenciaEntity update(Integer id, TransferenciaEntity transferencia) {
        if (transferenciaPaginSortRepository.existsById(id)) {
            return transferenciaPaginSortRepository.save(transferencia);
        }
        return null;
    }

    public TransferenciaEntity delete(Integer id) {
        if (transferenciaPaginSortRepository.existsById(id)) {
            TransferenciaEntity transferencia = transferenciaPaginSortRepository.findById(id).get();
            transferenciaPaginSortRepository.deleteById(id);
            return transferencia;
        }
        return null;
    }

}
