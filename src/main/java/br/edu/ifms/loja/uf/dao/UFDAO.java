/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;

import br.edu.ifms.loja.uf.datamodel.UF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author NVIDIA
 */
public class UFDAO extends GenericDAO<UF> {

    public UFDAO() {
        super(UF.class);
    }

    public List<UF> buscarUFPorNome(String nome) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u ");
        consulta.append("FROM UF u ");
        consulta.append("WHERE u.nome LIKE :nome");

        return em.createQuery(consulta.toString())
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public List<UF> buscarUFPorSigla(String sigla) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u");
        consulta.append("FROM UF u ");
        consulta.append("WHERE u.sigla LIKE :sigla ");

        return em.createQuery(consulta.toString())
                .setParameter("sigla", "%" + sigla + "%")
                .getResultList();
    }

    public List<UF> buscarUFPorSiglaOuNome(String nome, String sigla) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u ");
        consulta.append("FROM UF u ");
        consulta.append("WHERE u.sigla LIKE :sigla ");
        consulta.append("OR u.nome LIKE :nome ");

        return em.createQuery(consulta.toString())
                .setParameter("sigla", "%" + sigla + "%")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();

    }

}
