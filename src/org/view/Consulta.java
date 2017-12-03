/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import org.model.Livro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.model.Conexao;

/**
 *
 * @author Aluno Manha
 */
public class Consulta extends javax.swing.JFrame {

    /**
     * Creates new form Consulta
     */
    public void listarLivros() {

        try {
            String d;
            DefaultTableModel modelo = new DefaultTableModel();
            jtLivros.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("ID");
            modelo.addColumn("Titulo");
            modelo.addColumn("Tema");
            modelo.addColumn("Edição");
            modelo.addColumn("Local");
            modelo.addColumn("Editora");
            modelo.addColumn("Ano");
            modelo.addColumn("Páginas");
            modelo.addColumn("Disponível");
            modelo.addColumn("Reservado");
            Connection conexao = Conexao.getConexao();
            ArrayList<Livro> livros = Livro.pesquisar(conexao, jtfPEsquisar.getText());
            for (Livro livro : livros) {
                if (livro.getLivre() == true) {
                    d = "Disponível";
                } else {
                    d = "Indisponível";
                }
                modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getTema(), livro.getEdicao(), livro.getLocal(), livro.getEditora(), livro.getAno(), livro.getPagtotais(), livro.getLivre(), livro.isReservado()});
            }
            Conexao.closeAll(conexao);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarCombo() {
        try {
            String tipo;
            String d;
            String r;
            DefaultTableModel modelo = new DefaultTableModel();
            jtLivros.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("ID");
            modelo.addColumn("Titulo");
            modelo.addColumn("Autor");
            modelo.addColumn("Tema");
            modelo.addColumn("Edição");
            modelo.addColumn("Local");
            modelo.addColumn("Editora");
            modelo.addColumn("Ano");
            modelo.addColumn("Páginas");
            modelo.addColumn("Disponibilidade");

            Connection conexao = org.model.Conexao.getConexao();
            switch (String.valueOf(jcbFiltro.getSelectedItem())) { // Inserindo baseado no tipo
                case "Disponível":

                    ArrayList<Livro> livros = Livro.listar(conexao, "1");
                    for (Livro livro : livros) {
                        if ((livro.getLivre() == true) ) {
                            d = "Disponível";
                        } else {
                            d = "Indisponível";
                        }

                        modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getTema(), livro.getEdicao(), livro.getLocal(), livro.getEditora(), livro.getAno(), livro.getPagtotais(), d});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Indisponível":

                    ArrayList<Livro> l = Livro.listar(conexao, "0");

                    for (Livro livro : l) {
                        if ((livro.getLivre() == true)) {
                            d = "Disponível";
                        } else {
                            d = "Indisponível";
                        }
                        if ("1".equals(livro.getLivre())) {
                            tipo = "Disponível";
                        }
                        if ("0".equals(livro.getLivre())) {
                            tipo = "Indisponível";
                        }
                        modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getTema(), livro.getEdicao(), livro.getLocal(), livro.getEditora(), livro.getAno(), livro.getPagtotais(), d});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
                case "Todos":

                    ArrayList<Livro> l1 = Livro.listarTudo(conexao, "");

                    for (Livro livro : l1) {
                        if ((livro.getLivre() == true)) {
                            d = "Disponível";
                        } else {
                            d = "Indisponível";
                        }
                        if ("1".equals(livro.getLivre())) {
                            tipo = "Disponível";
                        }
                        if ("0".equals(livro.getLivre())) {
                            tipo = "Indisponível";
                        }
                        modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getTema(), livro.getEdicao(), livro.getLocal(), livro.getEditora(), livro.getAno(), livro.getPagtotais(), d});
                    }
                    org.model.Conexao.closeAll(conexao);
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Consulta() {
        initComponents();
        listarCombo();
    }

    private static String nlivro;
    private static int idlivro;

    public String getNlivro() {
        return nlivro;
    }

    public void setNlivro(String nlivro) {
        this.nlivro = nlivro;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(int idlivro) {
        this.idlivro = idlivro;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        jbPesquisar = new javax.swing.JButton();
        jtfPEsquisar = new javax.swing.JTextField();
        jcbFiltro = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jbLogin = new javax.swing.JButton();
        jbReservar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmiLogin = new javax.swing.JMenuItem();
        jmiReservas = new javax.swing.JMenuItem();
        jmSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta");
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 73, 93));

        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
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
        jtLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLivros);

        jbPesquisar.setBackground(java.awt.Color.white);
        jbPesquisar.setForeground(new java.awt.Color(52, 73, 93));
        jbPesquisar.setText("IR");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jcbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponível", "Indisponível", "Todos" }));
        jcbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(52, 73, 93));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jbLogin.setBackground(java.awt.Color.white);
        jbLogin.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbLogin.setForeground(new java.awt.Color(52, 73, 93));
        jbLogin.setText("Login");
        jbLogin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jbLoginAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        jbReservar.setBackground(java.awt.Color.white);
        jbReservar.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbReservar.setForeground(new java.awt.Color(52, 73, 93));
        jbReservar.setText("Reservar");
        jbReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReservarActionPerformed(evt);
            }
        });

        jbSair.setBackground(java.awt.Color.white);
        jbSair.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbSair.setForeground(new java.awt.Color(52, 73, 93));
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/images/output_5DIGQi.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jbReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfPEsquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbPesquisar)
                        .addComponent(jtfPEsquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbFiltro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jmArquivo.setBackground(new java.awt.Color(52, 73, 93));
        jmArquivo.setForeground(new java.awt.Color(52, 73, 93));
        jmArquivo.setText("Arquivo");

        jmiLogin.setText("Login");
        jmiLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLoginActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiLogin);

        jmiReservas.setText("Reservas");
        jmArquivo.add(jmiReservas);

        jMenuBar1.add(jmArquivo);

        jmSobre.setForeground(new java.awt.Color(52, 73, 93));
        jmSobre.setText("Sobre");
        jMenuBar1.add(jmSobre);

        setJMenuBar(jMenuBar1);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLoginAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jbLoginAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLoginAncestorAdded

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jbReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReservarActionPerformed
        jtLivrosMouseClicked(null);
    }//GEN-LAST:event_jbReservarActionPerformed

    private void jmiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLoginActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmiLoginActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        listarLivros();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jcbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroActionPerformed
        listarCombo();        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFiltroActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbSairActionPerformed

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        int linha = jtLivros.getSelectedRow();
        String d = (String) jtLivros.getValueAt(linha, 9);
        if ("Disponível".equals(d)) {
            setIdlivro((int) jtLivros.getValueAt(linha, 0));
            setNlivro((String) jtLivros.getValueAt(linha, 1));
            new CadastroReserva().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "O livro está indisponível, portando não poderá fazer a reserva");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtLivrosMouseClicked

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbLogin;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbReservar;
    private javax.swing.JButton jbSair;
    private javax.swing.JComboBox jcbFiltro;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmSobre;
    private javax.swing.JMenuItem jmiLogin;
    private javax.swing.JMenuItem jmiReservas;
    private javax.swing.JTable jtLivros;
    private javax.swing.JTextField jtfPEsquisar;
    // End of variables declaration//GEN-END:variables
}
