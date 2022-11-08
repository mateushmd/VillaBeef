package com.villabeef.model.dto;

public class ItemProduto {
    private String id;
    private String idProduto = "";
    private String validade;
    private boolean vendido;
    private double valor;

    public ItemProduto(String id, String validade, double valor) {
        this.id = id;
        this.validade = validade;
        this.vendido = false;
        this.valor = valor;
    }


    public ItemProduto(String id, String idProduto, String validade, double valor) {
        this(id, validade, valor);
        
        this.idProduto = idProduto;
        
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
    
    

    public String getId() {
        return id;
    }

    public double getValor() {
        return valor;
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

    public String getIdProduto() {
        return idProduto;
    }   
}

