package com.prefeitura.repository;

import com.prefeitura.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

    // Mágica do Spring Data JPA: cria o código de busca ordenada por data sozinho!
    List<Noticia> findAllByOrderByDataPublicacaoDesc();
}