/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.dto.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class UsuarioDAO {
    private UsuarioDAO() {}
    
    public static boolean login(Usuario usuario) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM usuarios WHERE (login = '" + usuario.getLogin() + "' AND senha = '" + usuario.getSenha() + "')";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        boolean rs;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.execute(sql);
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }
        
        return rs;
    }
    
    public static boolean cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO equipe VALUES('" + usuario.getLogin() + "', '" + usuario.getSenha() + "', '"
                + usuario.getIdentificacao() + "')";
        
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
}
