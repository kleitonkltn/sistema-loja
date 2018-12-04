package br.edu.ifms.loja.usuario.view;

import br.edu.ifms.loja.app.components.ComboBoxUFCidade;
import br.edu.ifms.loja.app.layouts.GenericCRUD;

import br.edu.ifms.loja.usuario.bo.UsuarioBO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;

import java.awt.Frame;
import java.sql.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import javax.swing.JPanel;

public class UsuarioCRUD extends GenericCRUD<Usuario> {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Usuario usuario;
    private UsuarioBO usuarioBO;
    private UsuarioFormulario formularioUsuario;
    private ComboBoxUFCidade formularioUFcidade;

    public UsuarioCRUD(Frame parent, boolean modal) {
        super(parent, modal, Usuario.class, new String[]{"nome", "email", "cidade.nome:Cidade","senha"});
        usuarioBO = new UsuarioBO();

        carregarTabela();

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioUsuario = new UsuarioFormulario();
        formularioUFcidade = new ComboBoxUFCidade();
        formularioUsuario.setVisible(true);
        return formularioUsuario;
    }

    @Override
    protected void camposParaObjeto() {

        usuario.setNome(formularioUsuario.getCampoNome().getText());
        usuario.setEmail(formularioUsuario.getCampoEmail().getText());
        usuario.setSenha(formularioUsuario.getCampoSenha().getPassword().toString());
        usuario.setPapel(formularioUsuario.getCampoPapel().getText());
        usuario.setEndereco(formularioUsuario.getCampoEndereco().getText());
        usuario.setNumero(formularioUsuario.getCampoNumero().getText());
        usuario.setCep(formularioUsuario.getCampoCEP().getText());
        usuario.setCidade(formularioUsuario.getComboBoxUfCidade().getSelectedCidade());

    }

    @Override
    protected void objetoParaCampos() {
        formularioUsuario.getCampoNome().setText(usuario.getNome());
        formularioUsuario.getCampoCEP().setText(usuario.getCep());
        formularioUsuario.getCampoEmail().setText(usuario.getEmail());
        formularioUsuario.getCampoPapel().setText(usuario.getPapel());
        formularioUsuario.getCampoSenha().setText(usuario.getSenha());
        formularioUsuario.getCampoEndereco().setText(usuario.getEndereco());
        formularioUsuario.getCampoNumero().setText(usuario.getNumero());
        formularioUsuario.getComboBoxUfCidade().setSelectedCidade(usuario.getCidade());
    }

    @Override
    protected void salvar() {
        usuarioBO.inserir(usuario);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        usuario = new Usuario();

    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        usuarioBO.remover(usuario.getId());
    }

    @Override
    protected List buscar(String param) {
        return usuarioBO.buscarUsuariosPorNome(param);
    }

    @Override
    protected List<Usuario> carregarListaParaTabela() {
        return usuarioBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Usuario itemSelecionado) {
        this.usuario = itemSelecionado;
    }

}
