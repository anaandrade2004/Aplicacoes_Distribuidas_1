package rmi.GPC;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utente implements Serializable {
  private String id; //numero de saude
  private String nome; //nome do utente
  private String apelido; //apelido do utente
  private String genero; //genero do utente
  private LocalDate dataNascimento; //data de nascimento do utente
  private String morada; // morada do utente
  private String telemovel; // telemovel do utente
  private String email; // email do utente
  private List<Receita> receitas; // lista de apontadores para as receitas do cliente
  private List<Consulta> consultas; // lista de apontadores para as consultas do cliente



  public Utente() {
    this.id = "";
    this.nome = "";
    this.apelido = "";
    this.genero = "";
    this.dataNascimento = null;
    this.morada = "";
    this.telemovel = "";
    this.email = "";
    this.receitas = new ArrayList<>();
    this.consultas = new ArrayList<>();
  }

  public Utente(String id, String nome, String apelido, String genero, LocalDate dataNascimento, String morada, String telemovel, String email) {
    this.id = id;
    this.nome = nome;
    this.apelido = apelido;
    this.genero = genero;
    this.dataNascimento = dataNascimento;
    this.morada = morada;
    this.telemovel = telemovel;
    this.email = email;
    this.receitas = new ArrayList<>();
    this.consultas = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getMorada() {
    return morada;
  }

  public void setMorada(String morada) {
    this.morada = morada;
  }

  public String getTelemovel() {
    return telemovel;
  }

  public void setTelemovel(String telemovel) {
    this.telemovel = telemovel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public List<Receita> getReceitas() {
    return receitas;
  }
  public void setReceitas(Receita receita) {
    receitas.add(receita);
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }
  public void setConsultas(Consulta consulta) {
    consultas.add(consulta);
  }


  @Override
  public String toString() {
    return "Utente " +
             id + '\n' +
            "  nome=" + nome + '\n' +
            "  apelido=" + apelido + '\n' +
            "  genero=" + genero + '\n' +
            "  dataNascimento=" + dataNascimento + '\n' +
            "  morada=" + morada + '\n' +
            "  telemovel=" + telemovel + '\n' +
            "  email='" + email + '\n' +
            "  receitas=" + receitas +'\n'+
            "  consultas=" + consultas + '\n';
  }


}
