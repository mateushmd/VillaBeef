package com.villabeef.model.dto;

public class Vendas {
    
    private int id;
    private String data;

    public Vendas(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
