package rmi.GPC;

import rmi.GLM.Medicamento;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.rmi.Remote;


public interface APIGestorReceitas extends Remote{
    public Map<String, Receita> getReceitas() throws RemoteException;
    public Receita getReceita(String receita) throws RemoteException;
    public void setReceitas(Map<String, Receita> receitas) throws RemoteException;
    public Receita addReceita(Utente utente, Agente agente, Consulta consulta, List<Medicamento> medicamentos) throws RemoteException;

}
