package br.com.controlefinanceiro.model;

public class Despesa extends Movimentacao {

    public Despesa(String descricao, Double valor, Categoria categoria) {
        super(descricao, valor, categoria);
    }

}