/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.cidade.dao.CidadeDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NVIDIA
 */
public class CidadeBO extends GenericBO<Cidade> {

    private CidadeDAO cidadeDAO;

    public CidadeBO() {
        super(Cidade.class);
        cidadeDAO = new CidadeDAO();
    }

    public List<Cidade> listarCidadesPorIdUF(Long idUF) {
        return cidadeDAO.listarCidadesPorIdUF(idUF);
    }

}
