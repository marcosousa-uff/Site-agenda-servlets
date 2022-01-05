/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import aplicacao.Clientes;
import aplicacao.Telefones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ClientesDAO;
import modelo.TelefonesDAO;

/**
 *
 * @author cliente
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        int estadoCivil = Integer.parseInt(request.getParameter("estadoCivil"));
        boolean filhos = Boolean.parseBoolean(request.getParameter("filhos"));
        String profissao = request.getParameter("profissao");
        String fixo = request.getParameter("fixo");
        String celular = request.getParameter("celular");
        
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        int cep = Integer.parseInt(request.getParameter("cep"));
        
        int sexo = Integer.parseInt(request.getParameter("sexo"));
        
        
        java.util.Date data = new java.util.Date();  
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        boolean resultado = false;
        if((!nome.isEmpty()) && (!profissao.isEmpty())){
            Clientes cliente = new Clientes(0,nome,dataSql,0,estadoCivil,filhos,profissao,sexo,endereco,bairro,cidade,cep);
            ClientesDAO clientesdao = new ClientesDAO();
            resultado = clientesdao.gravar(cliente); 
            int codigo = clientesdao.getCodigo(nome);
            if(codigo!=0){
                TelefonesDAO telefonesdao = new TelefonesDAO();
                if(!fixo.isEmpty()){
                    Telefones telefone = new Telefones(0,codigo,Integer.parseInt(fixo),0);
                    telefonesdao.gravar(telefone);
                }
                if(!celular.isEmpty()){
                    Telefones telefone2 = new Telefones(0,codigo,Integer.parseInt(celular),1);
                    telefonesdao.gravar(telefone2);
                }
            }
        }else{
            response.sendRedirect("erro.html");
        }
            
        if(resultado){ 
            response.sendRedirect("index.html");
        }else{
            response.sendRedirect("erro.html");
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
