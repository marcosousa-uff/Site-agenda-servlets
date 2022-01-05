/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import aplicacao.Telefones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author cliente
 */
@WebServlet(name = "TelefonesDAO", urlPatterns = {"/TelefonesDAO"})
public class TelefonesDAO extends HttpServlet {
    private Connection conexao;
    public TelefonesDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Telefones> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Telefones> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from telefones");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Telefones telefone = new Telefones();
                
                telefone.setCodigo(rs.getInt("codigo") );
                telefone.setCodigoCliente(rs.getInt("codigoCliente") );
                telefone.setTelefone(rs.getInt("telefone") );
                telefone.setTipoTelefone(rs.getInt("tipoTelefone") );
                resultado.add(telefone);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    public boolean gravar(Telefones telefone) {
        try {
            String sql;
            if (telefone.getCodigo() == 0) {
                // Realizar uma inclusão
                sql = "INSERT INTO telefones (codigoCliente, telefone, tipoTelefone) values(?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, telefone.getCodigoCliente());
                ps.setInt(2, telefone.getTelefone());
                ps.setInt(3, telefone.getTipoTelefone());
                ps.execute();   

            } else {
                // Realizar uma alteração
                sql = "UPDATE telefones SET codigoCliente=?, telefone=?, tipoTelefone=? WHERE id=?";                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, telefone.getCodigoCliente());
                ps.setInt(2, telefone.getTelefone());
                ps.setInt(3, telefone.getTipoTelefone());
                ps.setInt(4, telefone.getCodigo());
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
            String sql = "DELETE FROM telefones WHERE codigo = ?";
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
