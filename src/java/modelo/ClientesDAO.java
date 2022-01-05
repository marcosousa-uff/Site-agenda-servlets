/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import aplicacao.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cliente
 */
@WebServlet(name = "ClientesDAO", urlPatterns = {"/ClientesDAO"})
public class ClientesDAO extends HttpServlet {
    private Connection conexao;
    public ClientesDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Clientes> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Clientes> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from clientes");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Clientes cliente = new Clientes();
                
                cliente.setCodigo(rs.getInt("codigo") );
                cliente.setNome( rs.getString("nome") );
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setTipoDocumento(rs.getInt("tipo"));
                cliente.setEstadoCivil(rs.getInt("estadoCivil"));
                cliente.setPossuiFilhos(rs.getBoolean("filhos"));
                cliente.setProfissao(rs.getString("profissao"));
                cliente.setSexo(rs.getInt("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getInt("cep"));
         
                resultado.add(cliente);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    public int getCodigo( String nome ) {
        try {
            String sql = "SELECT codigo FROM clientes WHERE nome =?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            
            ResultSet rs = ps.executeQuery();
            int codigo = 0;
            if ( rs.next() ) {
                codigo = rs.getInt("codigo");    
            }
            return codigo;
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return 0;
        }
    }
    public boolean gravar(Clientes cliente) {
        try {
            String sql;
            if (cliente.getCodigo() == 0) {
                // Realizar uma inclusão
                sql = "INSERT INTO clientes (nome, dataNascimento, tipo, estadoCivil, filhos, profissao, sexo, endereco, bairro, cidade, cep) values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, cliente.getNome());
                ps.setDate(2, cliente.getDataNascimento());
                ps.setInt(3, cliente.getTipoDocumento());
                ps.setInt(4, cliente.getEstadoCivil());
                ps.setBoolean(5, cliente.isPossuiFilhos());
                ps.setString(6, cliente.getProfissao());
                ps.setInt(7, cliente.getSexo());
                ps.setString(8, cliente.getEndereco());
                ps.setString(9, cliente.getBairro());
                ps.setString(10, cliente.getCidade());
                ps.setInt(11, cliente.getCep());
                ps.execute();
                

            } else {
                // Realizar uma alteração
                sql = "UPDATE clientes SET nome=?, dataNascimento=?, tipo=?, estadoCivil=?, filhos=?, profissao=?, sexo=?, endereco=?, bairro=?, cidade=?, cep=? WHERE id=?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, cliente.getNome());
                ps.setDate(2, cliente.getDataNascimento());
                ps.setInt(3, cliente.getTipoDocumento());
                ps.setInt(4, cliente.getEstadoCivil());
                ps.setBoolean(5, cliente.isPossuiFilhos());
                ps.setString(6, cliente.getProfissao());
                ps.setInt(7, cliente.getSexo());
                ps.setString(8, cliente.getEndereco());
                ps.setString(9, cliente.getBairro());
                ps.setString(10, cliente.getCidade());
                ps.setInt(11, cliente.getCep());
                ps.setInt(12, cliente.getCodigo());
                ps.execute();
            }


            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
        
    }
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM clientes WHERE codigo = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

}
