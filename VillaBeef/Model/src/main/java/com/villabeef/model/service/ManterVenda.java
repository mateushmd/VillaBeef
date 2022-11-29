/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.villabeef.model.service;

import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Venda;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;


public class ManterVenda {
    private ManterVenda() {}
    
    public static void registrar(Venda venda) throws ClassNotFoundException, SQLException, ParseException {
        double valor = 0.00;
        
        for(ItemProduto item : venda.getItens())
            valor += item.getValor();
        
        ManterRentabilidade.inserir(Date.valueOf(LocalDate.now()), 'e', "Venda", valor);
    }
}
