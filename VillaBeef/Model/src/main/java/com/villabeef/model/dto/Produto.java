package com.villabeef.model.dto;

import java.util.Set;

public class Produto {
    private String marca;
    private String tipo;
    private String id;
    private int quantidade;
    private int quantidadeMinima;
    private int faltando;
    
    private Set<ItemProduto> itens;
    
    public Produto(String id, String marca, String tipo, int quantidade, int quantidadeMinima) {
        this.marca = marca;
        this.tipo = tipo;
        this.id = id;
        this.quantidadeMinima = quantidadeMinima;
        quantidade = this.quantidade;
        
    }
    
    public Produto(String id, String marca, String tipo) {
        this(id, marca, tipo, 0, 0);
    }
    
    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public Set<ItemProduto> getItens() {
        return itens;
    }
    
    public int getFaltando() {
        return faltando;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
    
    public void setFaltando(int faltando) {    
        this.faltando = faltando;
    }
}
