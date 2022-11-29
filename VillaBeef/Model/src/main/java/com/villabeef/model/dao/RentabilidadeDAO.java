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

    private RentabilidadeDAO() {
    }

    public static boolean inserir(Conta conta) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        int resultado = 0;

        try {
            conexao = ConexaoBD.getConexao();

            comando = conexao.createStatement();
            
            String sql = "SELECT COUNT(*) FROM produtos";

            rs = comando.executeQuery(sql);

            rs.next();
            
            int id = rs.getInt(1);

            sql = "INSERT INTO conta VALUES('" + conta.getData().toString() + "', '" + conta.getTipo() + "', '"
                    + conta.getDescricao() + "', '" + conta.getValor() + "', '" + id + "')";

            resultado = comando.executeUpdate(sql);
            
            if(resultado > 0) {
                double valor = Math.abs(conta.getValor());

                sql = "UPDATE dados SET saldo = saldo " + (conta.getValor() > 0 ? ("+ " + valor) : ("- " + valor)) + " WHERE id = '1'";

                resultado = comando.executeUpdate(sql);
            }
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

            while (rs.next()) {
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
