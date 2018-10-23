/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.datamodel;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import com.towel.el.annotation.Resolvable;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author NVIDIA
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idProduto;

    @Resolvable(colName = "Descrição")
    private String descricao;

    @Resolvable(colName = "Marca")
    private String marca;

    @Resolvable(colName = "Modelo")
    private String modelo;

    @Resolvable(colName = "Quantidade")
    private BigInteger qtde;

    @Resolvable(colName = "Valor")
    private Float valor;

//    @Resolvable(colName = "Fornecedor")
//    private Fornecedor idFornecedor;

}
