package com.generation.gameshub.Controller;

import com.generation.gameshub.Models.Categoria;
import com.generation.gameshub.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categoria = categoriaService.findAll();
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        Categoria createdCategoria = categoriaService.create(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Long id) {
        Categoria updatedCategoria = categoriaService.update(categoria,id);
        return ResponseEntity.ok().body(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Categoria>> findAllByAtivo() {
        List<Categoria> categorias = categoriaService.findAllByAtivo();
        return ResponseEntity.ok().body(categorias);
    }
}
