/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Conta;
import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.dto.Imposto;
import com.villabeef.model.service.ManterFuncionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
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
    
    public static boolean inserirImposto(Imposto imposto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;
        
        String sql = null;

        int resultado = 0;

        try {
            conexao = ConexaoBD.getConexao();

            comando = conexao.createStatement();
            
            sql = "SELECT COUNT(*) FROM impostos";
                
            rs = comando.executeQuery(sql);

            rs.next();

            String id = String.valueOf(rs.getInt(1) + 1);
            
            sql = "INSERT INTO impostos VALUES('" + id + "', '" + imposto.getDescricao() + "', '" + imposto.getValor() + "')";
            
            resultado = comando.executeUpdate(sql);
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return resultado > 0;
    }
    
    public static HashSet<Imposto> listarImpostos() throws ClassNotFoundException, SQLException {
        HashSet<Imposto> impostos = new HashSet<>();
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;
        
        String sql = "SELECT * FROM impostos";

        try {
            conexao = ConexaoBD.getConexao();

            comando = conexao.createStatement();
                
            rs = comando.executeQuery(sql);

            while(rs.next()) {
                Imposto i = new Imposto(rs.getString("descricao"), 
                                        rs.getDouble("valor"));
                
                impostos.add(i);
            }
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return impostos;
    }
    
    public static void pagarFuncionarios() throws ClassNotFoundException, SQLException {
        HashSet<Funcionario> funcionarios = ManterFuncionario.listar();
        
        for(Funcionario f : funcionarios) {
            Conta c = new Conta(Date.valueOf(LocalDate.now()), 's', "Pagamento de salário (" + f.getNome() + ")", f.getSalario());
            inserir(c);
        }
    }
    
    public static void pagarImpostos() throws ClassNotFoundException, SQLException {
        HashSet<Imposto> impostos = listarImpostos();
        
        for(Imposto i : impostos) {
            Conta c = new Conta(Date.valueOf(LocalDate.now()), 's', "Pagamento de imposto (" + i.getDescricao() + ")", i.getValor());
            inserir(c);
        }
    }
    
    public static boolean resolverPendencias(int status) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        
        Statement comando = null;

        String sql = "UPDATE dados SET pendenciasPagas = " + status + " WHERE id = '1'";

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
    
    public static boolean getPendencias() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM dados";
        
        Connection conexao = null;

        Statement comando = null;

        ResultSet rs = null;
        
        int resultado;
        
        try {
            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            rs.next();
            
            resultado = rs.getInt("pendenciasPagas");
        } finally {
            ConexaoBD.fecharConexao(conexao, comando, rs);
        }
        
        return resultado > 0;
    }
}
