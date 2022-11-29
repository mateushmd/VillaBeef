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


public class EquipeDAO {

    private EquipeDAO() {}
    
    public static boolean inserir(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO equipe VALUES('" + funcionario.getId() + "', '" + funcionario.getNome() + "', '"
                + funcionario.getSalario() + "', '" + funcionario.getConta() + "', '" + funcionario.getFuncao() + "')";
        
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

    public static boolean alterar(Funcionario funcionario, Funcionario novo) throws ClassNotFoundException, SQLException {
        int resultado = excluir(funcionario) == true ? 1 : 0;
            
        if(resultado > 0)
            resultado = inserir(novo) == true ? 1 : 0;

        return resultado > 0; 
    }

    public static boolean excluir(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM equipe WHERE id = '" + funcionario.getId() + "'";
        
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

    public static HashSet<Funcionario> listar(String tipo) throws ClassNotFoundException, SQLException {
        HashSet<Funcionario> lista = new HashSet<>();

        Funcionario funcionario;

        String sql = "SELECT * FROM equipe WHERE funcao = '" + tipo + "'";
        
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

    public static Funcionario obterPorId(String id) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = null;

        String sql = "SELECT * FROM equipe WHERE id = '" + id + "'";
        
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
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return funcionario;
    }

    public static Funcionario obterPorNome(String nome) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = null;

        String sql = "SELECT * FROM equipe WHERE nome = '" + nome + "'";
        
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
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return funcionario;
    }
    
    public static HashSet<Funcionario> pesquisar(String pesquisa) throws ClassNotFoundException, SQLException {
        HashSet<Funcionario> lista = EquipeDAO.listar();
        
        HashSet<Funcionario> filtrado = new HashSet<>();
        
        String comparar = null;
        
        for(Funcionario f : lista) {
            boolean possuiLetrasIguais = true;

            if(!Character.isDigit(pesquisa.charAt(0)))
                comparar = f.getNome();
            else
                comparar = f.getId();
            
            if(comparar.length() < pesquisa.length())
                continue;
            
            for(int i = 0; i < pesquisa.length(); i++)
            {
                if(Character.toLowerCase(comparar.charAt(i)) - Character.toLowerCase(pesquisa.charAt(i)) == 0)
                    continue;
                
                possuiLetrasIguais = false;
            }
            
            if(possuiLetrasIguais)
                filtrado.add(f);
        }
        
        return filtrado;
    }  
}
