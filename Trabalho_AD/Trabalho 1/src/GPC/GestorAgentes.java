package rmi.GPC;

import rmi.GLM.Medicamento;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorAgentes extends UnicastRemoteObject implements Serializable, APIGestorAgente {

    private Map<String, Agente> agentes;

    public GestorAgentes() throws RemoteException {
        super();
        agentes = new HashMap<>();
    }
    public Map<String, Agente> getAgentes() throws RemoteException {
        return agentes;
    }
    @Override
    public List<Agente> listagente() throws RemoteException {
        return this.agentes.values().stream().toList();
    }
    public void setAgentes(Map<String, Agente> agentes) throws RemoteException {
        this.agentes = agentes;
    }

    public Agente getAgentePorNomeCargo(String nome ,String cargo) throws RemoteException {
        for (Agente a : this.agentes.values()) {
            if (a.getNome().equals(nome) && a.getCargo().equals(cargo)) {
                return a;
            }
        }
        return null;
    }
    public Agente getAgenteporCargo(String cargo) throws RemoteException {
        for (Agente a : this.agentes.values()) {
            if (a.getCargo().equals(cargo)) {
                return a;
            }
        }
        return null;
    }
    public Agente getAgentePorId(String id) throws RemoteException {
        return agentes.get(id);
    }

    public Agente addAgente(String id,String nome, String descricao) throws RemoteException {
        Agente agente = new Agente(id,nome, descricao);
        agentes.put(agente.getId(), agente);
        return agente;
    }

    @Override
    public void setConsulta(String id, Consulta consulta) throws RemoteException {
        for (Agente a : this.agentes.values()) {
            if (a.getId().equals(id)) {
                a.setConsulta(consulta);
            }
        }
    }

    @Override
    public void setReceita(String id, Receita receita) throws RemoteException {
        for (Agente a : this.agentes.values()) {
            if (a.getId().equals(id)) {
                a.setReceita(receita);
            }
        }
    }

    @Override
    public void setMedicamento(String id, Medicamento medicamento) throws RemoteException {
        for (Agente a : this.agentes.values()) {
            if (a.getId().equals(id)) {
                a.setMedicamento(medicamento);
            }
        }
    }


}
