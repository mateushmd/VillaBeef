package com.villabeef.model.dto;

public class Funcionario{
    
    private String nome;
    private double salario;
    private double conta;
    private String tipo;
    private int id;
    
    
    public Funcionario(String nome, double salario, double conta, String tipo, int id) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
        this.tipo = tipo;
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
    
    public double getSalario() {
        return salario;
    }

    public double getConta() {
        return conta;
    }
    
    public String getTipo() {
        return tipo;
}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
        public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}


