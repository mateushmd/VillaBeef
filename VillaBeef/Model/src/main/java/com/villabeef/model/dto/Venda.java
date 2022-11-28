package com.villabeef.model.dto;

import java.util.HashSet;
import java.util.Set;

public class Venda {
    
    private int id;
    private String data;
    private HashSet<ItemProduto> itens;
    
    public Venda(int id, String data, HashSet<ItemProduto> itens) {
        this.id = id;
        this.data = data;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public HashSet<ItemProduto> getItens() {
        return itens;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setItens(HashSet<ItemProduto> itens) {
        this.itens = itens;
    }
}
