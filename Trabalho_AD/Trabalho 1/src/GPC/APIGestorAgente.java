package rmi.GPC;

import rmi.GLM.Medicamento;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface APIGestorAgente extends Remote {
    public Map<String, Agente> getAgentes() throws RemoteException;
    public List<Agente> listagente() throws RemoteException;
    public void setAgentes(Map<String, Agente> agentes) throws RemoteException;
    public Agente getAgentePorNomeCargo(String nome, String cargo) throws RemoteException;
    public Agente addAgente(String id,String nome, String descricao) throws RemoteException;
    public void setConsulta(String id,Consulta consulta) throws RemoteException;
    public void setReceita(String id,Receita receita) throws RemoteException;
    public void setMedicamento(String id, Medicamento medicamento) throws RemoteException;
    public Agente getAgentePorId(String id) throws RemoteException;
    public Agente getAgenteporCargo(String cargo) throws RemoteException;
}


/*
123456
764321
234672
987654
123472
122888
457899
975432
134678
956432
 */