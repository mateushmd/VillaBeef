package com.villabeef.model.dto;

public class Compra {   
    private String id;
    private String data;
    private Produto produto;
    private double valor;

    public Compra(String id, String data, Produto produto, double valor) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
