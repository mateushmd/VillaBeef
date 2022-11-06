/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.service;

import com.villabeef.model.dao.Equipe;
import com.villabeef.model.dto.Funcionario;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author aluno
 */
public class ManterFuncionario {
    private ManterFuncionario() {}
    
    public static void adicionar(String nome, double salario, String conta, String funcao, String cpf) throws ClassNotFoundException, SQLException {
        Equipe.inserir(new Funcionario(nome, salario, conta, funcao, cpf));
    }
    
    public static void alterar(Funcionario funcionario, Funcionario novo) throws ClassNotFoundException, SQLException {
        Equipe.alterar(funcionario, novo);
    }   
    
    public static HashSet<Funcionario> listar() throws ClassNotFoundException, SQLException {
        return Equipe.listar();
    }
    
    public static Funcionario obterPorId(String id) throws ClassNotFoundException, SQLException {
        return Equipe.obterPorId(id);
    }
    
    public static HashSet<Funcionario> pesquisar(String pesquisa, int modo) throws ClassNotFoundException, SQLException {
        if(pesquisa.isBlank())
            return Equipe.listar();

        return Equipe.pesquisar(pesquisa, modo);
    } 
}