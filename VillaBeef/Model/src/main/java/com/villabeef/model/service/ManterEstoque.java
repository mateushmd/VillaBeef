/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.service;

import com.villabeef.common.CampoInvalidoException;
import com.villabeef.model.dao.EquipeDAO;
import com.villabeef.model.dao.EstoqueDAO;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;

public class ManterEstoque {

    public static void inserir(String tipo, String marca, double valorCompra, double valorVenda, String validade, String id) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date data = Date.valueOf(formato2.format(formato1.parse(validade)));

        Produto produto = new Produto("", marca, tipo);

        ItemProduto item = new ItemProduto(id, "", data, valorVenda);

        EstoqueDAO.inserir(produto, item);

        ManterRentabilidade.inserir(Date.valueOf(LocalDate.now()), 's', "Re-estoque", valorCompra);
    }

    public static void inserirServlet(String tipo, String marca, double valorCompra, double valorVenda, String validade, String id) throws ClassNotFoundException, SQLException, ParseException {
        Date data = Date.valueOf(validade);

        Produto produto = new Produto("", marca, tipo);

        ItemProduto item = new ItemProduto(id, "", data, valorVenda);

        EstoqueDAO.inserir(produto, item);

        ManterRentabilidade.inserir(Date.valueOf(LocalDate.now()), 's', "Re-estoque", valorCompra);
    }

    public static void alterar(Produto novoProduto, ItemProduto item, ItemProduto novoItem) throws ClassNotFoundException, SQLException {
        EstoqueDAO.alterar(novoProduto, item, novoItem);
    }

    public static HashSet<ItemProduto> listar() throws ClassNotFoundException, SQLException {
        return EstoqueDAO.listar();
    }

    public static ItemProduto obterPorId(String id) throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterPorId(id);
    }

    public static Produto obterProduto(String idProduto) throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterProduto(idProduto);
    }

    public static Produto obterProduto(String tipo, String marca) throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterProduto(tipo, marca);
    }

    public static void excluir(ItemProduto item) throws ClassNotFoundException, SQLException {
        EstoqueDAO.excluir(item);
    }

    public static HashSet<ItemProduto> pesquisar(String pesquisa, int modo) throws ClassNotFoundException, SQLException {
        if (pesquisa.isBlank()) {
            return EstoqueDAO.listar();
        }

        return EstoqueDAO.pesquisar(pesquisa, modo);
    }

    public static HashSet<ItemProduto> adicionarCompra(String idProduto, int quantidade) throws ClassNotFoundException, SQLException, CampoInvalidoException {
        return EstoqueDAO.adicionarCompra(idProduto, quantidade);
    }

    public static boolean finalizarCompra(HashSet<ItemProduto> itens, double subtotal) throws ClassNotFoundException, SQLException, ParseException {
        return EstoqueDAO.finalizarCompra(itens, subtotal);
    }

    public static HashSet<ItemProduto> obterItensVencidos() throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> itens = listar();
        HashSet<ItemProduto> vencido = new HashSet<>();

        for (ItemProduto i : itens) {
            Date validade = i.getValidadeAsDate();
            Date hoje = Date.valueOf(LocalDate.now());

            if (validade.before(hoje) || validade.equals(hoje)) {
                vencido.add(i);
            }
        }

        return vencido;
    }

    public static void removerItensVencidos() throws ClassNotFoundException, SQLException {
        HashSet<ItemProduto> vencido = obterItensVencidos();

        for (ItemProduto i : vencido) {
            excluir(i);
        }
    }
}
