/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.app.components;

import br.edu.ifms.loja.cidade.bo.CidadeBO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.uf.bo.UFBO;
import br.edu.ifms.loja.uf.datamodel.UF;
import com.towel.combo.swing.ObjectComboBoxModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NVIDIA
 */
public class ComboBoxUFCidade extends javax.swing.JPanel {

    private UFBO ufBO;
    private CidadeBO cidadeBO;
    private ObjectComboBoxModel<UF> ufModel;
    private ObjectComboBoxModel<Cidade> cidadeModel;

    public ComboBoxUFCidade() {
        initComponents();
        ufBO = new UFBO();
        cidadeBO = new CidadeBO();

        ufModel = new ObjectComboBoxModel<UF>();
        cidadeModel = new ObjectComboBoxModel<Cidade>();

        comboBoxUF.setModel(ufModel);
        comboBoxCidade.setModel(cidadeModel);
        carregarUFs();
    }

    private void carregarUFs() {
        List<UF> ufs = ufBO.listarTodos();
        ufModel.setData(ufs);
        cidadeModel.setData(new ArrayList<Cidade>());
        ufModel.setSelectedObject(null);
        cidadeModel.setSelectedObject(null);
        comboBoxUF.updateUI();
    }

    private void carregarCidades(UF uf) {
        cidadeModel.setSelectedObject(null);
        List<Cidade> cidades = cidadeBO.listarCidadesPorIdUF(uf.getIdUF());
        cidadeModel.setData(cidades);
        comboBoxCidade.updateUI();
    }

    public Cidade getSelectedCidade() {
        return cidadeModel.getSelectedObject();
    }

    public void setSelectedCidade(Cidade cidade) {
        carregarUFs();

        if (cidade == null) {
            return;
        }

        ufModel.setSelectedObject(cidade.getUf());
        carregarCidades(cidade.getUf());
        cidadeModel.setSelectedObject(cidade);
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
        comboBoxUF = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboBoxCidade = new javax.swing.JComboBox<>();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("UF:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        comboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxUF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxUFItemStateChanged(evt);
            }
        });
        comboBoxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUFActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cidade:");

        comboBoxCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(comboBoxUF, 0, 125, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCidade, 0, 234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxUF)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxUFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxUFItemStateChanged
        UF uf = ufModel.getSelectedObject();
        if (uf == null) {
            return;
        }
        carregarCidades(uf);
    }//GEN-LAST:event_comboBoxUFItemStateChanged

    private void comboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxUFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxCidade;
    private javax.swing.JComboBox<String> comboBoxUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
