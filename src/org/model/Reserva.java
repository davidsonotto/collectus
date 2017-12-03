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
 * @author otto
 */
public class Reserva implements Modelo {

    private static final String tabela = "reservas";
    private int id;
    private int id_livro;
    private int mat_func;
    private String data;
    private String nome;
    private String titulo;
    private boolean efetuada;

    public boolean isEfetuada() {
        return efetuada;
    }

    public void setEfetuada(boolean efetuada) {
        this.efetuada = efetuada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public int getMat_func() {
        return mat_func;
    }

    public void setMat_func(int mat_func) {
        this.mat_func = mat_func;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Reserva(int id, int id_livro, int mat_func, String data, Boolean efeutada) {
        this.id = id;
        this.id_livro = id_livro;
        this.mat_func = mat_func;
        this.data = data;
        this.efetuada = efeutada;
    }

    public Reserva() {
    }

    public static ArrayList<Reserva> listar(Connection conexao, String v) {
        ArrayList<Reserva> abacates = new ArrayList();

        String sql = "SELECT reservas.id, livros.titulo, funcionario.nome, reservas.data, reservas.efetuada FROM reservas JOIN livros, funcionario WHERE funcionario.matricula=reservas.mat_func and livros.id=reservas.id_livro and efetuada =" +v+ " order by id";

        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("id"), rs.getString("titulo"), rs.getString("nome"), rs.getString("data"), rs.getBoolean("efetuada"));
                abacates.add(reserva);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return abacates;
    }
    
    public static ArrayList<Reserva> listarTudao(Connection conexao, String v) {
        ArrayList<Reserva> abacates = new ArrayList();

        String sql = "SELECT reservas.id, livros.titulo, funcionario.nome, reservas.data, reservas.efetuada FROM reservas JOIN livros, funcionario WHERE funcionario.matricula=reservas.mat_func and livros.id=reservas.id_livro order by id";

        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("id"), rs.getString("titulo"), rs.getString("nome"), rs.getString("data"), rs.getBoolean("efetuada"));
                abacates.add(reserva);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return abacates;
    }
    
    public Reserva(int id, String titulo, String nome, String data, Boolean efetuada) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.data = data;
        this.efetuada = efetuada;
    }

    //Funcionário
    @Override
    public void inserir(Connection conexao, String c) {
        String sql = "INSERT INTO " + tabela + "(id, id_livro, mat_func, data, efetuada) values('0','" + id_livro + "','" + mat_func + "','" + data + "','0');";
        System.err.println(sql + "");
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

    @Override
    public void atualizar(Connection conexao) {
        String sql = "UPDATE " + tabela + " SET  data='" + data + "' WHERE id_livro  ='" + id_livro + "' and matricula_funcionario  ='" + mat_func + "' and id  ='" + id + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }

}
