/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

/**
 *
 * @author cliente
 */
public class Telefones {

    
    private int codigo;
    private int codigoCliente;
    private int telefone;
    private int tipoTelefone;
    
    public Telefones(int codigo, int codigoCliente, int telefone, int tipoTelefone){
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
    }
    public Telefones(){
        
    }
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @return the tipoTelefone
     */
    public int getTipoTelefone() {
        return tipoTelefone;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @param tipoTelefone the tipoTelefone to set
     */
    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
