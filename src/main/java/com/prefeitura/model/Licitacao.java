package com.prefeitura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "licitacoes") // Vincula com a tabela do seu pgAdmin
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_licitacao", nullable = false, length = 20)
    private String numeroLicitacao;

    @Column(name = "tipo_licitacao", nullable = false, length = 50)
    private String tipoLicitacao;

    @Column(name = "situacao_processo", nullable = false)
    private Boolean situacaoProcesso;

    // Construtor vazio obrigatório
    public Licitacao() {
    }

    // Construtor completo
    public Licitacao(String numeroLicitacao, String tipoLicitacao, Boolean situacaoProcesso) {
        this.numeroLicitacao = numeroLicitacao;
        this.tipoLicitacao = tipoLicitacao;
        this.situacaoProcesso = situacaoProcesso;
    }

    // --- GETTERS E SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroLicitacao() {
        return numeroLicitacao;
    }

    public void setNumeroLicitacao(String numeroLicitacao) {
        this.numeroLicitacao = numeroLicitacao;
    }

    public String getTipoLicitacao() {
        return tipoLicitacao;
    }

    public void setTipoLicitacao(String tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }

    public Boolean getSituacaoProcesso() {
        return situacaoProcesso;
    }

    public void setSituacaoProcesso(Boolean situacaoProcesso) {
        this.situacaoProcesso = situacaoProcesso;
    }
}