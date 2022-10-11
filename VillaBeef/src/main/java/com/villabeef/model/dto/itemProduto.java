package com.villabeef.model.dto;

public class itemProduto {
    private int id;
    private int idProduto;
    private String validade;
    private boolean vendido;

    public itemProduto(int id, int idProduto, String validade) {
        this.id = id;
        this.idProduto = idProduto;
        this.validade = validade;
        this.vendido = false;
        
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdProduto() {
        return idProduto;
    }

    public String getValidade() {
        return validade;
    }

    public boolean isVendido() {
        return vendido;
    }
}
