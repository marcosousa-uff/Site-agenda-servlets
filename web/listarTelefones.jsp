<%-- 
    Document   : listarTelefones
    Created on : 05/01/2022, 15:54:38
    Author     : cliente
--%>

<%@page import="aplicacao.Telefones"%>
<%@page import="modelo.TelefonesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacao.Clientes"%>
<%@page import="modelo.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <!-- Meta tags Obrigatórias -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Prova Estagio WEB</title>
    </head>
    <body>
        <div class="container">
	<p></p>
	<!-- Conteúdo aqui -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			 <li class="nav-item"><a class="nav-link" href="index.html">Inicio</a></li>
                         <li class="nav-item"><a class="nav-link" href="listarClientes.jsp">Lista de Clientes</a></li>
		</ul>
	</nav>
	</div> 
        <div>
         <h1>Lista de Pedidos</h1>
            <div class="table-responsive">
                <%
                    HttpSession ses = request.getSession();
                    int codigo = (int)ses.getAttribute("codigo");
                    
                    
                 %>   
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Tipo do Telefone</th>
                            <th scope="col">Numero</th>
                            
                        </tr>
                    </thead> 
                    <tbody>
                        
                        
                        <tr>
                        <%
                            
                            TelefonesDAO telefonesdao = new TelefonesDAO();
                            ArrayList<Telefones> ListaPedido =  telefonesdao.getLista();
                            for (int i = 0; i < ListaPedido.size(); i++) {
                                Telefones aux = ListaPedido.get(i);
                                if(aux.getCodigoCliente() == codigo){
                                    String tipo ="Residencial";
                                    
                                    if(aux.getTipoTelefone()==1){
                                        tipo = "movel";
                                    }
                                    
                                
                        %>    
                            
                            
                            <td><%=tipo%></td> 
                            <td><%=aux.getTelefone()%></td>  
                        </tr>
                        <%
                            }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <a href="index.html" >Retorna</a>
        </div>
    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="jquery-3.4.1.min.js"></script>
    <script src="js/jquery.mask.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
