        package com.villabeef.dto;

public class Funcionario extends Usuario{
    
    private String nome;
    private double salario;
    private double conta;        
    
    public Funcionario(String nome, double salario, double conta) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }
}


