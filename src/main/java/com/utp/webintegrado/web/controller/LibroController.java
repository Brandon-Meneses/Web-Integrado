package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.persistence.entity.LibroEntity;
import com.utp.webintegrado.service.LibroService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/libro")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<Page<LibroEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(libroService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> getById(@PathVariable Integer id){
        if (libroService.exists(id)) {
            return ResponseEntity.ok(libroService.getByID(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LibroEntity> save(@RequestBody LibroEntity libro) {
        if (libroService.exists(libro.getIdLibro())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(libroService.save(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroEntity> update(@PathVariable Integer id, @RequestBody LibroEntity libro) {
        if (libroService.exists(id)) {
            return ResponseEntity.ok(libroService.update(id, libro));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LibroEntity> delete(@PathVariable Integer id) {
        if (libroService.exists(id)) {
            return ResponseEntity.ok(libroService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }

}
