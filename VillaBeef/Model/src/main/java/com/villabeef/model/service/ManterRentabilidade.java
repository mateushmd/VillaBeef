package com.villabeef.model.service;

import com.villabeef.model.dao.RentabilidadeDAO;
import static com.villabeef.model.dao.RentabilidadeDAO.inserir;
import static com.villabeef.model.dao.RentabilidadeDAO.listarImpostos;
import com.villabeef.model.dto.Conta;
import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.dto.Imposto;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManterRentabilidade  {
    private ManterRentabilidade() {}
    
    public static boolean inserir(Date data, char tipo, String descricao, double valor) throws ClassNotFoundException, SQLException, ParseException {
        return RentabilidadeDAO.inserir(new Conta(data, tipo, descricao, valor));
    }
    
    public static boolean inserir(String data, char tipo, String descricao, double valor) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataFormatada = Date.valueOf(formato2.format(formato1.parse(data)));
        
        return RentabilidadeDAO.inserir(new Conta(dataFormatada, tipo, descricao, valor));
    }
    
    public static LinkedHashSet<Conta> listar() throws ClassNotFoundException, SQLException { 
        return RentabilidadeDAO.listar("SELECT * FROM conta ORDER BY dataC");
    }
    
    public static LinkedHashSet<Conta> listar(String inicio, String fim) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicio = Date.valueOf(formato2.format(formato1.parse(inicio)));
        Date dataFim = Date.valueOf(formato2.format(formato1.parse(fim)));

        String sql = "SELECT * FROM conta WHERE dataC BETWEEN '" + dataInicio.toString() + "' AND '" + dataFim.toString() + "' ORDER BY dataC";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static LinkedHashSet<Conta> listar(char tipo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM conta WHERE tipo = '" + tipo + "' ORDER BY dataC";
        return RentabilidadeDAO.listar(sql);
    }
    
    public static LinkedHashSet<Conta> listar(char tipo, String inicio, String fim) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicio = Date.valueOf(formato2.format(formato1.parse(inicio)));
        Date dataFim = Date.valueOf(formato2.format(formato1.parse(fim)));
        
        String sql = "SELECT * FROM conta WHERE dataC BETWEEN '" + dataInicio.toString() + "' AND '" + dataFim.toString() + "' AND tipo = '" + tipo + "' ORDER BY dataC";
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
    
    public static void inserirImposto(String descricao, double valor) throws ClassNotFoundException, SQLException {
        RentabilidadeDAO.inserirImposto(new Imposto(descricao, valor));
    }
    
    public static HashSet<Imposto> listarImpostos() throws ClassNotFoundException, SQLException {
        return RentabilidadeDAO.listarImpostos();
    }
    
    public static void pagarFuncionarios() throws ClassNotFoundException, SQLException {
        HashSet<Funcionario> funcionarios = ManterFuncionario.listar();
        
        for(Funcionario f : funcionarios) {
            Conta c = new Conta(Date.valueOf(LocalDate.now()), 's', "Pagamento de salário (" + f.getNome() + ")", f.getSalario());
            RentabilidadeDAO.inserir(c);
        }
    }
    
    public static void pagarImpostos() throws ClassNotFoundException, SQLException {
        HashSet<Imposto> impostos = listarImpostos();
        
        for(Imposto i : impostos) {
            Conta c = new Conta(Date.valueOf(LocalDate.now()), 's', "Pagamento de imposto (" + i.getDescricao() + ")", i.getValor());
            RentabilidadeDAO.inserir(c);
        }
    }
    
    public static void resolverPendencias(int estado) throws ClassNotFoundException, SQLException {
        RentabilidadeDAO.resolverPendencias(estado);
    }
    
    public static boolean getPendencias() throws ClassNotFoundException, SQLException {
        return RentabilidadeDAO.getPendencias();
    }
}
