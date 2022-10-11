package com.villabeef.model.dto;

public class Gerente extends Funcionario{

    private String descricao;
    
    public Gerente(String nome, double salario, double conta, String descricao) {
        super(nome, salario, conta);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}