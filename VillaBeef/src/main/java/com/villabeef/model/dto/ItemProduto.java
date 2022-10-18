package com.villabeef.model.dto;

public class ItemProduto {
    private int id;
    private int idProduto;
    private String validade;
    private boolean vendido;
    private double valor;

    public ItemProduto(int id, int idProduto, String validade, double valor) {
        this.id = id;
        this.idProduto = idProduto;
        this.validade = validade;
        this.vendido = false;
        this.valor = valor;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getValidade() {
        return validade;
    }

    public boolean estaVendido() {
        return vendido;
    }
    
    public boolean estaVencido() {
        return false;
    }
}

