package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe que contém o método principal para executar o sistema de votação.
 */
public class Principal {
  /**
  * Método principal para executar o sistema de votação.
  */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean pergunta1 = true;
    boolean pergunta2 = true;
    boolean escolher = true;
    GerenciamentoVotacaoInterface gerenciamentoVotacao = new GerenciamentoVotacao();

    do {
      System.out.println(" Cadastrar pessoa candidata?");
      System.out.println(" 1 - Sim");
      System.out.println(" 2 - Não");
      System.out.println(" Entre com o número correspondente à opção desejada:");
      short cadastrarPessoaCandidata = scan.nextShort();
      if (cadastrarPessoaCandidata == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scan.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      } else if (cadastrarPessoaCandidata == 2) {
        pergunta1 = false;
      } else {
        System.out.println("Opção inválida!");
      }
    } while (pergunta1);

    do {
      System.out.println(" Cadastrar pessoa eleitora?");
      System.out.println(" 1 - Sim");
      System.out.println(" 2 - Não");
      System.out.println(" Entre com o número correspondente à opção desejada:");
      short cadastrarPessoaEleitora = scan.nextShort();
      if (cadastrarPessoaEleitora == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scan.next();
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpf = scan.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (cadastrarPessoaEleitora == 2) {
        pergunta2 = false;
      } else {
        System.out.println("Opção inválida!");
      }
    } while (pergunta2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println(" 1 - Votar");
      System.out.println(" 2 - Resultado Parcial");
      System.out.println(" 3 - Finalizar Votação");
      short opcao = scan.nextShort();

      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();
        gerenciamentoVotacao.votar(cpf, numero);
      } else if (opcao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (opcao == 3) {
        gerenciamentoVotacao.mostrarResultado();
        escolher = false;
      } else {
        System.out.println("Opção inválida!");
      }
    } while (escolher);
    scan.close();
  }

}
