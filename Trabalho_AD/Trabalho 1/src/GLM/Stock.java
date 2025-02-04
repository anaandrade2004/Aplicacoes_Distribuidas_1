package rmi.GLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Serializable {
    private String id;
    private Medicamento medicamento;
    private int s_min;
    private int s_max;
    private int s_total;
    private List<String> fornecedor;

    public Stock() {
        this.id = "";
        this.medicamento = null;
        this.s_min = 0;
        this.s_max = 0;
        this.s_total = 0;
        this.fornecedor = new ArrayList<>();
    }

    public Stock(String id, Medicamento medicamento, int s_min, int s_max, int s_total,String fornecedor) {
        this.id = id;
        this.medicamento = medicamento;
        this.s_min = s_min;
        this.s_max = s_max;
        this.s_total = s_total;
        this.fornecedor = new ArrayList<>();
        this.fornecedor.add(fornecedor);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getS_min() {
        return s_min;
    }

    public void setS_min(int s_min) {
        this.s_min = s_min;
    }

    public int getS_max() {
        return s_max;
    }

    public void setS_max(int s_max) {
        this.s_max = s_max;
    }

    public int getS_total() {
        return s_total;
    }

    public void setS_total(int s_total) {
        this.s_total = s_total;
    }

    public List<String> getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor.add(fornecedor);
    }

    @Override
    public String toString() {
        return "Stock " + id + '\n' +
                "  " + medicamento + '\n' +
                "  s_min=" + s_min + '\n' +
                "  s_max=" + s_max + '\n' +
                "  s_total=" + s_total +'\n'+
                "  fornecedor=" + fornecedor + '\n';

    }
}
