/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Funcionario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Equipe {
    private Equipe() {}
    
    private static Set<Funcionario> funcionarios;
    
    static {
        funcionarios = new HashSet<>();
    }
    
    public static boolean inserir(Funcionario funcionario) {
        Connection conexao = ConexaoBD.getConexao();
        
        String sql = "INSERT INTO equipe VALUES('" + funcionario.getId() + "', '" + funcionario.getNome() + "', '" + 
                funcionario.getTipo() + "', '" + funcionario.getSalario() + "', '" + funcionario.getConta() + "')";
        
        try {
            Statement stmt = conexao.createStatement();
            
            int resultado = stmt.executeUpdate(sql);
            
            return resultado > 0;
        } catch (SQLException ex) {
            System.out.println("Não foi possível criar uma statement");
        }
        
        return false;
    }
    
    public static boolean alterar(Funcionario funcionario, Funcionario novo) {
        boolean status = excluir(funcionario);
        
        if(status)
            funcionarios.add(novo);
        
        return status;
    }
    
    public static boolean excluir(Funcionario funcionario) {
        funcionarios.remove(funcionario);
        return true;
    }
    
    public static HashSet<Funcionario> listar() {
        return (HashSet<Funcionario>)funcionarios;
    }
    
    public static HashSet<Funcionario> listar(String tipo) {
        return null;
    }
    
    public static Funcionario obter(int id) {
        for(Funcionario f : funcionarios) {
            if(f.getId() == id)
                return f;
        }
        
        return null;
    }
    
    public static Funcionario obter(String nome) {
        for(Funcionario f : funcionarios) {
            if(f.getNome().equals(nome))
                return f;
        }
        
        return null;
    }
}
