package rmi.GLM;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorMedicamentos extends Remote {
    public List<Medicamento> procurarMedicamentoPorNome(String nome) throws RemoteException;
    public List<Medicamento> listarMedicamentos() throws RemoteException;
    public List<String> listarMedicamentosPorNome() throws RemoteException;
    public Medicamento procurarMedicamentoPorId(String id) throws RemoteException;
    public Medicamento getMedicamentoporNome(String nome) throws RemoteException;
    public Medicamento addMedicamento(String nome, String descricao) throws RemoteException;
}
