package com.villabeef.model.dto;

import java.util.HashSet;
import java.util.Set;

public class Produto {
    private String marca;
    private String tipo;
    private int id;
    private int quantidade;
    private int quantidadeMinima;
    
    private Set<ItemProduto> itens;
    
    public Produto(, String marca, String tipo, int quantidade, int quantidadeMinima) {
        this.marca = marca;
        this.tipo = tipo;
        this.id = id;
        this.quantidadeMinima = quantidadeMinima;
        this.itens = itens;
        quantidade = this.itens.size();
        
    }
    
    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId() {
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
}
