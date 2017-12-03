/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import org.model.Emprestimo;
import org.model.Funcionario;
import org.model.Livro;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.model.Conexao;

/**
 *
 * @author Aluno Manha
 */
public class FrameSupervisor extends javax.swing.JFrame {
    VisualizarReserva vr = new VisualizarReserva();
    /**
     * Creates new form FrameSupervisor
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
            switch (String.valueOf(jcbFunc.getSelectedItem())) { // Inserindo baseado no tipo
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

    public void pesquisar() {
        try {
            String tipo;
            DefaultTableModel modelo = new DefaultTableModel();
            jtFunc.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("Matricula");
            modelo.addColumn("Nome");
            modelo.addColumn("Email");
            modelo.addColumn("Telefone");
            Connection conexao = Conexao.getConexao();
            ArrayList<Funcionario> funcionarios = Funcionario.pesquisar(conexao, jtfFunc.getText());
            for (Funcionario func : funcionarios) {
                modelo.addRow(new Object[]{func.getMatricula(), func.getNome(), func.getEmail(), func.getTelefone()});
            }
            Conexao.closeAll(conexao);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pesquisarLivros() {
        try {
            String d;
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
            Connection conexao = Conexao.getConexao();
            ArrayList<Livro> livros = Livro.pesquisar(conexao, jtfPesquisar.getText());
            for (Livro livro : livros) {
                if (livro.getLivre() == true) {
                            d = "Disponível";
                        } else {
                            d = "Indisponível";
                        }
                modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getTema(), livro.getEdicao(), livro.getLocal(), livro.getEditora(), livro.getAno(), livro.getPagtotais(), d});
            }
            Conexao.closeAll(conexao);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarLivros() {
        try {
            String tipo;
            String d;
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
            switch (String.valueOf(jcbPesquisar.getSelectedItem())) { // Inserindo baseado no tipo
                case "Disponível":

                    ArrayList<Livro> livros = Livro.listar(conexao, "1");

                    for (Livro livro : livros) {

                        if ((livro.getLivre() == true)) {
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

                        if ((livro.getLivre() == true) ) {
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

                        if ((livro.getLivre() == true) ) {
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

    public FrameSupervisor() {
        initComponents();
        listar();
        listarLivros();
        System.out.println(l.getLogin());
        jtfSuper.setText(l.getLogin());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jbEmprestimo = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbReservas = new javax.swing.JButton();
        jbLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        jcbPesquisar = new javax.swing.JComboBox();
        jtfPesquisar = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jpEmprestimo = new javax.swing.JPanel();
        jlSuper = new javax.swing.JLabel();
        jtfSuper = new javax.swing.JTextField();
        jlDataE = new javax.swing.JLabel();
        jlDataEn = new javax.swing.JLabel();
        jlLivro = new javax.swing.JLabel();
        jtfLivro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbPesquisar1 = new javax.swing.JButton();
        jtfFunc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFunc = new javax.swing.JTable();
        jcbFunc = new javax.swing.JComboBox();
        jtfNome = new javax.swing.JTextField();
        jlFunc = new javax.swing.JLabel();
        jAtual = new com.toedter.calendar.JDateChooser();
        jData = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jbRelatório = new javax.swing.JButton();
        jmbSuper = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmCadastro = new javax.swing.JMenu();
        jmiSuper = new javax.swing.JMenuItem();
        jmiCadastrarLivro = new javax.swing.JMenuItem();
        jmiCadastroUser = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmEdx = new javax.swing.JMenu();
        jmiLivros = new javax.swing.JMenuItem();
        jmiFunc = new javax.swing.JMenuItem();
        jReservas = new javax.swing.JMenu();
        jmiExibir = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiRelatorio = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiHistorico = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        jmSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(52, 73, 93));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");

        jbEmprestimo.setBackground(java.awt.Color.white);
        jbEmprestimo.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbEmprestimo.setForeground(new java.awt.Color(52, 73, 93));
        jbEmprestimo.setText("Efetuar Empréstimo");
        jbEmprestimo.setToolTipText("");
        jbEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmprestimoActionPerformed(evt);
            }
        });

        jbLimpar.setBackground(java.awt.Color.white);
        jbLimpar.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbLimpar.setForeground(new java.awt.Color(52, 73, 93));
        jbLimpar.setText("Limpar");
        jbLimpar.setToolTipText("");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbReservas.setBackground(java.awt.Color.white);
        jbReservas.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbReservas.setForeground(new java.awt.Color(52, 73, 93));
        jbReservas.setText("Reservas");
        jbReservas.setToolTipText("");
        jbReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReservasActionPerformed(evt);
            }
        });

        jbLogout.setBackground(java.awt.Color.white);
        jbLogout.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbLogout.setForeground(new java.awt.Color(52, 73, 93));
        jbLogout.setText("Logout");
        jbLogout.setToolTipText("");
        jbLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogoutActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(52, 73, 93));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Laksaman", 0, 12), java.awt.Color.white)); // NOI18N

        jtLivros.setAutoCreateRowSorter(true);
        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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

        jcbPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponível", "Indisponível", "Todos" }));
        jcbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPesquisarActionPerformed(evt);
            }
        });

        jbPesquisar.setBackground(java.awt.Color.white);
        jbPesquisar.setText("IR");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpEmprestimo.setBackground(new java.awt.Color(52, 73, 93));
        jpEmprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Empréstimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Laksaman", 0, 12), java.awt.Color.white)); // NOI18N

        jlSuper.setFont(new java.awt.Font("Laksaman", 0, 14)); // NOI18N
        jlSuper.setForeground(java.awt.Color.white);
        jlSuper.setText("Supervisor:");

        jtfSuper.setEnabled(false);
        jtfSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSuperActionPerformed(evt);
            }
        });

        jlDataE.setFont(new java.awt.Font("Laksaman", 0, 14)); // NOI18N
        jlDataE.setForeground(java.awt.Color.white);
        jlDataE.setText("Data de Empréstimo:");

        jlDataEn.setFont(new java.awt.Font("Laksaman", 0, 14)); // NOI18N
        jlDataEn.setForeground(java.awt.Color.white);
        jlDataEn.setText("Data de Entrega:");

        jlLivro.setFont(new java.awt.Font("Laksaman", 0, 14)); // NOI18N
        jlLivro.setForeground(java.awt.Color.white);
        jlLivro.setText("Livro:");

        jtfLivro.setText(vr.getLivro());
        jtfLivro.setEnabled(false);
        jtfLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLivroActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(52, 73, 93));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Laksaman", 0, 12), java.awt.Color.white)); // NOI18N

        jbPesquisar1.setBackground(java.awt.Color.white);
        jbPesquisar1.setText("IR");
        jbPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisar1ActionPerformed(evt);
            }
        });

        jtFunc.setAutoCreateRowSorter(true);
        jtFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtFunc);

        jcbFunc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Funcionários", "Não Funcionários" }));
        jcbFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbFuncMouseClicked(evt);
            }
        });
        jcbFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jtfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbPesquisar1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPesquisar1)
                    .addComponent(jtfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtfNome.setText(vr.getMat());
        jtfNome.setEnabled(false);
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });

        jlFunc.setFont(new java.awt.Font("Laksaman", 0, 14)); // NOI18N
        jlFunc.setForeground(java.awt.Color.white);
        jlFunc.setText("Funcionário:");

        javax.swing.GroupLayout jpEmprestimoLayout = new javax.swing.GroupLayout(jpEmprestimo);
        jpEmprestimo.setLayout(jpEmprestimoLayout);
        jpEmprestimoLayout.setHorizontalGroup(
            jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDataEn)
                    .addComponent(jlLivro)
                    .addComponent(jlFunc)
                    .addComponent(jlSuper)
                    .addComponent(jlDataE))
                .addGap(21, 21, 21)
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfSuper, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfLivro)
                    .addComponent(jtfNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEmprestimoLayout.setVerticalGroup(
            jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmprestimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSuper))
                .addGap(18, 18, 18)
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlDataE)
                    .addComponent(jAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlDataEn)
                    .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLivro))
                .addGap(18, 18, 18)
                .addGroup(jpEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFunc))
                .addContainerGap(64, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(52, 73, 93));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/images/output_5DIGQi.gif"))); // NOI18N
        jLabel1.setOpaque(true);

        jbRelatório.setBackground(java.awt.Color.white);
        jbRelatório.setFont(new java.awt.Font("Laksaman", 0, 15)); // NOI18N
        jbRelatório.setForeground(new java.awt.Color(52, 73, 93));
        jbRelatório.setText("Relatório");
        jbRelatório.setToolTipText("");
        jbRelatório.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRelatórioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbRelatório, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbRelatório, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmbSuper.setBackground(java.awt.Color.white);
        jmbSuper.setBorder(null);

        jmArquivo.setBackground(java.awt.Color.darkGray);
        jmArquivo.setText("Arquivo");

        jmCadastro.setText("Cadastro");

        jmiSuper.setText("Cadastrar Supervisor");
        jmiSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSuperActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiSuper);

        jmiCadastrarLivro.setText("Cadastrar Livro");
        jmiCadastrarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarLivroActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiCadastrarLivro);

        jmiCadastroUser.setText("Cadastrar Funcionário");
        jmiCadastroUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroUserActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiCadastroUser);

        jmArquivo.add(jmCadastro);
        jmArquivo.add(jSeparator1);

        jmEdx.setText("Editar/Excluir");

        jmiLivros.setText("Livros");
        jmiLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLivrosActionPerformed(evt);
            }
        });
        jmEdx.add(jmiLivros);

        jmiFunc.setText("Funcionários");
        jmiFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFuncActionPerformed(evt);
            }
        });
        jmEdx.add(jmiFunc);

        jmArquivo.add(jmEdx);

        jReservas.setText("Reservas");

        jmiExibir.setText("Exibir Reservas");
        jmiExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExibirActionPerformed(evt);
            }
        });
        jReservas.add(jmiExibir);

        jmArquivo.add(jReservas);
        jmArquivo.add(jSeparator2);

        jmiRelatorio.setText("Relatorio");
        jmiRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatorioActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiRelatorio);
        jmArquivo.add(jSeparator4);

        jmiHistorico.setText("Histórico");
        jmArquivo.add(jmiHistorico);
        jmArquivo.add(jSeparator5);

        jmiSair.setText("Sair");
        jmArquivo.add(jmiSair);

        jmbSuper.add(jmArquivo);

        jmSobre.setBackground(java.awt.Color.darkGray);
        jmSobre.setText("Sobre");
        jmbSuper.add(jmSobre);

        setJMenuBar(jmbSuper);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Login l = new Login();
    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        pesquisarLivros();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jmiCadastrarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarLivroActionPerformed
        new CadastroLivro().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jmiCadastrarLivroActionPerformed

    private void jbLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogoutActionPerformed
        this.dispose();
        new Consulta().setVisible(true);
    }//GEN-LAST:event_jbLogoutActionPerformed

    private void jmiLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLivrosActionPerformed
        new EdxLivros().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jmiLivrosActionPerformed

    private void jmiCadastroUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroUserActionPerformed
        new CadastroFuncionario().setVisible(true);
    }//GEN-LAST:event_jmiCadastroUserActionPerformed

    private void jcbFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuncActionPerformed
        listar();
    }//GEN-LAST:event_jcbFuncActionPerformed

    private void jbPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisar1ActionPerformed
        pesquisar();
    }//GEN-LAST:event_jbPesquisar1ActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncMouseClicked
        String nome;
        int linha = jtFunc.getSelectedRow();
        nome = (String) jtFunc.getValueAt(linha, 1);
        jtfNome.setText(nome);
    }//GEN-LAST:event_jtFuncMouseClicked

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        String titulo;
        int linha = jtLivros.getSelectedRow();
        String d = (String) jtLivros.getValueAt(linha, 9);
        if ("Disponível".equals(d)) {
            titulo = (String) jtLivros.getValueAt(linha, 1);
            jtfLivro.setText(titulo);
        } else {
            JOptionPane.showMessageDialog(rootPane, "O Livro está emprestado, portando não poderá ser utilizado");
        }
    }//GEN-LAST:event_jtLivrosMouseClicked

    private void jcbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPesquisarActionPerformed
        listarLivros();        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPesquisarActionPerformed

    private void jcbFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFuncMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFuncMouseClicked

    private void jmiFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFuncActionPerformed
        new EdxFunc().setVisible(true);
    }//GEN-LAST:event_jmiFuncActionPerformed


    private void jtfSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSuperActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtfSuperActionPerformed

    private void jbEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmprestimoActionPerformed
        try {
            int mat = (int) jtFunc.getValueAt(jtFunc.getSelectedRow(), 0);
            int ids = (int) jtLivros.getValueAt(jtLivros.getSelectedRow(), 0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String d = sdf.format(jData.getDate());
            String a = sdf.format(jAtual.getDate());

            Connection conexao = Conexao.getConexao();
            Emprestimo emprestimo = new Emprestimo(ids, mat, 0, d,a,true);
            Livro livro = new Livro(ids, "");
            
            emprestimo.inserir(conexao, "v");
            livro.hide(conexao);
            

            JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(FrameSupervisor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Joaoooooooo");
        }
    }//GEN-LAST:event_jbEmprestimoActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        jtfFunc.setText(""); 
        jtfLivro.setText("");
        jtfNome.setText("");
        jtfPesquisar.setText("");
        jData.setDate(null);
        jAtual.setDate(null);
        
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReservasActionPerformed
        new VisualizarReserva().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jbReservasActionPerformed

    private void jmiRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatorioActionPerformed
        new Relatorio().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jmiRelatorioActionPerformed

    private void jmiSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSuperActionPerformed
        new CadastrarSupervisor().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jmiSuperActionPerformed

    private void jbRelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatórioActionPerformed
       new Relatorio().setVisible(true);
    }//GEN-LAST:event_jbRelatórioActionPerformed

    private void jmiExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExibirActionPerformed
        new VisualizarReserva().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jmiExibirActionPerformed

    private void jtfLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfLivroActionPerformed

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
            java.util.logging.Logger.getLogger(FrameSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSupervisor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jAtual;
    private com.toedter.calendar.JDateChooser jData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu jReservas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JButton jbEmprestimo;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbPesquisar1;
    private javax.swing.JButton jbRelatório;
    private javax.swing.JButton jbReservas;
    private javax.swing.JComboBox jcbFunc;
    private javax.swing.JComboBox jcbPesquisar;
    private javax.swing.JLabel jlDataE;
    private javax.swing.JLabel jlDataEn;
    private javax.swing.JLabel jlFunc;
    private javax.swing.JLabel jlLivro;
    private javax.swing.JLabel jlSuper;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenu jmEdx;
    private javax.swing.JMenu jmSobre;
    private javax.swing.JMenuBar jmbSuper;
    private javax.swing.JMenuItem jmiCadastrarLivro;
    private javax.swing.JMenuItem jmiCadastroUser;
    private javax.swing.JMenuItem jmiExibir;
    private javax.swing.JMenuItem jmiFunc;
    private javax.swing.JMenuItem jmiHistorico;
    private javax.swing.JMenuItem jmiLivros;
    private javax.swing.JMenuItem jmiRelatorio;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSuper;
    private javax.swing.JPanel jpEmprestimo;
    private javax.swing.JTable jtFunc;
    private javax.swing.JTable jtLivros;
    private javax.swing.JTextField jtfFunc;
    private javax.swing.JTextField jtfLivro;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisar;
    private javax.swing.JTextField jtfSuper;
    // End of variables declaration//GEN-END:variables
}
