/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.sql.Date;



/**
 *
 * @author cliente
 */
public class Clientes {

    
    private int codigo;
    private String nome;
    private Date dataNascimento;
    private int tipoDocumento;
    private int estadoCivil;
    private boolean possuiFilhos;
    private String profissao;
    private int sexo;
    private String endereco;
    private String bairro;
    private String cidade;
    private int cep;
    
    public Clientes(int codigo, String nome,Date dataNascimento,int tipoDocumento,int estadoCivil,boolean possuiFilhos, String profissao,int sexo, String endereco, String bairro, String cidade, int cep) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipoDocumento = tipoDocumento;
        this.estadoCivil =estadoCivil;
        this.possuiFilhos = possuiFilhos;
        this.profissao = profissao;
        this.sexo = sexo;
        this.endereco = endereco;  
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        
    }
    public Clientes(){
        
    }
       /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the tipoDocumento
     */
    public int getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the estadoCivil
     */
    public int getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the possuiFilhos
     */
    public boolean isPossuiFilhos() {
        return possuiFilhos;
    }

    /**
     * @param possuiFilhos the possuiFilhos to set
     */
    public void setPossuiFilhos(boolean possuiFilhos) {
        this.possuiFilhos = possuiFilhos;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the sexo
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }
}
