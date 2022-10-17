package com.villabeef.model.dto;

public class Funcionario{
    
    private String nome;
    private double salario;
    private double conta;
    private String tipo;
    
    
    public Funcionario(String nome, double salario, double conta, String tipo) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
        this.tipo = tipo;
        
    }


    public String getNome() {
        return nome;
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
    
        public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}


