
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
import java.util.ArrayList;

/**
 *
 * @author Aluno Manha
 */
public class Funcionario implements Modelo {

    public Funcionario(int matricula, String c) {
        this.matricula = matricula;

    }

    private static final String tabela = "funcionario";
    private int matricula;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private int ativo;

    public int getMatricula() {
        return matricula;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public static ArrayList<Funcionario> alistar(Connection conexao) {
        ArrayList<Funcionario> usuarios = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE ativo =1 ";
        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Funcionario usuario = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                usuarios.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return usuarios;
    }

    public static ArrayList<Funcionario> pesquisar(Connection conexao, String n) {
        ArrayList<Funcionario> usuarios = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE ativo =1 and nome like '%" + n + "%' ";
        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Funcionario usuario = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                usuarios.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return usuarios;
    }

    public static ArrayList<Funcionario> listar(Connection conexao, String v) {
        ArrayList<Funcionario> usuarios = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE ativo =1 and cargo='" + v + "' ";
        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Funcionario usuario = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                usuarios.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return usuarios;
    }

    public Funcionario(int matricula, String nome, String email, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.telefone = telefone;

    }

    //Funcionário
    @Override
    public void inserir(Connection conexao, String c) {
        String sql = "INSERT INTO " + tabela + "( matricula, nome, email, telefone, cargo, ativo) values('" + matricula + "','" + nome + "','" + email + "','" + telefone + "','" + c + "','1')";
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
        String sql = "DELETE FROM " + tabela + " WHERE   matricula   = '" + matricula + "'";
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a exclusao");

        }

    }

    public void hide(Connection conexao) {
        String sql = "UPDATE " + tabela + " SET  ativo=' 01      ' WHERE   matricula  ='" + matricula + "'";

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
        String sql = "UPDATE " + tabela + " SET  nome='" + nome + "', email='" + email + "',telefone='" + telefone + "' WHERE   matricula  ='" + matricula + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }

}
