package com.villabeef.model.dto;

public class Compra {   
    private int id;
    private String data;
    private Produto produto;

    public Compra(int id, String data, Produto produto) {
        this.id = id;
        this.data = data;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
