package br.com.controlefinanceiro;

import br.com.controlefinanceiro.model.Categoria;
import br.com.controlefinanceiro.service.FinanceiroService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scNumero = new Scanner(System.in);
        Scanner scTexto = new Scanner(System.in);

        FinanceiroService servico = new FinanceiroService();

        while (true) {
            System.out.println("===== CONTROLE FINANCEIRO =====");
            System.out.println("1. Adicionar receita");
            System.out.println("2. Adicionar despesa");
            System.out.println("3. Listar movimentações");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Buscar por categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            Integer opcao = scNumero.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("===== ADICIONAR RECEITA =====");
                    System.out.println("Insira a descrição:");
                    String descricao = scTexto.nextLine();
                    System.out.print("Insira o valor: ");
                    Double valor = scNumero.nextDouble();
                    System.out.print("Insira a categoria: ");
                    String categoria = scTexto.nextLine();
                    Boolean resultado = servico.adicionarReceita(descricao, valor, Categoria.valueOf(categoria));
                    if(resultado) {
                        System.out.println("Certo!");
                    } else {
                        System.out.println("Erro!");
                    }
            }
        }
    }
}
