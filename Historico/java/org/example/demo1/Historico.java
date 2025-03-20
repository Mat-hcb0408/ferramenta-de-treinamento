package org.example.demo1;

public class Historico {

    private String data;
    private String descricao;
    private String valor;
    private String status; // "feito" ou "pendente"

    public Historico(String data, String descricao, String valor, String status) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
