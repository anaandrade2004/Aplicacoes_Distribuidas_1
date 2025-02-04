package rmi.GPC;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;
import java.rmi.Remote;

public interface APIGestorUtente extends Remote{
    public Utente create_utente(String id, String nome, String apelido, String genero, LocalDate dataNascimento, String morada, String telemovel, String email) throws RemoteException;
    public Utente getUtente(String id) throws RemoteException;
    public List<Utente> getUtentes() throws RemoteException;
    public List<Consulta> getConsultas(String id) throws RemoteException;
    public void setConsulta(String id, Consulta consulta) throws RemoteException;
    public List<Receita> getReceitas(String id) throws RemoteException;
    public void setReceita(String id, Receita receita) throws RemoteException;
    public void alteraUtenteMorada(String id, String morada) throws RemoteException;
    public void alteraUtenteTelemovel(String id, String telemovel) throws RemoteException;
    public void alteraUtenteemail(String id, String email)  throws RemoteException;
    public void alteraUtente(String id, Utente utente) throws RemoteException;

}


