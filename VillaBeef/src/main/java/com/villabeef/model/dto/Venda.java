package com.villabeef.model.dto;

import java.util.HashSet;
import java.util.Set;

public class Venda {
    
    private int id;
    private String data;
    private Set<Produto> produtos;
    
    public Venda(int id, String data, HashSet<Produto>produtos) {
        this.id = id;
        this.data = data;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setProdutos(HashSet<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
