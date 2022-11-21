/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class EstoqueDAO {
    private EstoqueDAO() {}
    
    public static boolean inserir(Produto produto, ItemProduto item) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM produtos WHERE marca = '" + produto.getMarca() + "' AND tipo = '" + produto.getTipo() + "'";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;
        
        int resultado = 1;
        
        try {
            conexao = ConexaoBD.getConexao();
            
            comando = conexao.createStatement();

            rs = comando.executeQuery(sql);
            
            if(rs.next()) {
                produto.setId(rs.getString("id"));
            }
            else {
                sql = "SELECT COUNT(*) FROM produtos";
                
                rs = comando.executeQuery(sql);
                
                rs.next();
                
                String id = String.valueOf(rs.getInt(1) + 1);
                
                produto.setId(id);
                
                sql = "INSERT INTO produtos VALUES('" + produto.getId() + "', '" + produto.getMarca() + "', '" + produto.getTipo() + 
                        "', '" + produto.getQuantidade() + "', '" + produto.getQuantidadeMinima() + "')";
                
                resultado = comando.executeUpdate(sql);
            }
            
            item.setIdProduto(produto.getId());
            
            if(resultado > 0) {
                sql = "INSERT INTO estoque VALUES('" + item.getId() + "', '" + item.getIdProduto() + "', '" + item.getValidade() + 
                        "', '" + item.getValor() + "')";
                
                resultado = comando.executeUpdate(sql);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }
        
        return resultado > 0;
    }
    
    public static boolean alterar(Produto novoProduto, ItemProduto item, ItemProduto novoItem) throws ClassNotFoundException, SQLException {
        int resultado = excluir(item) == true ? 1 : 0;

        if(resultado > 0) 
            resultado = inserir(novoProduto, novoItem) == true ? 1 : 0;
        
        return resultado > 0;
    }
    
    public static boolean excluir(ItemProduto produto) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM estoque WHERE id = '" + produto.getId() + "'";
        
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
    
    public static HashSet<ItemProduto> listar() throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> lista = new HashSet<>();

        ItemProduto item;

        String sql = "SELECT * FROM estoque";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                item = new ItemProduto(rs.getString("id"),
                        rs.getString("id_produto"),
                        rs.getString("validade"),
                        rs.getDouble("valor"));
                
                lista.add(item);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }
    
    public static HashSet<Produto> listar(String tipo) throws ClassNotFoundException, SQLException {
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
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getInt("quantidade_minima"));
                
                lista.add(produto);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }
    
    public static ItemProduto obterPorId(String id) throws ClassNotFoundException, SQLException {
        ItemProduto item = null;

        String sql = "SELECT * FROM estoque WHERE id = '" + id + "'";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                item = new ItemProduto(rs.getString("id"),
                        rs.getString("id_produto"),
                        rs.getString("validade"),
                        rs.getDouble("valor"));
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return item;
    }
    
    
    public static ItemProduto obter(String marca) {
        return null;
    }
    
    public static Produto obterProduto(String idProduto) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM produtos WHERE id = '" + idProduto + "'";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;
        
        Produto produto = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            if(rs.next()) {
                produto = new Produto(rs.getString("id"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getInt("quantidade_minima"));
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return produto;
    }
}