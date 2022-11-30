package com.villabeef.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.service.ManterFuncionario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samsung
 */
@WebServlet(urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome;
        String cpf;
        String conta;
        String funcao;
        double salario;
        
        Funcionario funcionario;

        String op = request.getParameter("op");

        try {
            switch(op) {
                case "a":
                    nome = request.getParameter("fname");
                    cpf = request.getParameter("cpf");
                    cpf = cpf.replace(".", "");
                    cpf = cpf.replace("-", "");
                    conta = request.getParameter("conta");
                    funcao = request.getParameter("funcao");
                    salario = Double.parseDouble(request.getParameter("salario").replace(",", "."));
                    
                    ManterFuncionario.adicionar(nome, salario, conta, funcao, cpf);
                    break;
                case "e":
                    nome = request.getParameter("fname");
                    cpf = request.getParameter("identificacao");
                    cpf = cpf.replace(".", "");
                    cpf = cpf.replace("-", "");
                    conta = request.getParameter("conta");
                    funcao = request.getParameter("funcao");
                    salario = Double.parseDouble(request.getParameter("salario").replace(",", "."));
                    
                    funcionario = new Funcionario(nome, salario, conta, funcao, cpf);
                    
                    ManterFuncionario.alterar(ManterFuncionario.obterPorId(cpf), funcionario);
                    break;
                case "ex":
                    cpf = request.getParameter("identificacao");
                    ManterFuncionario.excluirServlet(cpf);
                    break;
            }
            
            response.sendRedirect("funcionarios.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
