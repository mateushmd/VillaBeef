/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.dto.Usuario;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class UsuarioDAO {
    private UsuarioDAO() {}
    
    public static boolean login(Usuario usuario) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM usuarios WHERE (login = '" + usuario.getLogin() + "' AND senha = '" + criptografar(usuario.getSenha()) + "')";
        
        Connection conexao = null;
        
        Statement comando = null;
        
        ResultSet rs = null;

        try {

            conexao = ConexaoBD.getConexao();
            comando = conexao.createStatement();
            
            rs = comando.executeQuery(sql);
            
            if(rs.next())
                return true;
            
        } finally {
            ConexaoBD.fecharConexao(conexao, comando);
        }
        
        return false;
    }
    
    public static boolean cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO usuarios VALUES('" + usuario.getLogin() + "', '" + criptografar(usuario.getSenha()) + "')";
        
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
    
    private static String criptografar(String input) {  
        String hex = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
        
            BigInteger numero = new BigInteger(1, hash);

            StringBuilder hexString = new StringBuilder(numero.toString(16));

            while(hexString.length() < 64) {
                hexString.insert(0, '0');
            }

            hex = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return hex;
        }
    }
}
