package com.prefeitura.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Indica que esta classe vai virar uma tabela no banco de dados
@Table(name = "noticias") // Nome da tabela no banco
public class Noticia {

    @Id // Define o campo 'id' como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automático (1, 2, 3...)
    private Long id;

    @Column(nullable = false, length = 150) // Campo obrigatório, máximo 150 caracteres
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT") // Campo de texto longo para a notícia
    private String conteudo;

    @Column(nullable = false) // Data e hora da publicação
    private LocalDateTime dataPublicacao;

    // Construtor vazio (obrigatório para o Spring funcionar por trás dos panos)
    public Noticia() {
    }

    // Construtor para nos ajudar a criar notícias mais rápido
    public Noticia(String titulo, String conteudo, LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
    }

    // --- GETTERS E SETTERS (Permitem que o Spring acesse e altere as variáveis) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
