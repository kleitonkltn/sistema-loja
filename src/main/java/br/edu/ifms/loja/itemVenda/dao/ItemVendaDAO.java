/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.itemVenda.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.itemVenda.datamodel.ItemVenda;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.venda.datamodel.Venda;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author NVIDIA
 */
public class ItemVendaDAO extends GenericDAO<ItemVenda> {

    
    EntityManager em;

    public ItemVendaDAO() {

        super(ItemVenda.class);
        em = getEntityManager();
    }

    public void inserirItens(Venda venda, List<Produto> itensList, double vTotal) {
        ItemVenda itemVenda;
        em.getTransaction().begin();
        for (int i = 0; i < itensList.size(); i++) {
            itemVenda= new ItemVenda();
            itemVenda.setProduto(itensList.get(i));
            itemVenda.setQtdeVenda(itensList.get(i).getQtde());
            itemVenda.setValorVenda(vTotal);
            itemVenda.setVenda(venda);
            em.persist(itemVenda);
        }
        em.getTransaction().commit();
    }
}
