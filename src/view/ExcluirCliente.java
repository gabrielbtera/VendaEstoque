/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ExcluirCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form EscluirClientes
     */
    public ExcluirCliente() {
        initComponents();
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
        pegaCpfeexclui = new javax.swing.JTextField();
        botaoExcluirCliente = new javax.swing.JButton();
        botaoCancelaExclusaoDeCliente = new javax.swing.JButton();

        setClosable(true);
        setTitle("Excluir");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("DIGITE O CPF DO CLIETE:");

        botaoExcluirCliente.setText("EXCLUIR CLIENTE");
        botaoExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirClienteActionPerformed(evt);
            }
        });

        botaoCancelaExclusaoDeCliente.setText("CANCELAR");
        botaoCancelaExclusaoDeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaExclusaoDeClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pegaCpfeexclui, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCancelaExclusaoDeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoExcluirCliente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pegaCpfeexclui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelaExclusaoDeCliente)
                    .addComponent(botaoExcluirCliente))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirClienteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "INSERIR NOME DO CLIENTE?", "Responda",JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                this.dispose();
        }
    }//GEN-LAST:event_botaoExcluirClienteActionPerformed

    private void botaoCancelaExclusaoDeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaExclusaoDeClienteActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(null, "DESEJA SAIR?", "Responda",JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                this.dispose();
        }
    }//GEN-LAST:event_botaoCancelaExclusaoDeClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelaExclusaoDeCliente;
    private javax.swing.JButton botaoExcluirCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField pegaCpfeexclui;
    // End of variables declaration//GEN-END:variables
}