package com.betrybe.sistemadevotacao;

/**
 * complementa a pessoa incluindo numerodecandidato.
 *
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos++;
  }

  /**
   * Classe que contém o método de gerar candidatos para executar o sistema de votação.
   */
  public PessoaCandidata(String nome, int numero) {
    super.setNome(nome);
    this.numero = numero;
    this.votos = 0;
  }



}
