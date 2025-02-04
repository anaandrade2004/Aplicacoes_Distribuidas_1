package rmi.GPC;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorConsultas extends Remote, Serializable {
    Consulta adicionarConsulta(Utente utente, Agente agente, String descricao) throws RemoteException;
    List<Consulta> listarConsultasPorUtente(Utente utente) throws RemoteException;
    List<Consulta> listarTodasConsultas() throws RemoteException;
    boolean removerConsulta(String idConsulta) throws RemoteException;
    public void adiconarReceita(Utente utente, Agente agente, Receita receita) throws RemoteException ;

}
