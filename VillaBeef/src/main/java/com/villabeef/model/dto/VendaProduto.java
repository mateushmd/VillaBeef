package com.villabeef.model.dto;

public class VendaProduto {
    
    private int idProduto;
    private int idVenda;
    private int quantidade;

    public VendaProduto(int idProduto, int idVenda, int quantidade) {
        this.idProduto = idProduto;
        this.idVenda = idVenda;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
