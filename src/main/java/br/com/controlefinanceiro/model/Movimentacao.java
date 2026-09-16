package br.com.controlefinanceiro.model;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Movimentacao {

    private Integer id;
    private String descricao;
    private Double valor;
    private LocalDate data;
    private Categoria categoria;

    public Movimentacao(String descricao, Double valor, Categoria categoria) {
        id = ThreadLocalRandom.current().nextInt(1, 1001);
        data = LocalDate.now();
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }
}
