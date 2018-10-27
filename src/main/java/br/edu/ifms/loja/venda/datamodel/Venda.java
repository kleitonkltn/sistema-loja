/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.datamodel;

import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.usuario.datamodel.Usuario;

import com.towel.el.annotation.Resolvable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Venda {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idItemVendaVenda;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Usuario usuario;

    private Date dataVenda;


    

}
