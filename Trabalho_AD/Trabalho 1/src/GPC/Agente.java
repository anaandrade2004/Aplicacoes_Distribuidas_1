package rmi.GPC;

import rmi.GLM.Medicamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agente implements Serializable {

    private String id;
    private String nome;
    private String cargo;
    private List<Consulta> consulta;
    private List<Receita> receita;
    private List<Medicamento> medicamento;

    public Agente() {
        this.id = null;
        this.nome = null;
        this.cargo = null;
        this.receita = null;
        this.medicamento = null;
        this.consulta = null;

    }

    public Agente(String id,String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.receita = new ArrayList<>();
        this.medicamento = new ArrayList<>();
        this.consulta = new ArrayList<>();
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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public List<Receita> getReceita() {
        return receita;
    }
    public void setReceita(Receita receita) {
        this.receita.add(receita);
    }
    public List<Medicamento> getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento.add(medicamento);
    }
    public List<Consulta> getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta.add(consulta);
    }



    @Override
    public String toString() {
        return "Agente " +
                " id: " + id + '\n' +
                " nome: " + nome + '\n' +
                " cargo: " + cargo + '\n'+
                " receita: " + receita +'\n' +
                " medicamento: " + medicamento +'\n';

    }

}

