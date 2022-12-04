package com.villabeef.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.villabeef.model.service.ManterEstoque;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/ProdutosServlet"})
public class ProdutosServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        
        String tipo;
        String marca;
        String id;
        String data;

        double valor;
        double venda;

        String op = request.getParameter("op");
        
        try {
             
             switch(op){
                case "a":
                    tipo = request.getParameter("tipo");
                    request.setAttribute("res", tipo);
                    marca = request.getParameter("marca");
                    id = request.getParameter("id");
                    data = request.getParameter("validade");
                    valor = Double.parseDouble(request.getParameter("valor").replace(",", "."));
                    venda = Double.parseDouble(request.getParameter("valor-venda").replace(",", "."));
                    ManterEstoque.inserirServlet(tipo, marca, valor, venda, data, id);
                    request.setAttribute("op", "a");
                    break;
                case "e":
                    // Manter Estoque EDITAR
                    request.setAttribute("op", "e");
                    // request.setAttribute("res", tipo);
                    break;
                case "ex":
                    id = request.getParameter("identificacao2");
                    ManterEstoque.excluir(ManterEstoque.obterPorId(id));
                    request.setAttribute("res", id);
                    request.setAttribute("op", "ex");
                    break;
             }
             
            RequestDispatcher rd = request.getRequestDispatcher("estoque.jsp");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProdutosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
