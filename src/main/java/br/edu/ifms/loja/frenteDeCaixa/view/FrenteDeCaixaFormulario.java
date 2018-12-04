/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.frenteDeCaixa.view;

import br.edu.ifms.loja.app.components.FormListarProdutos;
import br.edu.ifms.loja.produto.bo.ProdutoBO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.venda.view.VendaFormulario;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.KeyEvent;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

/**
 *
 * @author NVIDIA
 */
public class FrenteDeCaixaFormulario extends javax.swing.JFrame {

    private AnnotationResolver resolver;
    private Class clazz;
    private int qtdItens = 0;
    private int qtdProdutos = 0;
    private Double total = 0.0;
    VendaFormulario vendaFormulario;
    List<Produto> listProdutos;
    private String[] cabecalhoTabela = {"descricao", "qtde", "valor", "valorTotal"};

    private ObjectTableModel<Produto> prodModel;
    FormListarProdutos formProdutos;
    Produto produto;

    public FrenteDeCaixaFormulario() {
        initComponents();
        this.CampoValorTotalItem.setEditable(false);
        this.btAddProduto.setEnabled(false);
        this.campoProduto.setEditable(false);
        this.campovalorTotalVenda.setEditable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        inicializarObjectTableModel(cabecalhoTabela);
        produto = new Produto();
        listProdutos = new ArrayList<>();

    }

    private void inicializarObjectTableModel(String[] cabecalhoTabela) {
        StringBuilder campos = new StringBuilder();
        for (String campo : cabecalhoTabela) {
            campos.append(campo);
            campos.append(",");
        }
        campos.deleteCharAt(campos.length() - 1);

        prodModel = new ObjectTableModel<Produto>(Produto.class, campos.toString());
        tabelaPreVenda.setModel(prodModel);
    }

    private void addProduto(Produto objProduto) {

        if (listProdutos.contains(objProduto)) {

            objProduto.setQtde(Integer.parseInt(getCampoQtde().getText()) + objProduto.getQtde());
            objProduto.setValorTotal(objProduto.getQtde() * objProduto.getValor());

        } else {

            objProduto.setQtde(Integer.parseInt(getCampoQtde().getText()));
            objProduto.setValorTotal(Float.parseFloat(getCampoQtde().getText()) * objProduto.getValor());
            listProdutos.add(objProduto);
        }
        limparCampos();
        prodModel.setData(listProdutos);
        tabelaPreVenda.updateUI();
        this.btAddProduto.setEnabled(false);
        PreencherCamposQuantitativos();
        openFormListarProdutos();

    }

    private void finalizarVenda() {
        Object[] options = {"Sim", "Não"};
        int opcao2 = JOptionPane.showOptionDialog(null, "Deseja finalizar a venda?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (opcao2 == 0) {
            vendaFormulario = new VendaFormulario(this.campovalorTotalVenda.getText(),listProdutos);
            vendaFormulario.setVisible(true);
        } else if (opcao2 == 1) {
            JOptionPane.showMessageDialog(null, "-");
        }

    }

    public String Moeda(String valor) {
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        double valorD = Double.parseDouble(valor.replaceAll("R|$| ", "").replaceAll(",", "."));
        return formato.format(valorD).replaceAll(",", ".");
    }

    public void PreencherCamposQuantitativos() {
        this.qtdItens = 0;
        this.qtdProdutos = 0;
        this.total = 0.0;
        listProdutos.forEach((listProduto) -> {
            this.qtdItens++;
            this.qtdProdutos = qtdProdutos + listProduto.getQtde();
            this.total = listProduto.getValorTotal() + this.total;
        });
        System.out.println("qtdProdutos" + this.qtdProdutos + "\n qtdItens" + qtdItens);
        System.out.println("final");
        this.campovalorTotalVenda.setText(Moeda(String.valueOf(this.total)));
        this.labelItensTabela.setText(String.valueOf(qtdItens));
        this.labelQtdeTabela.setText(String.valueOf(qtdProdutos));
    }

    private void limparCampos() {
        getCampoProduto().setText("");
        getCampoValorTotalItem().setText("");
        getCampoQtde().setText("");
    }

    public void obterItemSelecionado(Produto objProduto) {
        produto = objProduto;
        getCampoProduto().setText(objProduto.getDescricao());
        getCampoQtde().setText("1");
        getCampoValorTotalItem().setText(String.valueOf(objProduto.getValor()));
        this.btAddProduto.setEnabled(true);

    }

    public void openFormListarProdutos() {
        formProdutos = new FormListarProdutos(this);
        formProdutos.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPreVenda = new javax.swing.JTable();
        btFinalizarVenda = new javax.swing.JButton();
        campoProduto = new javax.swing.JTextField();
        campoQtde = new javax.swing.JTextField();
        CampoValorTotalItem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btCancelarPreVenda = new javax.swing.JButton();
        btAddProduto = new javax.swing.JButton();
        campovalorTotalVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelQtdeTabela = new javax.swing.JLabel();
        labelItensTabela = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caixa");
        jLabel1.setToolTipText("");

        tabelaPreVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaPreVenda);

        btFinalizarVenda.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.selectionBackground"));
        btFinalizarVenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btFinalizarVenda.setForeground(new java.awt.Color(0, 204, 102));
        btFinalizarVenda.setText("Confirmar Pré-Venda(F3)                     ");
        btFinalizarVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarVendaActionPerformed(evt);
            }
        });

        campoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProdutoActionPerformed(evt);
            }
        });

        campoQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQtdeActionPerformed(evt);
            }
        });
        campoQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoQtdeKeyReleased(evt);
            }
        });

        CampoValorTotalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoValorTotalItemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Produto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Quantidade");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Valor Total do Item");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Itens");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Quantidade");

        btCancelarPreVenda.setText("Cancelar Pré Venda");

        btAddProduto.setBackground(java.awt.SystemColor.activeCaption);
        btAddProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btAddProduto.setForeground(java.awt.SystemColor.textHighlight);
        btAddProduto.setIcon(new javax.swing.ImageIcon("C:\\Users\\NVIDIA\\Downloads\\shopping-cart.png")); // NOI18N
        btAddProduto.setText("Adicionar+");
        btAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProdutoActionPerformed(evt);
            }
        });

        campovalorTotalVenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campovalorTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campovalorTotalVendaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Valor Total");

        labelQtdeTabela.setText("0");

        labelItensTabela.setText("0");

        btBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\NVIDIA\\Downloads\\musica-searcher.png")); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btCancelarPreVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoQtde, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(CampoValorTotalItem, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                            .addComponent(btAddProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoProduto)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelItensTabela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelQtdeTabela)
                                .addGap(19, 19, 19))
                            .addComponent(btFinalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campovalorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoProduto)
                            .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(CampoValorTotalItem))
                        .addGap(86, 86, 86)
                        .addComponent(btAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(labelItensTabela))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(labelQtdeTabela)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campovalorTotalVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelarPreVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btFinalizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoQtdeActionPerformed

    private void campoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProdutoActionPerformed

    }//GEN-LAST:event_campoProdutoActionPerformed

    private void CampoValorTotalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoValorTotalItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoValorTotalItemActionPerformed

    private void campovalorTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campovalorTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campovalorTotalVendaActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        openFormListarProdutos();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void campoQtdeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoQtdeKeyReleased
        if (getCampoValorTotalItem().getText().length() > 0) {
            getCampoValorTotalItem().setText(String.valueOf(produto.getValor() * Double.parseDouble(getCampoQtde().getText())));
        }

    }//GEN-LAST:event_campoQtdeKeyReleased

    private void btAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutoActionPerformed

        addProduto(produto);
        produto = new Produto();


    }//GEN-LAST:event_btAddProdutoActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt instanceof KeyEvent) {
            if (evt.getID() == KeyEvent.KEY_PRESSED) {
                switch (((KeyEvent) evt).getKeyCode()) {

                    case KeyEvent.VK_F3:
                        finalizarVenda();
                        break;

                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void btFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarVendaActionPerformed
        finalizarVenda();
    }//GEN-LAST:event_btFinalizarVendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrenteDeCaixaFormulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrenteDeCaixaFormulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrenteDeCaixaFormulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrenteDeCaixaFormulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrenteDeCaixaFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoValorTotalItem;
    private javax.swing.JButton btAddProduto;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelarPreVenda;
    private javax.swing.JButton btFinalizarVenda;
    private javax.swing.JTextField campoProduto;
    private javax.swing.JTextField campoQtde;
    private javax.swing.JTextField campovalorTotalVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelItensTabela;
    private javax.swing.JLabel labelQtdeTabela;
    private javax.swing.JTable tabelaPreVenda;
    // End of variables declaration//GEN-END:variables
private JTextField getCampoValorTotalItem() {
        return CampoValorTotalItem;
    }

    private void setCampoValorTotalItem(JTextField CampoValorTotalItem) {
        this.CampoValorTotalItem = CampoValorTotalItem;
    }

    private JTextField getCampoQtde() {
        return campoQtde;
    }

    private void setCampoQtde(JTextField campoQtde) {
        this.campoQtde = campoQtde;
    }

    private JLabel getLabelItensTabela() {
        return labelItensTabela;
    }

    private void setLabelItensTabela(JLabel labelItensTabela) {
        this.labelItensTabela = labelItensTabela;
    }

    private JLabel getLabelQtdeTabela() {
        return labelQtdeTabela;
    }

    private void setLabelQtdeTabela(JLabel labelQtdeTabela) {
        this.labelQtdeTabela = labelQtdeTabela;
    }

    private JTextField getValorTotalVenda() {
        return campovalorTotalVenda;
    }

    private void setValorTotalVenda(JTextField valorTotalVenda) {
        this.campovalorTotalVenda = valorTotalVenda;
    }

    private JTextField getCampoProduto() {
        return campoProduto;
    }

    private void setCampoProduto(String campoProduto) {
        this.campoProduto.setText(campoProduto);
    }

}
