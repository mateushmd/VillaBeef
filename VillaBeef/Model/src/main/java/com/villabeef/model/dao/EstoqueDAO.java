/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import static com.villabeef.model.dao.EquipeDAO.listar;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
                
                sql = "UPDATE produtos SET quantidade = quantidade+1 WHERE id = '" + produto.getId() + "'";
                
                resultado = comando.executeUpdate(sql);
            }
            else {
                sql = "SELECT COUNT(*) FROM produtos";
                
                rs = comando.executeQuery(sql);
                
                rs.next();
                
                String id = String.valueOf(rs.getInt(1) + 1);
                
                produto.setId(id);
                
                sql = "INSERT INTO produtos VALUES('" + produto.getId() + "', '" + produto.getMarca() + "', '" + produto.getTipo() + 
                        "', '" + 1 + "', '" + produto.getQuantidadeMinima() + "')";
                
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
    
    public static boolean excluir(ItemProduto itemProduto) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM estoque WHERE id = '" + itemProduto.getId() + "'";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = ConexaoBD.getConexao();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sql);
            
            if(resultado > 0) {
                sql = "UPDATE produtos SET quantidade = quantidade-1 WHERE id = '" + itemProduto.getIdProduto() + "'";

                resultado = comando.executeUpdate(sql);
            }
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
                        rs.getDate("validade"),
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
    
    public static HashSet<ItemProduto> listarPorProduto(String idProduto) throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> lista = new HashSet<>();

        ItemProduto item;

        String sql = "SELECT * FROM estoque WHERE id_produto = '" + idProduto + "'";
        
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
                        rs.getDate("validade"),
                        rs.getDouble("valor"));
                
                lista.add(item);
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
                        rs.getDate("validade"),
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
    
    public static HashSet<ItemProduto> pesquisar(String pesquisa, int modo) throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> lista = listar();
        
        HashSet<ItemProduto> filtrado = new HashSet<>();
        
        String comparar = null;
        
        for(ItemProduto item : lista) {
            boolean possuiLetrasIguais = true;

            if(Character.isDigit(pesquisa.charAt(0)))
                comparar = item.getId();
            else {
                if(modo == 0) {
                    comparar = obterProduto(item.getIdProduto()).getMarca();
                } else if(modo == 1) {
                    comparar = obterProduto(item.getIdProduto()).getTipo();
                }
            }
                
            
            if(comparar.length() < pesquisa.length())
                continue;
            
            for(int i = 0; i < pesquisa.length(); i++)
            {
                if(Character.toLowerCase(comparar.charAt(i)) - Character.toLowerCase(pesquisa.charAt(i)) == 0)
                    continue;
                
                possuiLetrasIguais = false;
            }
            
            if(possuiLetrasIguais)
                filtrado.add(item);
        }
        
        return filtrado;
    }
    
    public static HashSet<ItemProduto> vender(String idProduto, int quantidade) throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> set = listarPorProduto(idProduto);
        
        ItemProduto[] lista = new ItemProduto[set.size()]; 
        lista = set.toArray(lista);
        
        HashSet<ItemProduto> filtrado = new HashSet<>();
        
        Date hoje = Date.valueOf(LocalDate.now());
        
        for(int i = 0; i < quantidade; i++) {
            ItemProduto item = lista[i];
            if(item.getValidadeAsDate().after(hoje))
                filtrado.add(item);
        }
        
        return filtrado;
    }
}