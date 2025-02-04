package rmi.GLM;

import java.io.Serializable;
import java.util.UUID;

public class Medicamento implements Serializable {

    private String id;              //identificador único do medicamento
    private String nome;            //nome do medicamento
    private String descricao;       //descrição -> uso (via oral, vacina, gramas, ...)

    public Medicamento() {
        this.id = UUID.randomUUID().toString();
        this.nome = "";
        this.descricao = "";
    }

    public Medicamento(String nome, String descricao) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao = descricao;
    }



    public String getID() { return id;}
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Medicamento " +
                "id=" + this.id + '\n' +
                "  nome=" + this.nome + '\n' +
                "  descricao=" + this.descricao + '\n';

    }


}
