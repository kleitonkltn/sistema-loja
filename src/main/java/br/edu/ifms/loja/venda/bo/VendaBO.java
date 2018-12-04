/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.venda.dao.VendaDAO;
import br.edu.ifms.loja.venda.datamodel.Venda;

/**
 *
 * @author NVIDIA
 */
public class VendaBO extends GenericBO<Venda> {

    VendaDAO vendaDAO;

    public VendaBO() {
        super(Venda.class);
        vendaDAO = new VendaDAO();
    }

}
