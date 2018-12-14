/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.itemVenda.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.itemVenda.dao.ItemVendaDAO;
import br.edu.ifms.loja.itemVenda.datamodel.ItemVenda;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.venda.datamodel.Venda;
import java.util.List;

/**
 *
 * @author NVIDIA
 */
public class ItemVendaBO extends GenericBO<ItemVenda> {

    ItemVendaDAO itemVendaDAO;

    public ItemVendaBO() {
        super(ItemVenda.class);
        itemVendaDAO = new ItemVendaDAO();

    }

    public void inserirItens(Venda venda, List<Produto> itensList, double vTotal) {
        itemVendaDAO.inserirItens(venda, itensList, vTotal);
    }

}
