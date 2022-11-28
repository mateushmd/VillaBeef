/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.villabeef.model.dao;

import com.villabeef.model.dto.Conta;
import com.villabeef.model.dto.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;


public class RentabilidadeDAO {
    private RentabilidadeDAO() {}
    
    public static boolean inserir(Conta conta) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO conta VALUES('" + conta.getData() + "', '" + conta.getTipo() + "', '"
                + conta.getDescricao() + ", " + conta.getValor() + "')";
        
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
    
    public static HashSet<Conta> listar(String sql) throws ClassNotFoundException, SQLException {
        HashSet<Conta> lista = new HashSet<>();

        Conta conta;
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            while(rs.next()) {
                conta = new Conta(rs.getDate("data"),
                        rs.getString("tipo").charAt(0),
                        rs.getString("descricao"),
                        rs.getDouble("valor"));
                
                lista.add(conta);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return lista;
    }
    
    public static double obterSaldo() throws ClassNotFoundException, SQLException {
        return 0;
    }
}
