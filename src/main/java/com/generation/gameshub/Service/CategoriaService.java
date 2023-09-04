package com.generation.gameshub.Service;

import com.generation.gameshub.Models.Categoria;
import com.generation.gameshub.Repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new EntityNotFoundException(
                "Categoria não encontrada! Id: " + id));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public Categoria create(@Valid Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria update(@Valid Categoria updatedCategoria, Long id) {
        Categoria categoria = findById(id);

        updatedCategoria.setId(categoria.getId());
        categoria.setNome(updatedCategoria.getNome());
        categoria.setAtivo(updatedCategoria.getAtivo());

        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepository.findById(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }

    public List<Categoria> findAllByAtivo() throws EntityNotFoundException {
        return categoriaRepository.findAllByAtivoTrue();
    }
}
