/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.service;

import com.villabeef.model.dao.EstoqueDAO;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import java.sql.SQLException;
import java.util.HashSet;

public class ManterEstoque {
    
     public static void inserir(String tipo, String marca, double valor, String validade, String id) throws ClassNotFoundException, SQLException {
         Produto produto = new Produto("", marca, tipo, 0, 0);
         
         ItemProduto item = new ItemProduto(id, "", validade, valor);
         
         EstoqueDAO.inserir(produto, item);
     }
     
     public static void alterar(Produto novoProduto, ItemProduto item, ItemProduto novoItem) throws ClassNotFoundException, SQLException {
         EstoqueDAO.alterar(novoProduto, item, novoItem);
     }
     
     public static HashSet<ItemProduto> listar() throws ClassNotFoundException, SQLException {
         return EstoqueDAO.listar();
     }
     
     public static HashSet<ItemProduto> listar(String tipo) {
         return null;
     }
     
     public static ItemProduto obterPorId(String id) throws ClassNotFoundException, SQLException{
         return EstoqueDAO.obterPorId(id);
     }
     
     public static ItemProduto obter(String marca) {
         return null;
     }
    
    public static Produto obterProduto(String idProduto) throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterProduto(idProduto);
    }
}
