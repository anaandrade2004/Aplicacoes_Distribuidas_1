package rmi.GPC;

import rmi.GLM.Medicamento;

import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class GestorReceitas extends UnicastRemoteObject implements Serializable, APIGestorReceitas {

    private Map<String, Receita> receitas;


    public GestorReceitas() throws RemoteException {
        super(); // Seria as classes do Objeto
        receitas = new HashMap<>();
    }
    public Map<String, Receita> getReceitas() throws RemoteException {
        return receitas;
    }

    public void setReceitas(Map<String, Receita> receitas) throws RemoteException {
        this.receitas = receitas;
    }


    public Receita getReceita(String id) throws RemoteException {
        return receitas.get(id);
    }


    public Receita addReceita(Utente utente, Agente agente, Consulta consulta, List<Medicamento> medicamentos) throws RemoteException {
        Receita receita = new Receita(utente, agente, consulta, medicamentos);

        return receita;
    }


}
