package com.villabeef.model.dto;

public class Produto {
    private String marca;
    private String tipo;
    private int id;
    private int quantidade;
    
    public Produto(String marca, String tipo, int id) {
        this.marca = marca;
        this.tipo = tipo;
        this.id = id;
        quantidade = 0;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
}
