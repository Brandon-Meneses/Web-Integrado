package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.persistence.entity.TransferenciaEntity;
import com.utp.webintegrado.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @RequestMapping
    public ResponseEntity<Page<TransferenciaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(transferenciaService.getAll(page, size));
    }

    @RequestMapping("/{id}")
    public ResponseEntity<TransferenciaEntity> getById(@RequestParam Integer id){
        if (transferenciaService.exists(id)) {
            return ResponseEntity.ok(transferenciaService.getByID(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransferenciaEntity> save(@RequestParam TransferenciaEntity transferencia) {
        if (transferenciaService.exists(transferencia.getIdTransferencia())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(transferenciaService.save(transferencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferenciaEntity> update(@RequestParam Integer id, @RequestParam TransferenciaEntity transferencia) {
        if (transferenciaService.exists(id)) {
            return ResponseEntity.ok(transferenciaService.update(id, transferencia));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransferenciaEntity> delete(@RequestParam Integer id) {
        if (transferenciaService.exists(id)) {
            return ResponseEntity.ok(transferenciaService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }

}
