/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClientesDAO;

/**
 *
 * @author cliente
 */
@WebServlet(name = "ExcluirCliente", urlPatterns = {"/ExcluirCliente"})
public class ExcluirCliente extends HttpServlet {

 

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
        int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
        ClientesDAO clientesdao = new ClientesDAO();
        if(clientesdao.excluir(codigoCliente)){
            RequestDispatcher rd = request.getRequestDispatcher("listarClientes.jsp");
                rd.forward(request, response);
        } else {

            RequestDispatcher rd = request.getRequestDispatcher("erro.html");
            rd.forward(request, response);
        }
        
    }


}
