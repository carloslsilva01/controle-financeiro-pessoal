package br.com.controlefinanceiro;

import br.com.controlefinanceiro.model.Categoria;
import br.com.controlefinanceiro.model.Movimentacao;
import br.com.controlefinanceiro.service.FinanceiroService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scNumero = new Scanner(System.in);
        Scanner scTexto = new Scanner(System.in);

        FinanceiroService servico = new FinanceiroService();

        while (true) {
            System.out.println("\n===== CONTROLE FINANCEIRO =====");
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
                    System.out.println("\n===== ADICIONAR RECEITA =====");
                    System.out.println("Insira a descrição:");
                    String descricao = scTexto.nextLine();
                    System.out.print("Insira o valor (R$): ");
                    Double valor = scNumero.nextDouble();
                    System.out.print("Insira a categoria: ");
                    String categoria = scTexto.nextLine();
                    Boolean resultado = servico.adicionarReceita(descricao, valor, Categoria.valueOf(categoria));
                    if(resultado) {
                        System.out.println("Receita cadastrada com sucesso!");
                    } else {
                        System.out.println("Houve um erro ao cadastrar a receita!");
                    }
                    break;
                case 2:
                    System.out.println("\n===== ADICIONAR DESPESA =====");
                    System.out.println("Insira a descrição:");
                    descricao = scTexto.nextLine();
                    System.out.print("Insira o valor: ");
                    valor = scNumero.nextDouble();
                    System.out.print("Insira a categoria: ");
                    categoria = scTexto.nextLine();
                    resultado = servico.adicionarDespesa(descricao, valor, Categoria.valueOf(categoria));
                    if(resultado) {
                        System.out.println("Despesa cadastrada com sucesso!");
                    } else {
                        System.out.println("Houve um erro ao cadastrar a despesa!");
                    }
                    break;
                case 3:
                    System.out.println("\n===== MOVIMENTAÇÕES =====");
                    List<Movimentacao> movimentacoes = servico.listarMovimentacoes();
                    for (int i = 0; i < movimentacoes.size(); i++) {
                        System.out.println("\n#" + (i + 1) + " - Movimentação");
                        System.out.println("ID: " + movimentacoes.get(i).getId());
                        System.out.println("Data: " + movimentacoes.get(i).getData());
                        System.out.println("Valor (R$): " + movimentacoes.get(i).getValor());
                        System.out.println("Categoria: " + movimentacoes.get(i).getCategoria());
                        System.out.println("Descrição: " + movimentacoes.get(i).getDescricao());
                        System.out.println("\n========================");
                    }
                    break;
                case 4:
                    System.out.println("\n===== SALDO =====");
                    Double saldo = servico.consultarSaldo();
                    System.out.printf("\nSaldo: R$ %.2f", saldo, "\n");
                    break;
                case 5:
                    System.out.println("\n===== BUSCA POR CATEGORIA =====");
                    System.out.print("Digite uma categoria: ");
                    categoria = scTexto.next();
                    Boolean valida = false;
                    for(Categoria c: Categoria.values()) {
                        if(c.equals(Categoria.valueOf(categoria))) {
                            valida =  true;
                            break;
                        }
                    }
                    if(!valida) {
                        System.out.println("Categoria Inexistente, tente novamente!");
                        break;
                    }
                    movimentacoes = servico.buscarPorCategoria(Categoria.valueOf(categoria));
                    for (int i = 0; i < movimentacoes.size(); i++) {
                        System.out.println("\n#" + (i + 1) + " - Movimentação");
                        System.out.println("ID: " + movimentacoes.get(i).getId());
                        System.out.println("Data: " + movimentacoes.get(i).getData());
                        System.out.println("Valor: " + movimentacoes.get(i).getValor());
                        System.out.println("Categoria: " + movimentacoes.get(i).getCategoria());
                        System.out.println("Descrição: " + movimentacoes.get(i).getDescricao());
                        System.out.println("\n========================");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
