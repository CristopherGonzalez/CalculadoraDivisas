/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraDeDivisas.Calculos.Servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Divisas.SessionBeans.EjbDivisasLocal;

/**
 *
 * @author crist
 */
public class CalculosServlet extends HttpServlet {

    @EJB
    private EjbDivisasLocal ejbDivisas;

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
        response.setContentType("text/html;charset=UTF-8");
        List<String> listado_divisas = ejbDivisas.ObtenerDivisas();
        response.setHeader("Cache-Control", "no-cache");
        for (int i = 0; i < listado_divisas.size(); i++) {
            response.getWriter().write("<option value="+ listado_divisas.get(i).substring(0,3) + ">" + listado_divisas.get(i).substring(5) + "</option>");
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
        response.setContentType("text/html;charset=UTF-8");
        String cantidad_inicial = request.getParameter("cantidad_inicial");
        String divisa_inicial = request.getParameter("divisa_inicial");
        String divisa_convertida = request.getParameter("divisa_convertida");
        System.out.println("cantidad_inicial " + cantidad_inicial);
        System.out.println("divisa_inicial " + divisa_inicial);
        System.out.println("divisa_convertida " + divisa_convertida);
        int c_inicial = Integer.parseInt(cantidad_inicial);
        double cantidad_convertida = ejbDivisas.calculo_conversion(c_inicial, divisa_inicial, divisa_convertida);
        System.out.println(cantidad_convertida);
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(String.valueOf(cantidad_convertida));
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
