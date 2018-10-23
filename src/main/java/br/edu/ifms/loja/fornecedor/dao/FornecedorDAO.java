package br.edu.ifms.loja.fornecedor.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;

import java.util.List;
import javax.persistence.EntityManager;

public class FornecedorDAO extends GenericDAO<Fornecedor> {

    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    public List<Fornecedor> buscarFornecedorPorNomeFantasia(String nomeFantasia) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT f ");
        consulta.append("FROM Fornecedor f ");
        consulta.append("WHERE f.nomefantasia LIKE :Nomefantasia");

        return em.createQuery(consulta.toString())
                .setParameter("Nomefantasia", "%"+nomeFantasia + "%")
                .getResultList();
    }
//    public List<Fornecedor> buscarFornecedorPorCNPJ(String cnpj) {
//        EntityManager em = getEntityManager();
//
//        StringBuilder consulta = new StringBuilder();
//        consulta.append("SELECT f ");
//        consulta.append("FROM Fornecedor f ");
//        consulta.append("WHERE f.cnpj LIKE %:cnpj% ");
//
//        return em.createQuery(consulta.toString())
//                .setParameter("cnpj", cnpj)
//                .getResultList();
//    }



}
