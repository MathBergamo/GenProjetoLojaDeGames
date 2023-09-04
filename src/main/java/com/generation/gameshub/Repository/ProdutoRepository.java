package com.generation.gameshub.Repository;

import com.generation.gameshub.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByDistribuidorContainingIgnoreCase(@Param("distribuidor") String distribuidor);

    List<Produto> findByCategoriaNomeIgnoreCase(String nomeCategoria);
}
