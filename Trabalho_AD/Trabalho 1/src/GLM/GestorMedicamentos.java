package rmi.GLM;

import rmi.GPC.Agente;
import rmi.GPC.Consulta;
import rmi.GPC.Receita;
import rmi.GPC.Utente;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class GestorMedicamentos extends UnicastRemoteObject implements Serializable, APIGestorMedicamentos {

    private Map<String, Medicamento> medicamentos;

    public GestorMedicamentos() throws RemoteException {
        super();
        medicamentos = new HashMap<>();
    }

    @Override
    public List<Medicamento> procurarMedicamentoPorNome(String nome) throws RemoteException {
        List<Medicamento> res = new ArrayList<>();
        for (Medicamento m : medicamentos.values()) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                res.add(m);
            }
        }
        return res;
    }

    @Override
    public List<Medicamento> listarMedicamentos() throws RemoteException {
        return new ArrayList<>(this.medicamentos.values());

    }

    @Override
    public List<String> listarMedicamentosPorNome() throws RemoteException {
        List<String> res = new ArrayList<>();
        for (Medicamento m : medicamentos.values()) {
            res.add(m.getNome());

        }
        return res;
    }

    @Override
    public Medicamento procurarMedicamentoPorId(String id) throws RemoteException {
        return medicamentos.get(id);
    }

    @Override
    public Medicamento addMedicamento(String nome, String descricao) throws RemoteException {
        Medicamento novomedicamento = new Medicamento(nome, descricao);
        medicamentos.put(novomedicamento.getNome(), novomedicamento);
        return novomedicamento;
    }

    @Override
    public Medicamento getMedicamentoporNome(String nome) throws RemoteException {
        for (Medicamento m : medicamentos.values()) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

}
