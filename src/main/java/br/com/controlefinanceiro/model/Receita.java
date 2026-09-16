package br.com.controlefinanceiro.model;

public class Receita extends Movimentacao {

    public Receita(String descricao, Double valor, Categoria categoria) {
        super(descricao, valor, categoria);
    }

}