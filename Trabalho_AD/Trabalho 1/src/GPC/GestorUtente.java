package rmi.GPC;

import javax.swing.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.*;

public class GestorUtente extends UnicastRemoteObject implements APIGestorUtente, Serializable {
    private Map<String, Utente> utentes;

    public GestorUtente() throws RemoteException {
        super();  // Necessário para UnicastRemoteObject
        this.utentes = new HashMap<>();
    }

    @Override
    public Utente create_utente(String id, String nome, String apelido, String genero, LocalDate dataNascimento, String morada, String telemovel, String email) throws RemoteException {
        Utente nu = new Utente(id, nome, apelido, genero, dataNascimento, morada, telemovel, email);
        System.out.println(nu);
        this.utentes.put(id, nu);
        return nu;
    }


    @Override
    public Utente getUtente(String id) throws RemoteException {
        return this.utentes.get(id);
    }

    @Override
    public List<Utente> getUtentes() throws RemoteException {
        return this.utentes.values().stream().toList();
    }

    @Override
    public List<Consulta> getConsultas(String id) throws RemoteException {
        return utentes.get(id).getConsultas();
    }

    @Override
    public void setConsulta(String id, Consulta consulta) throws RemoteException {
        for (Utente u : this.utentes.values()) {
            if (u.getId().equals(id)) {
                u.setConsultas(consulta);


            }
        }

    }

    @Override
    public List<Receita> getReceitas(String id) throws RemoteException {
        for (Utente u : this.utentes.values()) {
            if (u.getId().equals(id)) {
                return u.getReceitas();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void setReceita(String id, Receita receita) throws RemoteException {
        for (Utente u : this.utentes.values()) {
            if (u.getId().equals(id)) {
                u.setReceitas(receita);
            }
        }
    }


    @Override
    public void alteraUtenteMorada(String id, String morada) throws RemoteException {
        if (utentes.containsKey(id)) {
            utentes.get(id).setMorada(morada);
        }
    }

    @Override
    public void alteraUtenteTelemovel(String id, String telemovel) throws RemoteException {
        if (utentes.containsKey(id)) {
            utentes.get(id).setTelemovel(telemovel);
        }
    }

    @Override
    public void alteraUtenteemail(String id, String email) throws RemoteException {
        if (utentes.containsKey(id)) {
            utentes.get(id).setEmail(email);
        }
    }

    // trocar isto porque chave id não vai corresponder ao id no utente

    @Override
    public void alteraUtente(String id, Utente utente) throws RemoteException {
        if (utentes.containsKey(id)) {
            utentes.put(id, utente);
        }
    }

}