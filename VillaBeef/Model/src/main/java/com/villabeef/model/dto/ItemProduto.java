package com.villabeef.model.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ItemProduto {
    private String id;
    private String idProduto = "";
    private Date validade;
    private boolean vendido;
    private double valor;

    public ItemProduto(String id, Date validade, double valor) {
        this.id = id;
        this.validade = validade;
        this.vendido = false;
        this.valor = valor;
    }


    public ItemProduto(String id, String idProduto, Date validade, double valor) {
        this(id, validade, valor);
        
        this.idProduto = idProduto;
        
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setValidade(Date validade) {
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(validade);
    }
    
    public Date getValidadeAsDate() {
        return validade;
    }
    
    public String getValidadeSQL() {
        return validade.toString();
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

