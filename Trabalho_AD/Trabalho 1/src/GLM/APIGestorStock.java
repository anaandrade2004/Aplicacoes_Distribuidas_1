package rmi.GLM;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorStock extends Remote {
    public Stock addMedicamento(String id, Medicamento medicamento, int s_min, int s_max, int s_total,String forncedor) throws RemoteException;
    public void addforncedor(String n_medicamento,String forncedor) throws RemoteException;
    public Stock addToStock(String id, int quantity) throws RemoteException;
    public Stock useFromStock(String id, int quantity) throws RemoteException;
    public Stock getStock(String id) throws RemoteException;
    public Stock getStockPorNome(String nome) throws RemoteException;
    public List<Stock> getAllStock() throws RemoteException;
}
