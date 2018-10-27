/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.datamodel;

import br.edu.ifms.loja.uf.datamodel.UF;
import com.towel.el.annotation.Resolvable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.OneToMany;

/**
 *
 * @author NVIDIA
 */
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idCidade;

    @Resolvable(colName = "Nome")
    private String nome;

    @ManyToOne
    private UF idUF;

}
