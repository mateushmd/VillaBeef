/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

public class Estoque {
    private Estoque() {}
    
    public static boolean inserir(HashSet<Produto> produtos) {
        return false;
    }
    
    public static boolean alterar(HashSet<Produto> produtos) {
        return false;
    }
    
    public static HashSet<Produto> listar() {
        HashSet<Produto> lista = new HashSet<>();

        Produto produto;

        String sql = "SELECT * FROM produtos";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                produto = new Produto(rs.getString("id"),
                        rs.getDouble("marca"),
                        rs.getString("tipo"),
                        rs.getString("quantidade"),
                        rs.getString("quantidade_minima"));
                
                lista.add(funcionario);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }
    
    public static HashSet<Produto> listar(String tipo) {
        HashSet<Produto> lista = new HashSet<>();

        Produto produto;

        String sql = "SELECT * FROM produtos WHERE tipo = '" + tipo + "'";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                produto = new Produto(rs.getString("id"),
                        rs.getDouble("marca"),
                        rs.getString("tipo"),
                        rs.getString("quantidade"),
                        rs.getString("quantidade_minima"));
                
                lista.add(funcionario);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }
    
    public static Produto obter(int id) {
        return null;
    }
    
    public static Produto obter(String marca) {
        return null;
    }
}


