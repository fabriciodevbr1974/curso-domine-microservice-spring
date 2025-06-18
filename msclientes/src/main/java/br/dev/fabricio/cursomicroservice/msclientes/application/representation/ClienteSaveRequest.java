package br.dev.fabricio.cursomicroservice.msclientes.application.representation;

import br.dev.fabricio.cursomicroservice.msclientes.domain.Cliente;

public class ClienteSaveRequest {

  private String cpf;
  private String nome;
  private Integer idade;

  public Cliente toModel() {
    return new Cliente(cpf, nome, idade);
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }
}
