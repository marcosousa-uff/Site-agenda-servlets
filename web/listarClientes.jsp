<%-- 
    Document   : listarClientes
    Created on : 05/01/2022, 15:54:38
    Author     : cliente
--%>

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
                         <li class="nav-item active"><a class="nav-link" href="listarClientes.jsp">Lista de Clientes</a></li>
		</ul>
	</nav>
	</div> 
        <div>
         <h1>Lista de Pedidos</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Data de Nasc</th>
                            <th scope="col">Tipo do Doc</th>
                            <th scope="col">Estado Civil</th>
                            <th scope="col">Possui Filhos</th>
                            <th scope="col">Profissao</th>
                            <th scope="col">Sexo</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">Bairro</th>
                            <th scope="col">Cidade</th>
                            <th scope="col">CEP</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ClientesDAO clientesdao = new ClientesDAO();
                            ArrayList<Clientes> ListaPedido =  clientesdao.getLista();
                            for (int i = 0; i < ListaPedido.size(); i++) {
                                Clientes aux = ListaPedido.get(i);
                                String url="ExcluirCliente?codigoCliente="+aux.getCodigo();
                                String url2="ListarTelefones?codigoCliente="+aux.getCodigo();
                                String estado = "outros";
                                String tipo = "indeterminado";
                                String filhos = "não";
                                String sexo = "outros";
                                if(aux.getSexo()==0){
                                    sexo = "masculino";
                                }
                                if(aux.getSexo()==1){
                                    sexo = "feminino";
                                }
                                if(aux.isPossuiFilhos()){
                                    filhos = "sim";
                                }
                                if(aux.getTipoDocumento() == 0){
                                    tipo = "padrão";
                                }
                                if(aux.getEstadoCivil()==0){
                                    estado = "casado";
                                }
                                if(aux.getEstadoCivil()==1){
                                    estado = "solteiro";
                                }
                        %>
                        <tr>
                            <td><%=aux.getCodigo()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getDataNascimento()%></td> 
                            <td><%=tipo%></td>
                            <td><%=estado%></td>
                            <td><%=filhos%></td> 
                            <td><%=aux.getProfissao()%></td>
                            <td><%=sexo%></td> 
                            <td><%=aux.getEndereco()%></td> 
                            <td><%=aux.getBairro()%></td> 
                            <td><%=aux.getCidade()%></td> 
                            <td><%=aux.getCep()%></td> 
                            <td><a href="<%=url2%>" class="btn btn-outline-success float-right" >Telefones</a></td>
                            <td><a href="<%=url%>" class="btn btn-outline-danger float-right" >Excluir</a></td>       
                        </tr>
                        <%
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
