/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.datamodel;

import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author NVIDIA
 */
@Entity
public class UF {

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idUF;

    @Resolvable(colName = "Nome")
    private String nome;

    @Resolvable(colName = "Sigla")
    private String sigla;

    @Resolvable(colName = "ICMS")
    private float icms;
    
    
    public Long getIdUF() {
        return idUF;
    }

    public UF() {

    }

    public void setIdUF(Long idUF) {
        this.idUF = idUF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public float getIcms() {
        return icms;
    }

    public void setIcms(float icms) {
        this.icms = icms;
    }

}
