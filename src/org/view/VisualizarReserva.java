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
import org.model.Reserva;
import static org.view.EdxLivros.setA;
import static org.view.EdxLivros.setAu;
import static org.view.EdxLivros.setE;
import static org.view.EdxLivros.setEd;
import static org.view.EdxLivros.setI;
import static org.view.EdxLivros.setL;
import static org.view.EdxLivros.setP;
import static org.view.EdxLivros.setT;
import static org.view.EdxLivros.setTm;

/**
 *
 * @author Aluno Manha
 */
public class VisualizarReserva extends javax.swing.JFrame {
    Consulta c = new Consulta();
    public void listarReservas() {
        try {
            String tipo;
            String e;
            DefaultTableModel modelo = new DefaultTableModel();
            jTable1.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("ID");
            modelo.addColumn("Titulo do livro");
            modelo.addColumn("Nome do funcionário");
            modelo.addColumn("Data de reserva");
            modelo.addColumn("Efetuada");

            Connection conexao = org.model.Conexao.getConexao();
            switch (String.valueOf(jcbPesquisar.getSelectedItem())) { // Inserindo baseado no tipo
                case "Efetuadas":

                    ArrayList<Reserva> reservas = Reserva.listar(conexao, "1");

                    for (Reserva reserva : reservas) {

                        if (reserva.isEfetuada() == true) {
                            e = "Efetuada";
                        } else {
                            e = "Não-Efetuada";
                        }

                        modelo.addRow(new Object[]{reserva.getId(), reserva.getTitulo(), reserva.getNome(), reserva.getData(), e});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Não Efetuadas":

                    ArrayList<Reserva> r = Reserva.listar(conexao, "0");

                    for (Reserva reserva : r) {

                        if (reserva.isEfetuada() == true) {
                            e = "Efetuada";
                        } else {
                            e = "Não-Efetuada";
                        }

                        if ("1".equals(reserva.isEfetuada())) {
                            tipo = "Disponível";
                        }
                        if ("0".equals(reserva.isEfetuada())) {
                            tipo = "Indisponível";
                        }
                        modelo.addRow(new Object[]{reserva.getId(), reserva.getTitulo(), reserva.getNome(), reserva.getData(), e});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;

                case "Todas":

                    ArrayList<Reserva> rese = Reserva.listarTudao(conexao, "");

                    for (Reserva reserva : rese) {

                        if (reserva.isEfetuada() == true) {
                            e = "Efetuada";
                        } else {
                            e = "Não-Efetuada";
                        }

                        if ("1".equals(reserva.isEfetuada())) {
                            tipo = "Disponível";
                        }
                        if ("0".equals(reserva.isEfetuada())) {
                            tipo = "Indisponível";
                        }
                        modelo.addRow(new Object[]{reserva.getId(), reserva.getTitulo(), reserva.getNome(), reserva.getData(), e});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VisualizarReserva() {
        initComponents();
        listarReservas();
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
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcbPesquisar = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        jPanel1.setBackground(new java.awt.Color(52, 73, 93));

        jbConfirmar.setBackground(java.awt.Color.white);
        jbConfirmar.setForeground(new java.awt.Color(52, 73, 93));
        jbConfirmar.setText("Efetuar Empréstimo");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(java.awt.Color.white);
        jbCancelar.setForeground(new java.awt.Color(52, 73, 93));
        jbCancelar.setText("Cancelar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jcbPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efetuadas", "Não Efetuadas", "Todas" }));
        jcbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbPesquisarMouseClicked(evt);
            }
        });
        jcbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbConfirmar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbConfirmar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbPesquisarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPesquisarMouseClicked

    private void jcbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPesquisarActionPerformed
        listarReservas();         // TODO add your handling code here:
    }//GEN-LAST:event_jcbPesquisarActionPerformed
    private static int id;
    private static String livro;
    private static String mat;
    private static String data;
    private static boolean r;

    public Consulta getC() {
        return c;
    }

    public void setC(Consulta c) {
        this.c = c;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        VisualizarReserva.id = id;
    }

    public static String getLivro() {
        return livro;
    }

    public static void setLivro(String livro) {
        VisualizarReserva.livro = livro;
    }

    public static String getMat() {
        return mat;
    }

    public static void setMat(String mat) {
        VisualizarReserva.mat = mat;
    }

    public static boolean isR() {
        return r;
    }

    public static void setR(boolean r) {
        VisualizarReserva.r = r;
    }
    
    
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
      int linha = jTable1.getSelectedRow();
        setId((int) jTable1.getValueAt(linha, 0));
        setLivro((String) jTable1.getValueAt(linha, 1));
        setMat((String) jTable1.getValueAt(linha,2));
        new FrameSupervisor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JComboBox jcbPesquisar;
    // End of variables declaration//GEN-END:variables
}
