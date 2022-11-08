/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.villabeef.model.dao;

import com.villabeef.model.dto.Compra;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;


public class CompraDAO {
    private CompraDAO() {}
    
    public static boolean inserir(Compra compra) throws ClassNotFoundException, SQLException {
        String sqlProduto = "INSERT INTO produtos VALUES('" + compra.getProduto().getId() + "', '" + compra.getProduto().getMarca() + "', '"
                + compra.getProduto().getTipo() + "', '" + compra.getProduto().getQuantidade() + "', '" + compra.getProduto().getQuantidadeMinima() + "')";
        
        String sqlConta = "INSERT INTO conta VALUES('" + compra.getData() + "', 'S', '" + compra.getValor() + "')";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = ConexaoBD.getConexao();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlProduto);
            
            resultado = comando.executeUpdate(sqlConta);
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }
    
    public static boolean alterar(com.villabeef.model.dto.Compra compra) {
        return false;
    }
    
    public static boolean excluir(com.villabeef.model.dto.Compra compra) {
        return false;
    }
    
    public static HashSet<com.villabeef.model.dto.Compra> listar() {
        return null;
    }
    
    public static HashSet<com.villabeef.model.dto.Compra> listar(String data) {
        return null;
    }
    
    public static com.villabeef.model.dto.Compra obter(int id) {
        return null;
    }
    
}
