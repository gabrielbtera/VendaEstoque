/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import FuncaoFuncionario.GerenteFuncoes;

/**
 *
 * @author Gabriel
 */
public class ListarProdutosExcluidos extends javax.swing.JInternalFrame {

    /** Creates new form ListarProdutosExcluidos */
    public ListarProdutosExcluidos() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listagemProdutosExcluidos = new javax.swing.JTextArea();
        botaoListaExcluidos = new javax.swing.JButton();
        apareceExcluidos = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Listar Produtos Excuidos");

        listagemProdutosExcluidos.setColumns(20);
        listagemProdutosExcluidos.setRows(5);
        jScrollPane1.setViewportView(listagemProdutosExcluidos);

        botaoListaExcluidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoListaExcluidos.setText("Listar");
        botaoListaExcluidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListaExcluidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apareceExcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
                .addComponent(botaoListaExcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoListaExcluidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apareceExcluidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoListaExcluidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListaExcluidosActionPerformed
        // TODO add your handling code here:
        apareceExcluidos.setText("Produtos excluidos: ");
        GerenteFuncoes func = new GerenteFuncoes();
        listagemProdutosExcluidos.setText(func.listarProdutosExcluidos());
        
    }//GEN-LAST:event_botaoListaExcluidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apareceExcluidos;
    private javax.swing.JButton botaoListaExcluidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listagemProdutosExcluidos;
    // End of variables declaration//GEN-END:variables

}
