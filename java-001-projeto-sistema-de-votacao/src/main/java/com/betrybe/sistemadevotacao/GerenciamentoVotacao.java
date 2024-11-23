package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 *
 * <p>
 * .classe geral que contem metodos.
 * </p>
 * author joao.
 *
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();

  private ArrayList<String> cpfsComputados = new ArrayList<String>();


  /**
   * .metodo para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * .metodo para cadastrar pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * .metodo para votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpfPessoaEleitora)) {
        for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
          if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
            pessoaCandidata.receberVoto();
            cpfsComputados.add(cpfPessoaEleitora);
            return;
          }
        }
      }
    }
    System.out.println("CPF ou número de candidato inválido");
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    int totalVotos = cpfsComputados.size();
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      String nome = pessoaCandidata.getNome();
      int votos = pessoaCandidata.getVotos();
      int percentual = Math.round((float) votos / totalVotos * 100);
      System.out.println("Nome: " + nome + " - " + votos + " votos ( " + percentual + "% )");
    }

    System.out.println("Total de votos: " + totalVotos);
  }

  public GerenciamentoVotacao() {
    // TODO Auto-generated constructor stub
  }

}




