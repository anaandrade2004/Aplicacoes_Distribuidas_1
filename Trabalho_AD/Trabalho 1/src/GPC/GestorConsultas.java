package rmi.GPC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorConsultas extends UnicastRemoteObject implements Serializable, APIGestorConsultas {

    private Map<String, Consulta> consultas;

    public GestorConsultas() throws RemoteException {
        super();  // Necessário para UnicastRemoteObject
        this.consultas = new HashMap<>();
    }

    @Override
    public Consulta adicionarConsulta(Utente utente, Agente agente, String descricao) {
        Consulta consulta = new Consulta(utente, agente, descricao);
        consultas.put(consulta.getIdConsulta(), consulta);
        return consulta;
    }



    @Override
    public List<Consulta> listarConsultasPorUtente(Utente utente) throws RemoteException {
        List<Consulta> consultasUtente = new ArrayList<>();
        for (Consulta consulta : consultas.values()) {
            if (consulta.getUtente().getId().equals(utente.getId())) {
                consultasUtente.add(consulta);
            }
        }
        return consultasUtente;
    }

    @Override
    public List<Consulta> listarTodasConsultas() throws RemoteException {
        return new ArrayList<>(consultas.values());
    }

    @Override
    public boolean removerConsulta(String idConsulta) throws RemoteException { //se remover responde true e se não responde false
        return consultas.remove(idConsulta) != null;
    }

    @Override
    public void adiconarReceita(Utente utente, Agente agente, Receita receita) throws RemoteException {
        for (Consulta c : this.consultas.values()) {
            if (c.getUtente().equals(utente) && c.getAgente().equals(agente)) {

                    c.setReceita(receita);


            }
        }



    }







}

