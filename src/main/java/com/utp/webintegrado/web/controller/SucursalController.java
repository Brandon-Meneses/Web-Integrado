package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.persistence.entity.SucursalEntity;
import com.utp.webintegrado.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @RequestMapping
    public ResponseEntity<Page<SucursalEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(sucursalService.getAll(page, size));
    }

    @RequestMapping("/{id}")
    public ResponseEntity<SucursalEntity> getById(@RequestParam Integer id){
        if (sucursalService.exists(id)) {
            return ResponseEntity.ok(sucursalService.getByID(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SucursalEntity> save(@RequestParam SucursalEntity sucursal) {
        if (sucursalService.exists(sucursal.getIdSucursal())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(sucursalService.save(sucursal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalEntity> update(@RequestParam Integer id, @RequestParam SucursalEntity sucursal) {
        if (sucursalService.exists(id) && id.equals(sucursal.getIdSucursal())) {
            return ResponseEntity.ok(sucursalService.update(id, sucursal));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SucursalEntity> delete(@RequestParam Integer id) {
        if (sucursalService.exists(id)) {
            return ResponseEntity.ok(sucursalService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }


}
