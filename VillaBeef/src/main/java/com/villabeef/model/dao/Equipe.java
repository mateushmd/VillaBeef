/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Equipe {

    private Equipe() {
    }

    public static boolean inserir(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO equipe VALUES('" + funcionario.getId() + "', '" + funcionario.getNome() + "', '"
                + funcionario.getFuncao() + "', '" + funcionario.getSalario() + "', '" + funcionario.getConta() + "')";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = ConexaoBD.getConexao();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sql);
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }

    public static boolean alterar(Funcionario funcionario, Funcionario novo) {
        return false;
    }

    public static boolean excluir(Funcionario funcionario) {
        return false;
    }

    public static HashSet<Funcionario> listar() throws ClassNotFoundException, SQLException {
        HashSet<Funcionario> lista = new HashSet<>();

        Funcionario funcionario;

        String sql = "SELECT * FROM equipe";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                funcionario = new Funcionario(rs.getString("nome"),
                        rs.getDouble("salario"),
                        rs.getString("conta_bancaria"),
                        rs.getString("funcao"),
                        rs.getString("id"));
                
                lista.add(funcionario);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }

    public static HashSet<Funcionario> listar(String tipo) {
        return null;
    }

    public static Funcionario obter(int id) {
        return null;
    }

    public static Funcionario obter(String nome) {
        return null;
    }
}
