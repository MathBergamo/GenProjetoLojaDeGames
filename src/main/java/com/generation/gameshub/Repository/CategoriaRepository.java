package com.generation.gameshub.Repository;

import com.generation.gameshub.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByAtivoTrue();

}
