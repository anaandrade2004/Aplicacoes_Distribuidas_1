package rmi.GPC;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Consulta implements Serializable {
    // Variáveis de instância
    private String idConsulta;             // Identificação única da consulta
    private Utente utente;                 // Paciente
    private Agente agente;                 // Médico, enfermeiro, farmacêutico
    private LocalDateTime dataHora;        // Data e hora da consulta
    private String descricao;              // Descrição do ato (livre ou código de medicamento)
    private List<Receita> receitas;         // Receita associada à consulta (se houver)

    // Construtor da classe

    public Consulta() {
        this.idConsulta = UUID.randomUUID().toString();
        this.utente = null;
        this.agente = null;
        this.dataHora = null;
        this.descricao = "";
        this.receitas = new ArrayList<>();
    }


    public Consulta(Utente utente, Agente agente, String descricao) {
        this.idConsulta = UUID.randomUUID().toString();
        this.utente = utente;
        this.agente = agente;
        this.dataHora = LocalDateTime.now();
        this.descricao = descricao;
        this.receitas = new ArrayList<>();
    }

    // Métodos de acesso (getters e setters)
    public String getIdConsulta() {
        return idConsulta;
    }

    public Utente getUtente() {
        return utente;
    }

    public Agente getAgente() {
        return agente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
    public List<Receita> getReceita() {
        return receitas;
    }

    public void setReceita(Receita receita) {
        receitas.add(receita);
    }


    @Override
    public String toString() {
        return "Consulta  " +
                "ID: '" + idConsulta + '\'' +
                ", Utente: " + utente.getId() +
                ", Agente: " + agente.getNome() +
                ", DataHora: " + dataHora +
                ", Descrição: '" + descricao + '\'' +
                (receitas != null ? ", Receita: " + receitas : ", Receita: N/A") + '\n'; // verifica se a receita existe ou não;
    }
}



