package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.persistence.entity.AdquisicionEntity;
import com.utp.webintegrado.service.AdquisicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/adquisicion")
public class AdquisicionController {

    private final AdquisicionService adquisicionService;

    @Autowired
    public AdquisicionController(AdquisicionService adquisicionService) {
        this.adquisicionService = adquisicionService;
    }

    @GetMapping
    public ResponseEntity<Page<AdquisicionEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(adquisicionService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdquisicionEntity> getById(@PathVariable Integer id){
        if (adquisicionService.exists(id)) {
            return ResponseEntity.ok(adquisicionService.getByID(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdquisicionEntity> save(@RequestBody AdquisicionEntity adquisicion) {
        if (adquisicionService.exists(adquisicion.getIdAdquisicion())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(adquisicionService.save(adquisicion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdquisicionEntity> update(@PathVariable Integer id, @RequestBody AdquisicionEntity adquisicion) {
        if (adquisicionService.exists(id) && id.equals(adquisicion.getIdAdquisicion())) {
            return ResponseEntity.ok(adquisicionService.update(id, adquisicion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdquisicionEntity> delete(@PathVariable Integer id) {
        if (adquisicionService.exists(id)) {
            return ResponseEntity.ok(adquisicionService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }



}
