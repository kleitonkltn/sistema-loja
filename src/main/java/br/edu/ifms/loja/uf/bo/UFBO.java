/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.uf.dao.UFDAO;
import br.edu.ifms.loja.uf.datamodel.UF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NVIDIA
 */
public class UFBO extends GenericBO<UF> {

    private UFDAO daoUF;

    public UFBO() {
        super(UF.class);
        daoUF = new UFDAO();
    }

    public List<UF> buscarClientePorNome(String nome) {
        return daoUF.buscarUFPorNome(nome);
    }

    public List<UF> buscarClientePorSigla(String sigla) {
        return daoUF.buscarUFPorSigla(sigla);
    }

    public List<UF> buscarClientePorSiglaouNome(String param) {
        return daoUF.buscarUFPorSiglaOuNome(param, param);
    }

}
