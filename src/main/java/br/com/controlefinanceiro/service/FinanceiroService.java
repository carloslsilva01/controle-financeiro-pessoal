package br.com.controlefinanceiro.service;

import br.com.controlefinanceiro.model.Categoria;
import br.com.controlefinanceiro.model.Despesa;
import br.com.controlefinanceiro.model.Movimentacao;
import br.com.controlefinanceiro.model.Receita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinanceiroService {

    private List<Movimentacao> movimentacoes;

    public FinanceiroService() {
        movimentacoes = new ArrayList<>();
    }

    public boolean adicionarReceita(String descricao, Double valor, Categoria categoria) {
        return movimentacoes.add(new Receita(descricao, valor, categoria));
    }

    public boolean adicionarDespesa(String descricao, Double valor, Categoria categoria) {
        return movimentacoes.add(new Despesa(descricao, valor, categoria));
    }

    public List<Movimentacao> listarMovimentacoes() {
        return Collections.unmodifiableList(movimentacoes);
    }

    public Double consultarSaldo() {
        Double valorDespesa = 0.0;
        Double valorReceita = 0.0;

        for (Movimentacao movimentacao : movimentacoes) {
            if(movimentacao instanceof Despesa) {
                valorDespesa += movimentacao.getValor();
            } else if(movimentacao instanceof Receita){
                valorReceita += movimentacao.getValor();
            }
        }

        return valorReceita - valorDespesa;
    }

    public List<Movimentacao> buscarPorCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new RuntimeException("Categoria está vazia!");
        }
        List<Movimentacao> movimentacoesCategoria = new ArrayList<>();
        for (Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getCategoria().equals(categoria)) {
                movimentacoesCategoria.add(movimentacao);
            }
        }
        return movimentacoesCategoria;
    }

}
