package com.prefeitura.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200) // Descrição do gasto (Ex: Reforma de Posto de Saúde)
    private String descricao;

    @Column(nullable = false) // Valor gasto (Ex: 15200.50)
    private BigDecimal valor;

    @Column(nullable = false) // Data em que o gasto ocorreu
    private LocalDate dataGasto;

    @Column(nullable = false, length = 100) // Categoria (Ex: Saúde, Educação, Infraestrutura)
    private String categoria;

    // Construtor vazio
    public Gasto() {
    }

    // Construtor completo
    public Gasto(String descricao, BigDecimal valor, LocalDate dataGasto, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataGasto = dataGasto;
        this.categoria = categoria;
    }

    // --- GETTERS E SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(LocalDate dataGasto) {
        this.dataGasto = dataGasto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
