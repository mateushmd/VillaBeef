/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.service;

import com.villabeef.model.dao.EquipeDAO;
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
        EquipeDAO.inserir(new Funcionario(nome, salario, conta, funcao, cpf));
    }
    
    public static void alterar(Funcionario funcionario, Funcionario novo) throws ClassNotFoundException, SQLException {
        EquipeDAO.alterar(funcionario, novo);
    }   
    
    public static HashSet<Funcionario> listar() throws ClassNotFoundException, SQLException {
        return EquipeDAO.listar();
    }
    
    public static Funcionario obterPorId(String id) throws ClassNotFoundException, SQLException {
        return EquipeDAO.obterPorId(id);
    }
    
    public static HashSet<Funcionario> pesquisar(String pesquisa) throws ClassNotFoundException, SQLException {
        if(pesquisa.isBlank())
            return EquipeDAO.listar();

        return EquipeDAO.pesquisar(pesquisa);
    } 
    
    public static void excluir(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        EquipeDAO.excluir(funcionario);
    }
}
