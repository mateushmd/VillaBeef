package com.villabeef.model.service;

import com.villabeef.model.dao.ContaDAO;
import com.villabeef.model.dto.Conta;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;


public class ManterConta  {
    private ManterConta() {}
    
    public static void inserir(String data, char tipo, double valor) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        Date dataFormatada = Date.valueOf(formatoData.parse(data).toString());
        ContaDAO.inserir(new Conta(dataFormatada, tipo, valor));
    }
    
    public static HashSet<Conta> listar() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta";
        return ContaDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(String inicio, String fim) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta BETWEEN " + inicio + " AND " + fim;
        return ContaDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(char tipo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta WHERE tipo = '" + tipo + "'";
        return ContaDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(char tipo, String inicio, String fim) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta BETWEEN " + inicio + " AND " + fim + " WHERE tipo = '" + tipo + "'";
        return ContaDAO.listar(sql);
    }
}
