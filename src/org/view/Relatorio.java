/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.model.Conexao;
import org.model.Emprestimo;
import org.model.Livro;

/**
 *
 * @author Aluno Manha
 */
public class Relatorio extends javax.swing.JFrame {

    public void listar() {
        try {
            String tipo;
            DefaultTableModel modelo = new DefaultTableModel();
            jtEmprestimo.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("ID");
            modelo.addColumn("Titulo");
            modelo.addColumn("Nome");
            modelo.addColumn("Data de Empréstimo");
            modelo.addColumn("Data de Devolução");
            modelo.addColumn("Ativo");

            Connection conexao = org.model.Conexao.getConexao();
            switch (String.valueOf(jcbFiltro.getSelectedItem())) { // Inserindo baseado no tipo
                case "Ativos":

                    ArrayList<Emprestimo> emprestimos = Emprestimo.listar(conexao, "1");

                    for (Emprestimo e : emprestimos) {

                        if ((e.isAtivo() == true)) {
                            tipo = "Ativo";
                        } else {
                            tipo = "Desativo";
                        }

                        modelo.addRow(new Object[]{e.getId(), e.getTitulo(), e.getNome(), e.getDataE(), e.getDataD(), tipo});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Desativos":

                    ArrayList<Emprestimo> emps = Emprestimo.listar(conexao, "0");

                    for (Emprestimo e : emps) {

                        if ((e.isAtivo() == true)) {
                            tipo = "Ativo";
                        } else {
                            tipo = "Desativo";
                        }
                        
                        modelo.addRow(new Object[]{e.getId(), e.getTitulo(), e.getNome(), e.getDataE(), e.getDataD(), tipo});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;

                case "Todos":

                    ArrayList<Emprestimo> f1 = Emprestimo.alistar(conexao);
                    for (Emprestimo e : f1) {

                        if ((e.isAtivo() == true)) {
                            tipo = "Ativo";
                        } else {
                            tipo = "Desativo";
                        }

                        modelo.addRow(new Object[]{e.getId(), e.getTitulo(), e.getNome(), e.getDataE(), e.getDataD(), tipo});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Relatorio() {
        initComponents();
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmprestimo = new javax.swing.JTable();
        jcbFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 73, 93));

        jbExcluir.setBackground(java.awt.Color.white);
        jbExcluir.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(52, 73, 93));
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setBackground(java.awt.Color.white);
        jbEditar.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(52, 73, 93));
        jbEditar.setText("Desativar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jtEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtEmprestimo);

        jcbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativos", "Desativos", "Todos" }));
        jcbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Empréstimos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbEditar)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Connection conexao = Conexao.getConexao();

            int id = (int) jtEmprestimo.getValueAt(jtEmprestimo.getSelectedRow(), 0);

            Emprestimo e = new Emprestimo(id, "");
            Livro l = new Livro(id, "");
            e.hide(conexao);
            l.deshide(conexao);

        } catch (SQLException e) {
            Logger.getLogger(org.view.EdxLivros.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Joao culpado");
        }
        listar();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroActionPerformed
        listar();
    }//GEN-LAST:event_jcbFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox jcbFiltro;
    private javax.swing.JTable jtEmprestimo;
    // End of variables declaration//GEN-END:variables
}
