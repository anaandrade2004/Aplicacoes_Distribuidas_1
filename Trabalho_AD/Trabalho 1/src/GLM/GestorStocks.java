package rmi.GLM;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.rmi.server.UnicastRemoteObject;

public class GestorStocks extends UnicastRemoteObject implements Serializable, APIGestorStock {
    private Map<String, Stock> stocks;


    public GestorStocks() throws RemoteException {
        super(); // Seria as classes do Objeto
        stocks = new HashMap<>();
    }

    @Override
    public Stock addMedicamento(String id, Medicamento medicamento, int s_min, int s_max, int s_total,String fornecedor) throws RemoteException {
        Stock ns = new Stock(id,medicamento, s_min, s_max, s_total,fornecedor);
        this.stocks.put(id, ns);
        return ns;
    }

    @Override
    public void addforncedor(String nome, String forncedor) throws RemoteException {
        for (Stock stock : stocks.values()) {
            if (stock.getMedicamento().getNome().equals(nome)) {
                stock.setFornecedor(forncedor);
            }
        }
    }

    @Override
    public Stock addToStock(String id, int quantity) throws RemoteException {
        Stock s = stocks.get(id);
        int s_tot = s.getS_total();
        int max = s.getS_max();
        s_tot=s_tot + quantity;
        if (s_tot>max) {
            s.setS_total(max);
        }else {
            s.setS_total(s_tot);
        }
        return s;
    }

    @Override
    public Stock useFromStock(String id, int quantity) throws RemoteException {
        Stock s = stocks.get(id);
        int s_tot = s.getS_total();
        int min = s.getS_min();
        s_tot=s_tot - quantity;
        s.setS_total(s_tot);
        return s;
    }

    @Override
    public Stock getStock(String id) throws RemoteException {

        for (Stock stock : stocks.values()) {
            if (stock.getId().equals(id)) {
                return stocks.get(id);
            }
        }
        return null;
    }

    @Override
    public List<Stock> getAllStock() throws RemoteException {
        return new ArrayList<>(this.stocks.values());
    }
    @Override
    public Stock getStockPorNome(String nome) throws RemoteException {
        for (Stock stock : stocks.values()) {
            if (stock.getMedicamento().getNome().equals(nome)) {
                return stocks.get(stock.getId());
            }
        }
        return null;
    }
}
