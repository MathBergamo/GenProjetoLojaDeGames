package com.generation.gameshub.Controller;

import com.generation.gameshub.Models.Produto;
import com.generation.gameshub.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produto = produtoService.findAll();
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        Produto createdProduto = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Long id) {
        Produto updatedProduto = produtoService.update(produto,id);
        return ResponseEntity.ok().body(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/distribuidores") // Fluxo feito pelo RequestBody para aprendizado
    public ResponseEntity<List<Produto>> findAllByDistribuidor(@RequestBody Produto distribuidor) {
        List<Produto> produtos = produtoService.findAllByDistribuidor(distribuidor);
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> findAllByCategoria(@PathVariable String categoria) {
        List<Produto> produtos = produtoService.findAllByCategoria(categoria);
        return ResponseEntity.ok().body(produtos);
    }

}
