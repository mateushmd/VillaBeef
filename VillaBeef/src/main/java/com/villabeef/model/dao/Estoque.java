/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.dao;

import com.villabeef.model.dto.Produto;
import java.util.HashSet;

public class Estoque {
    private Estoque() {}
    
    public static boolean inserir(HashSet<Produto> produtos) {
        return false;
    }
    
    public static boolean alterar(HashSet<Produto> produtos) {
        return false;
    }
    
    public static HashSet<Produto> listar() {
        return null;
    }
    
    public static HashSet<Produto> listar(String tipo) {
        return null;
    }
    
    public static Produto obter(int id) {
        return null;
    }
    
    public static Produto obter(String marca) {
        return null;
    }
}


