package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.persistence.entity.StockSucursalEntity;
import com.utp.webintegrado.service.StockSucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/stock-sucursal")
public class StockSucursalController {

    private final StockSucursalService stockSucursalService;

    @Autowired
    public StockSucursalController(StockSucursalService stockSucursalService) {
        this.stockSucursalService = stockSucursalService;
    }


    @GetMapping
    public ResponseEntity<List<StockSucursalEntity>> getAll(){
        return ResponseEntity.ok(stockSucursalService.getAll());
    }

    @GetMapping("/{idSucursal}/{idLibro}")
    public ResponseEntity<StockSucursalEntity> getById(@PathVariable Integer idSucursal, @PathVariable Integer idLibro) {
        if(stockSucursalService.exists(idSucursal, idLibro)){
            return ResponseEntity.ok(stockSucursalService.getByID(idSucursal, idLibro).get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<StockSucursalEntity> save(@RequestBody StockSucursalEntity stockSucursal) {
        if (stockSucursalService.exists(stockSucursal.getId().getIdSucursal(), stockSucursal.getId().getIdLibro())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stockSucursalService.save(stockSucursal));
    }

    @PutMapping("/{idSucursal}/{idLibro}")
    public ResponseEntity<StockSucursalEntity> update(@PathVariable Integer idSucursal, @PathVariable Integer idLibro, @RequestBody StockSucursalEntity stockSucursal) {
        if (stockSucursalService.exists(idSucursal, idLibro) && idSucursal == stockSucursal.getId().getIdSucursal() && idLibro == stockSucursal.getId().getIdLibro()) {
            return ResponseEntity.ok(stockSucursalService.update(stockSucursal));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idSucursal}/{idLibro}")
    public ResponseEntity<StockSucursalEntity> delete(@PathVariable Integer idSucursal, @PathVariable Integer idLibro) {
        if (stockSucursalService.exists(idSucursal, idLibro)) {
            return ResponseEntity.ok(stockSucursalService.delete(idSucursal, idLibro));
        }
        return ResponseEntity.notFound().build();
    }
}
