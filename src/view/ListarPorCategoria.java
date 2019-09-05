/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entidades.Loja;
import FuncaoFuncionario.FuncaoVendedor;

/**
 *
 * @author Gabriel
 */
public class ListarPorCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form listarProdutosCadastrados
     */
    public ListarPorCategoria() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        areaExibirCategorias = new javax.swing.JTextArea();
        informar = new javax.swing.JLabel();
        checkBebidas = new javax.swing.JButton();
        checkCarnes = new javax.swing.JButton();
        checkHigiene = new javax.swing.JButton();
        checkLimpeza = new javax.swing.JButton();
        checkLeiteDerivados = new javax.swing.JButton();
        checkCereais = new javax.swing.JButton();

        setClosable(true);
        setTitle("Selecione a categoria:");

        areaExibirCategorias.setColumns(20);
        areaExibirCategorias.setRows(5);
        areaExibirCategorias.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                areaExibirCategoriasAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(areaExibirCategorias);

        checkBebidas.setText("Bebidas");
        checkBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBebidasActionPerformed(evt);
            }
        });

        checkCarnes.setText("Carnes");
        checkCarnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCarnesActionPerformed(evt);
            }
        });

        checkHigiene.setText("Higiene");
        checkHigiene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHigieneActionPerformed(evt);
            }
        });

        checkLimpeza.setText("Limpeza");
        checkLimpeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLimpezaActionPerformed(evt);
            }
        });

        checkLeiteDerivados.setText("Leite e Derivados");
        checkLeiteDerivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLeiteDerivadosActionPerformed(evt);
            }
        });

        checkCereais.setText("Cereais");
        checkCereais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCereaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkBebidas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkHigiene))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkCarnes)
                                        .addGap(139, 139, 139)
                                        .addComponent(checkLimpeza)))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkCereais)
                                    .addComponent(checkLeiteDerivados)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(informar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBebidas)
                    .addComponent(checkHigiene)
                    .addComponent(checkLeiteDerivados))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCarnes)
                    .addComponent(checkLimpeza)
                    .addComponent(checkCereais))
                .addGap(1, 1, 1)
                .addComponent(informar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areaExibirCategoriasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_areaExibirCategoriasAncestorAdded
        // TODO add your handling code here:
        areaExibirCategorias.setText("teste");
    }//GEN-LAST:event_areaExibirCategoriasAncestorAdded

    private void checkBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBebidasActionPerformed
         Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();

        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("bebidas"));
    }//GEN-LAST:event_checkBebidasActionPerformed

    private void checkCarnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCarnesActionPerformed
        Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();

        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("carnes"));
    }//GEN-LAST:event_checkCarnesActionPerformed

    private void checkHigieneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHigieneActionPerformed
        Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();

        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("higiene"));
    }//GEN-LAST:event_checkHigieneActionPerformed

    private void checkLimpezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLimpezaActionPerformed
        Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();

        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("limpeza"));
    }//GEN-LAST:event_checkLimpezaActionPerformed

    private void checkLeiteDerivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLeiteDerivadosActionPerformed
        Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();

        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("Leite e derivados"));
    }//GEN-LAST:event_checkLeiteDerivadosActionPerformed

    private void checkCereaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCereaisActionPerformed
        Loja loja = new Loja();
        FuncaoVendedor func = new FuncaoVendedor();
        areaExibirCategorias.setText(loja.listarProdutosporCategoria2("Cereais"));
    }//GEN-LAST:event_checkCereaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaExibirCategorias;
    private javax.swing.JButton checkBebidas;
    private javax.swing.JButton checkCarnes;
    private javax.swing.JButton checkCereais;
    private javax.swing.JButton checkHigiene;
    private javax.swing.JButton checkLeiteDerivados;
    private javax.swing.JButton checkLimpeza;
    private javax.swing.JLabel informar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
