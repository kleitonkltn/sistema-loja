package br.edu.ifms.loja.cliente.view;

import br.edu.ifms.loja.app.components.ComboBoxUFCidade;
import br.edu.ifms.loja.app.layouts.GenericCRUD;

import br.edu.ifms.loja.cliente.bo.ClienteBO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;

import java.awt.Frame;
import java.sql.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import javax.swing.JPanel;

public class ClienteCRUD extends GenericCRUD<Cliente> {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Cliente cliente;

    private ClienteBO clienteBO;
    private ClienteFormulario formularioCliente;
    private ComboBoxUFCidade formularioUFcidade;

    public ClienteCRUD(Frame parent, boolean modal) {
        super(parent, modal, Cliente.class, new String[]{"nome", "email", "dataNascimento", "cidade.nome:Cidade","telefone"});
        clienteBO = new ClienteBO();

        carregarTabela();

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioCliente = new ClienteFormulario();
        formularioUFcidade = new ComboBoxUFCidade();
        formularioCliente.setVisible(true);
        return formularioCliente;
    }

    @Override
    protected void camposParaObjeto() {
        LocalDate dataCO = LocalDate.parse(formularioCliente.getCampoDatadeNascimento().getText(), formato);
        cliente.setNome(formularioCliente.getCampoNome().getText());
        cliente.setCpf(formularioCliente.getCampoCPF().getText());
        cliente.setEmail(formularioCliente.getCampoEmail().getText());
        cliente.setTelefone(formularioCliente.getCampoTelefone().getText());
        cliente.setDataNascimento(Date.valueOf(dataCO));
        cliente.setEndereco(formularioCliente.getCampoEndereco().getText());
        cliente.setNumero(formularioCliente.getCampoNumero().getText());
        cliente.setCidade(formularioCliente.getComboBoxUfCidade().getSelectedCidade());

    }

    @Override
    protected void objetoParaCampos() {
        formularioCliente.getCampoNome().setText(cliente.getNome());
        formularioCliente.getCampoCPF().setText(cliente.getCpf());
        formularioCliente.getCampoEmail().setText(cliente.getEmail());
        formularioCliente.getCampoDatadeNascimento().setText(String.valueOf(cliente.getDataNascimento()));
        formularioCliente.getCampoTelefone().setText(cliente.getTelefone());
        formularioCliente.getCampoEndereco().setText(cliente.getEndereco());
        formularioCliente.getCampoNumero().setText(cliente.getNumero());
        formularioCliente.getComboBoxUfCidade().setSelectedCidade(cliente.getCidade());
    }

    @Override
    protected void salvar() {
        clienteBO.inserir(cliente);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        cliente = new Cliente();

    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        clienteBO.remover(cliente.getIdCliente());
    }

    @Override
    protected List buscar(String param) {
        return clienteBO.buscarClientePorNomeOuCPF(param);
    }

    @Override
    protected List<Cliente> carregarListaParaTabela() {
        return clienteBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Cliente itemSelecionado) {
        this.cliente = itemSelecionado;
    }
}
