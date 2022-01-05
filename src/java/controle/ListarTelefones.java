/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cliente
 */
@WebServlet(name = "ListarTelefones", urlPatterns = {"/ListarTelefones"})
public class ListarTelefones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigoCliente"));
        
        HttpSession ses = request.getSession();
        ses.setAttribute("codigo", codigo);
        
        response.sendRedirect("listarTelefones.jsp");
    }


}
