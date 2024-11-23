package com.betrybe.sistemadevotacao;

/**
 * Classe que contém o método pessoa eleitora para executar o sistema de votação.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * Classe que contém o método pessoa eleitora para executar o sistema de votação.
   */

  public PessoaEleitora(String nome, String cpf) {
    super.setNome(nome);
    this.cpf = cpf;
  }

}



