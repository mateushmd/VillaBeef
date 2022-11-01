package com.villabeef.model.dto;

public class Usuario {
    
    private String login;
    private String senha;
    private Funcionario identificacao;

    public Usuario(String login, String senha, Funcionario identificacao) {
        this.login = login;
        this.senha = senha;
        this.identificacao = identificacao;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Funcionario getIdentificacao() {
        return identificacao;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdentificacao(Funcionario identificacao) {
        this.identificacao = identificacao;
    }
    
    
}
