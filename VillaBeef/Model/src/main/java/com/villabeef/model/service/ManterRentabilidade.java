package com.villabeef.model.service;

import com.villabeef.model.dao.RentabilidadeDAO;
import com.villabeef.model.dto.Conta;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;


public class ManterRentabilidade  {
    private ManterRentabilidade() {}
    
    public static boolean inserir(Date data, char tipo, String descricao, double valor) throws ClassNotFoundException, SQLException, ParseException {
        return RentabilidadeDAO.inserir(new Conta(data, tipo, descricao, valor));
    }
    
    public static HashSet<Conta> listar() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(String inicio, String fim) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta BETWEEN " + inicio + " AND " + fim;
        return RentabilidadeDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(char tipo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta WHERE tipo = '" + tipo + "'";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static HashSet<Conta> listar(char tipo, String inicio, String fim) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta BETWEEN " + inicio + " AND " + fim + " WHERE tipo = '" + tipo + "'";
        return RentabilidadeDAO.listar(sql);
    }
}
