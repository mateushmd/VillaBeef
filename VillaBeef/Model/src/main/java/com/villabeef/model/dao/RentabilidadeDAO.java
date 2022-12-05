/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Conta;
import com.villabeef.model.dto.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;

public class RentabilidadeDAO {

    private RentabilidadeDAO() {
    }

    public static boolean inserir(Conta conta) throws ClassNotFoundException, SQLException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;
        
        String sql = null;

        int resultado = 0;

        try {
            conexao = ConexaoBD.getConexao();

            comando = conexao.createStatement();
            
            sql = "SELECT COUNT(*) FROM conta";
                
            rs = comando.executeQuery(sql);

            rs.next();

            String id = String.valueOf(rs.getInt(1) + 1);

            double valor = Math.abs(conta.getValor());

            sql = "UPDATE dados SET saldo = saldo " + (conta.getValor() > 0 ? ("+ " + valor) : ("- " + valor)) + " WHERE id = '1'";

            resultado = comando.executeUpdate(sql);
            
            sql = "SELECT * FROM dados";
            
            rs = comando.executeQuery(sql);
            
            rs.next();
            
            if(resultado > 0) {
                sql = "INSERT INTO conta VALUES('" + conta.getData().toString() + "', '" + conta.getTipo() + "', '"
                    + conta.getDescricao() + "', '" + conta.getValor() + "', '" + id + "', '" + rs.getDouble("saldo") + "', '" + formato.format(conta.getData()) + "')";

                resultado = comando.executeUpdate(sql);
            }
            
            
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }

    public static LinkedHashSet<Conta> listar(String sql) throws ClassNotFoundException, SQLException {
        LinkedHashSet<Conta> lista = new LinkedHashSet<>();

        Conta conta;

        Connection conexao = null;

        Statement comando = null;

        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();

            rs = comando.executeQuery(sql);

            while (rs.next()) {
                conta = new Conta(rs.getDate("dataC"),
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

    public static double obterSaldo(Date data) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta WHERE dataC = '" + data + "' ORDER BY dataC";
        
        Connection conexao = null;

        Statement comando = null;

        ResultSet rs = null;
        
        double saldo;
        
        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();

            rs = comando.executeQuery(sql);

            rs.next();
            
            saldo = rs.getDouble("historico");
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return saldo;
    }
    
    public static double obterSaldo() throws ClassNotFoundException, SQLException {
        String sql;
        
        Connection conexao = null;

        Statement comando = null;

        ResultSet rs = null;
        
        double saldo;
        
        try {
            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            sql = "SELECT COUNT(*) FROM conta";
                
            rs = comando.executeQuery(sql);

            rs.next();

            String id = String.valueOf(rs.getInt(1));
            
            
            sql = "SELECT * FROM conta WHERE id = '" + id + "' ORDER BY dataC";

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();

            rs = comando.executeQuery(sql);

            rs.next();
            
            saldo = rs.getDouble("historico");
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return saldo;
    }
}
