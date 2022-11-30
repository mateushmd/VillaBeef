package com.villabeef.model.service;

import com.villabeef.model.dao.RentabilidadeDAO;
import com.villabeef.model.dto.Conta;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManterRentabilidade  {
    private ManterRentabilidade() {}
    
    public static boolean inserir(Date data, char tipo, String descricao, double valor) throws ClassNotFoundException, SQLException, ParseException {
        return RentabilidadeDAO.inserir(new Conta(data, tipo, descricao, valor));
    }
    
    public static LinkedHashSet<Conta> listar() throws ClassNotFoundException, SQLException {
        LinkedHashSet<Conta> lista = new LinkedHashSet<>();

        lista.addAll(ManterRentabilidade.listar('s'));

        lista.addAll(ManterRentabilidade.listar('e'));
        
        return lista;
    }
    
    public static LinkedHashSet<Conta> listar(String inicio, String fim) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicio = Date.valueOf(formato2.format(formato1.parse(inicio)));
        Date dataFim = Date.valueOf(formato2.format(formato1.parse(fim)));

        String sql = "SELECT * FROM conta WHERE dataC BETWEEN '" + dataInicio.toString() + "' AND '" + dataFim.toString() + "'";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static LinkedHashSet<Conta> listar(char tipo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta WHERE tipo = '" + tipo + "'";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static LinkedHashSet<Conta> listar(char tipo, String inicio, String fim) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicio = Date.valueOf(formato2.format(formato1.parse(inicio)));
        Date dataFim = Date.valueOf(formato2.format(formato1.parse(fim)));
        
        String sql = "SELECT * FROM conta WHERE dataC BETWEEN '" + dataInicio.toString() + "' AND '" + dataFim.toString() + "' AND tipo = '" + tipo + "'";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static double obterSaldo(String data) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataFormatada = Date.valueOf(formato2.format(formato1.parse(data)));
        
        return RentabilidadeDAO.obterSaldo(dataFormatada);
    }
    
    public static double obterSaldo() throws ClassNotFoundException, SQLException, ParseException {
        
        return RentabilidadeDAO.obterSaldo();
    }
}
