package com.villabeef.model.dto;

public class Funcionario{
    
    private String nome;
    private double salario;
    private String conta;
    private String funcao;
    private String id;
    
    
    public Funcionario(String nome, double salario, String conta, String funcao, String id) {
        this.nome = nome;
        this.salario = salario;
        this.conta = conta;
        this.funcao = funcao;
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
    
    public double getSalario() {
        return salario;
    }

    public String getConta() {
        return conta;
    }
    
    public String getFuncao() {
        return funcao;
}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setTipo(String funcao) {
        this.funcao = funcao;
    }
    
}


