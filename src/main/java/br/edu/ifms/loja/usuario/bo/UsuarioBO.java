/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.usuario.dao.UsuarioDAO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import java.util.List;

/**
 *
 * @author NVIDIA
 */
public class UsuarioBO extends GenericBO<Usuario> {

    UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        super(Usuario.class);
        usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> buscarUsuariosPorNome(String nome) {
        return usuarioDAO.listarUsuariosPorNome(nome);
    }
}
