/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villabeef.model.service;

import com.villabeef.model.dao.Equipe;
import com.villabeef.model.dto.Funcionario;

/**
 *
 * @author aluno
 */
public class ManterFuncionario {
    private ManterFuncionario() {}
    
    public static void adicionarFuncionario(String nome, double salario, int conta, String funcao)
    {
        Equipe.inserir(new Funcionario(nome, salario, conta, funcao, 0));
    }
}
