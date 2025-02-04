package rmi.GPC;

import rmi.GLM.Medicamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Receita implements Serializable {

    private String id;          //id de identificação da receita
    private Utente utente;              //infos do utente a que está associado
    private Agente agente;              //infos do profissional que prescreveu a receita
    private Consulta consulta;          //consulta associada
    private List<Medicamento> medicamentos; //explicar isto relatório -> medicamentos é o código dos medicamentos

    //boa prática: ter mais do que um construtor -> criamos a receita e ainda não sabemos o médico que a prescreveu, ou o utente, descrição ...
    public Receita() {
        this.id = UUID.randomUUID().toString();
        this.utente = null;
        this.agente = null;
        this.consulta = null;
        this.medicamentos = null;
    }
    public Receita( Utente utente, Agente agente, Consulta consulta) {
        this.id = UUID.randomUUID().toString();     // Gera um ID único, automaticamente
        this.utente = utente;
        this.agente = agente;
        this.consulta = consulta;
        this.medicamentos = new ArrayList<Medicamento>();

    }

    public Receita( Utente utente, Agente agente, Consulta consulta, List<Medicamento> medicamento) {
        this.id = UUID.randomUUID().toString();     // Gera um ID único, automaticamente
        this.utente = utente;
        this.agente = agente;
        this.consulta = consulta;
        this.medicamentos = medicamento;

    }

    public Receita( Utente utente, Agente agente, List<Medicamento> medicamento) {
        this.id = UUID.randomUUID().toString();     // Gera um ID único, automaticamente
        this.utente = utente;
        this.agente = agente;
        this.medicamentos= medicamento;
    }


    public Receita(Utente utente, Agente agente) {
        this.id = UUID.randomUUID().toString();
        this.utente = utente;
        this.agente = agente;
        this.consulta = null;
    }

    public String getID() {
        return id;
    }
    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public Agente getAgente() {
        return agente;
    }
    public void setAgente(Agente agente) {
        this.agente = agente;
    }
    public Consulta getConsulta() {
        return consulta;
    }

    public void setconsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }

    @Override
    public String toString() {
        return "Receita" +'\n'+
                "  referencia='" + id + '\n' +
                "  utente=" + utente + '\n' +
                "  agente=" + agente + '\n' +
                "  consulta=" + consulta + '\n' +
                "  medicamentos=" + medicamentos + '\n';
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
