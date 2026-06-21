package com.prefeitura.repository;

import com.prefeitura.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    // Busca todos os gastos ordenando pela data mais recente do gasto
    List<Gasto> findAllByOrderByDataGastoDesc();
}