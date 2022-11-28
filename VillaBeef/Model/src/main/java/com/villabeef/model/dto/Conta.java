/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dto;

import java.sql.Date;

/**
 *
 * @author aluno
 */
public class Conta {
    private Date data;
    private char tipo; //e = entrada; s = saida;
    private double valor;

    public Conta(Date data, char tipo, double valor) {
        this.data = data;
        this.tipo = tipo;
        this.valor = tipo == 'e' ? valor : (valor * -1);
    }

    public void setData(String data) {
        this.data = Date.valueOf(data);
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
