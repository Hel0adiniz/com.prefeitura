package com.prefeitura.controller;

import com.prefeitura.model.Gasto;
import com.prefeitura.model.Licitacao;
import com.prefeitura.model.Noticia;
import com.prefeitura.repository.GastoRepository;
import com.prefeitura.repository.LicitacaoRepository;
import com.prefeitura.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PrefeituraController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private LicitacaoRepository licitacaoRepository;

    // --- NOTÍCIAS ---

    @GetMapping("/noticias")
    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAllByOrderByDataPublicacaoDesc();
    }

    @PostMapping("/noticias")
    public Noticia criarNoticia(@RequestBody Noticia noticia) {
        noticia.setDataPublicacao(LocalDateTime.now());
        return noticiaRepository.save(noticia);
    }

    @DeleteMapping("/noticias/{id}")
    public String deletarNoticia(@PathVariable Long id) {
        noticiaRepository.deleteById(id);
        return "Notícia com ID " + id + " deletada com sucesso!";
    }

    // --- GASTOS ---

    @GetMapping("/gastos")
    public List<Gasto> listarGastos() {
        return gastoRepository.findAllByOrderByDataGastoDesc();
    }

    @GetMapping("/gastos/total")
    public BigDecimal obterTotalGastos() {
        List<Gasto> gastos = gastoRepository.findAll();
        return gastos.stream()
                .map(Gasto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @PostMapping("/gastos")
    public Gasto criarGasto(@RequestBody Gasto gasto) {
        if (gasto.getDataGasto() == null) {
            gasto.setDataGasto(LocalDate.now());
        }
        return gastoRepository.save(gasto);
    }

    @DeleteMapping("/gastos/{id}")
    public String deletarGasto(@PathVariable Long id) {
        gastoRepository.deleteById(id);
        return "Gasto com ID " + id + " deletado com sucesso!";
    }

    // --- LICITAÇÕES (Novo!) ---

    // Buscar todas as licitações
    @GetMapping("/licitacoes")
    public List<Licitacao> listarLicitacoes() {
        return licitacaoRepository.findAll();
    }

    // Registrar uma nova licitação (Envia JSON do Bruno)
    @PostMapping("/licitacoes")
    public Licitacao criarLicitacao(@RequestBody Licitacao licitacao) {
        return licitacaoRepository.save(licitacao);
    }

    // Deletar uma licitação pelo ID
    @DeleteMapping("/licitacoes/{id}")
    public String deletarLicitacao(@PathVariable Long id) {
        licitacaoRepository.deleteById(id);
        return "Licitação com ID " + id + " deletada com sucesso!";
    }
}