
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aluno Manha
 */
public class Emprestimo implements Modelo {

    public Emprestimo(int id_livro, int matricula_funcionario, int id, String dataD, String dataE, boolean ativo) {
        this.matricula_funcionario = matricula_funcionario;
        this.id_livro = id_livro;
        this.id = id;
        this.dataD = dataD;
        this.dataE = dataE;
        this.ativo = ativo;
    }

    public Emprestimo() {
    }

    private static final String tabela = "emprestimo";
    private int id_livro;
    private int matricula_funcionario;
    private int id;
    private String dataE;
    private String dataD;
    private boolean ativo;
    private String nome;
    private String titulo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome_func) {
        this.nome = nome_func;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo_livro) {
        this.titulo = titulo_livro;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public int getMatricula_funcionario() {
        return matricula_funcionario;
    }

    public void setMatricula_funcionario(int matricula_funcionario) {
        this.matricula_funcionario = matricula_funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataE() {
        return dataE;
    }

    public void setDataE(String dataE) {
        this.dataE = dataE;
    }

    public String getDataD() {
        return dataD;
    }

    public void setDataD(String dataD) {
        this.dataD = dataD;
    }

    public Emprestimo(int id, String oi) {
        this.id = id;
    }
    
    
    public static ArrayList<Emprestimo> listar(Connection conexao, String v) {
        ArrayList<Emprestimo> abacates = new ArrayList();

        String sql = "SELECT emprestimo.id, livros.titulo, funcionario.nome, dataE, dataD, ativa from emprestimo join livros, funcionario where ativa = "+v+" and funcionario.matricula=emprestimo.matricula_funcionario and livros.id=emprestimo.id_livro;";

        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Emprestimo usuario = new Emprestimo(rs.getInt("id"), rs.getString("nome"), rs.getString("titulo"), rs.getString("dataE"), rs.getString("dataD"), rs.getBoolean("ativa"));
                System.out.println(rs.getString("nome") + rs.getString("titulo") + rs.getString("dataE") + rs.getString("dataD") + "");
                abacates.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return abacates;
    }
    
    public static ArrayList<Emprestimo> alistar(Connection conexao) {
        ArrayList<Emprestimo> abacates = new ArrayList();
            
        String sql = "SELECT emprestimo.id, livros.titulo, funcionario.nome, dataE, dataD, ativa from emprestimo join livros, funcionario where funcionario.matricula=emprestimo.matricula_funcionario and livros.id=emprestimo.id_livro;";
        
        try {

            try (Statement st = conexao.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                System.out.println(sql);
                while (rs.next()) {
                    Emprestimo usuario = new Emprestimo(rs.getInt("id"), rs.getString("nome"), rs.getString("titulo"), rs.getString("dataE"), rs.getString("dataD"), rs.getBoolean("ativa"));
                    abacates.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return abacates;
    }

    public Emprestimo(int id, String nome, String titulo, String dataE, String dataD, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.dataE = dataE;
        this.dataD = dataD;
        this.ativo = ativo;
    }

    //Funcionário
    @Override
    public void inserir(Connection conexao, String c) {
        String sql = "INSERT INTO " + tabela + "(id_livro, matricula_funcionario, id, dataD, dataE, ativa) values('" + id_livro + "','" + matricula_funcionario + "', 0 ,'" + dataD + "','" + dataE + "', '1')";
        System.err.println(sql + "");
        //INSERT INTO `bibliotech`.`funcionario` (`matricula`, `nome`, `email`, `telefone`, `cargo`, `ativo`) VALUES ('123', 'sasaa', 'asassa', '25255', 'f', '1');
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a inserção");
        }
    }

    @Override
    public void excluir(Connection conexao) {
        String sql = "DELETE FROM " + tabela + " WHERE   id   = '" + id + "'";
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a exclusao");

        }
    }
        
            

    public void hide(Connection conexao) {
        String sql = "UPDATE " + tabela + " SET ativa=' 0 ' WHERE   id  ='" + id + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }

    @Override
    public void atualizar(Connection conexao) {
        String sql = "UPDATE " + tabela + " SET  dataE='" + dataE + "' WHERE id_livro  ='" + id_livro + "' and matricula_funcionario  ='" + matricula_funcionario + "' and id  ='" + id + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }

    public static String formataData(Date data_digitada) {

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
        String data_E = formatador.format(data_digitada);
        //Date data = formatador.parse(data_lancamento);
        return data_E;
    }

}
