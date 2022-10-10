package com.villabeef.dto;

public class Produto {
    private String marca;
    private String tipo;
    private int id;
    private double preco;
    private String validade;
    private double peso;

    public Produto(String marca, String tipo, int id, double preco, String validade, double peso) {
        this.marca = marca;
        this.tipo = tipo;
        this.id = id;
        this.preco = preco;
        this.validade = validade;
        this.peso = peso;
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

    public double getPreco() {
        return preco;
    }

    public String getValidade() {
        return validade;
    }

    public double getPeso() {
        return peso;
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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
