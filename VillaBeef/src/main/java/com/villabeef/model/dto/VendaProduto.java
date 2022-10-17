package com.villabeef.model.dto;

public class VendaProduto {
    
    private int idProduto;
    private int idVenda;
    private int quantidade;
    private double valor;

    public VendaProduto(int idProduto, int idVenda, int quantidade, double valor) {
        this.idProduto = idProduto;
        this.idVenda = idVenda;
        this.quantidade = quantidade;
        this.valor = valor;
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

    public double getValor() {
        return valor;
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

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
