package com.villabeef.model.dto;

public class Funcionario{
    
    private String nome;
    private double salario;
    private int conta;
    private String funcao;
    private int id;
    
    
    public Funcionario(String nome, double salario, int conta, String funcao, int id) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
        this.funcao = funcao;
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

    public int getConta() {
        return conta;
    }
    
    public String getTipo() {
        return funcao;
}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTipo(String funcao) {
        this.funcao = funcao;
    }
    
}


