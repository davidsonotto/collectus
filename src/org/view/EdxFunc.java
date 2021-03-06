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
import org.model.Funcionario;

/**
 *
 * @author Aluno Manha
 */
public class EdxFunc extends javax.swing.JFrame {

    /**
     * Creates new form EdxFunc
     */
    
    public void listar() {
        try {
            String tipo;
            DefaultTableModel modelo = new DefaultTableModel();
            jtFunc.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("Matricula");
            modelo.addColumn("Nome");
            modelo.addColumn("Email");
            modelo.addColumn("Telefone");

            Connection conexao = org.model.Conexao.getConexao();
            switch (String.valueOf(jcbFiltro.getSelectedItem())) { // Inserindo baseado no tipo
                case "Funcionários":

                    ArrayList<Funcionario> funcs = Funcionario.listar(conexao, "f");

                    for (Funcionario func : funcs) {

                        modelo.addRow(new Object[]{func.getMatricula(), func.getNome(), func.getEmail(), func.getTelefone()});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Não Funcionários":

                    ArrayList<Funcionario> f = Funcionario.listar(conexao, "v");

                    for (Funcionario func : f) {
                        if ("f".equals(func.getCargo())) {
                            tipo = "Funcionário";
                        }
                        if ("v".equals(func.getCargo())) {                                                                        
                            tipo = "Visitante";
                        }
                        modelo.addRow(new Object[]{func.getMatricula(), func.getNome(), func.getEmail(), func.getTelefone()});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Todos":

                    ArrayList<Funcionario> f1 = Funcionario.alistar(conexao);

                    for (Funcionario func : f1) {
                        if ("f".equals(func.getCargo())) {
                            tipo = "Funcionário";
                        }
                        if ("v".equals(func.getCargo())) {
                            tipo = "Visitante";
                        }
                        modelo.addRow(new Object[]{func.getMatricula(), func.getNome(), func.getEmail(), func.getTelefone()});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrameSupervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public EdxFunc() {
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

        jPanel1 = new javax.swing.JPanel();
        jbEditar = new javax.swing.JButton();
        jcbFiltro = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFunc = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 73, 93));

        jbEditar.setBackground(java.awt.Color.white);
        jbEditar.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(52, 73, 93));
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jcbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Funcionários", "Não Funcionários", "Todos" }));
        jcbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroActionPerformed(evt);
            }
        });

        jtFunc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtFunc);

        jbExcluir.setBackground(java.awt.Color.white);
        jbExcluir.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(52, 73, 93));
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbExcluir))
                    .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private static int m;
    private static String n;
    private static String e;
    private static String t;

    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        EdxFunc.m = m;
    }

    public static String getN() {
        return n;
    }

    public static void setN(String n) {
        EdxFunc.n = n;
    }

    public static String getE() {
        return e;
    }

    public static void setE(String e) {
        EdxFunc.e = e;
    }

    public static String getT() {
        return t;
    }

    public static void setT(String t) {
        EdxFunc.t = t;
    }
    
    
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int linha = jtFunc.getSelectedRow();

        setM((int) jtFunc.getValueAt(linha, 0));
        setN((String) jtFunc.getValueAt(linha, 1));
        setE((String) jtFunc.getValueAt(linha, 2));
        setT((String) jtFunc.getValueAt(linha, 3));

        new EditarFunc().setVisible(true);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroActionPerformed
        listar();
    }//GEN-LAST:event_jcbFiltroActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Connection conexao = Conexao.getConexao();

            Object id = jtFunc.getValueAt(jtFunc.getSelectedRow(), 0);

            org.model.Funcionario usuario = new org.model.Funcionario((int) id, "");
            usuario.hide(conexao);
            DefaultTableModel modelo = new DefaultTableModel();
            jtFunc.setModel(modelo);
            modelo.setRowCount(0);

        } catch (SQLException e) {
            Logger.getLogger(EdxFunc.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Joao culpado");
        }
        listar();
    }//GEN-LAST:event_jbExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(EdxFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdxFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdxFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdxFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdxFunc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox jcbFiltro;
    private javax.swing.JTable jtFunc;
    // End of variables declaration//GEN-END:variables
}
