
package com.villabeef.model.dto;

public class OperadorCaixa extends Funcionario {
    
    private String descricao;
    
    public OperadorCaixa(String nome, double salario, double conta, String descricao) {
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
