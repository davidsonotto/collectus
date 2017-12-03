
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
public class Livro implements Modelo {

    private static final String tabela = "livros";
    private int id;
    private String autor;
    private String titulo;
    private boolean livre;
    private String edicao;
    private String local;
    private String editora;
    private String ano;
    private String tema;
    private int pagtotais;
    public boolean reservado;

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getPagtotais() {
        return pagtotais;
    }

    public void setPagtotais(int pagtotais) {
        this.pagtotais = pagtotais;
    }

    public Livro() {
    }

    public Livro(int id, String restriçao) {
        this.id = id;
    }

    public static ArrayList<Livro> listar(Connection conexao, String l) {
        ArrayList<Livro> usuarios = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE livre='" + l + "' ";
        System.err.println(sql);
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Livro usuario = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("edicao"), rs.getString("local"), rs.getString("editora"), rs.getString("ano"), rs.getInt("pagtotais"), rs.getString("tema"), rs.getString("autor"), rs.getBoolean("livre"), rs.getBoolean("reservado"));
                usuarios.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return usuarios;
    }

    public static ArrayList<Livro> listarTudo(Connection conexao, String restricao) {
        ArrayList<Livro> usuarios = new ArrayList();

        String sql = "SELECT * FROM " + tabela + "";
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Livro usuario = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("edicao"), rs.getString("local"), rs.getString("editora"), rs.getString("ano"), rs.getInt("pagtotais"), rs.getString("tema"), rs.getString("autor"), rs.getBoolean("livre"), rs.getBoolean("reservado"));
                usuarios.add(usuario);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return usuarios;
    }

    public static ArrayList<Livro> pesquisar(Connection conexao, String n) {
        ArrayList<Livro> livros = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE titulo like '%" + n + "%' ";
        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("edicao"), rs.getString("local"), rs.getString("editora"), rs.getString("ano"), rs.getInt("pagtotais"), rs.getString("tema"), rs.getString("autor"), rs.getBoolean("livre"), rs.getBoolean("reservado"));
                livros.add(livro);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return livros;
    }
    
    public static ArrayList<Livro> listaReservados(Connection conexao, String n) {
        ArrayList<Livro> livros = new ArrayList();

        String sql = "SELECT * FROM " + tabela + " WHERE  reservado = " + n + " ";
        System.out.println(sql);
        try {

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("edicao"), rs.getString("local"), rs.getString("editora"), rs.getString("ano"), rs.getInt("pagtotais"), rs.getString("tema"), rs.getString("autor"), rs.getBoolean("livre"), rs.getBoolean("reservado"));
                livros.add(livro);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.print("Não Foi possivel realizar a consulta");
        }
        return livros;
    }

    public Livro(int id, String titulo, String edicao, String local, String editora, String ano, int pagtotais, String tema, String autor, boolean livre) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.edicao = edicao;
        this.livre = livre;
        this.local = local;
        this.editora = editora;
        this.ano = ano;
        this.pagtotais = pagtotais;
        this.tema = tema;
    }

    public Livro(int id, String titulo, String edicao, String local, String editora, String ano, int pagtotais, String tema, String autor, boolean livre, boolean reservado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.livre = livre;
        this.edicao = edicao;
        this.local = local;
        this.editora = editora;
        this.ano = ano;
        this.tema = tema;
        this.pagtotais = pagtotais;
        this.reservado = reservado;
    }
    
    

    @Override
    public void inserir(Connection conexao, String s) {
        String sql = "INSERT INTO " + tabela + "(id, titulo, edicao, local, editora, ano, pagtotais, livre, tema, autor, reservado) values(" + id + ",'" + titulo + "','" + edicao + "','" + local + "','" + editora + "','" + ano + "'," + pagtotais + ",' 1 ','" + tema + "','" + autor + "','0')";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a inserção" + e);

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
        String sql = "UPDATE " + tabela + " SET  livre=' 0 ' WHERE   id  ='" + id + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }
    
    public void deshide(Connection conexao) {
        String sql = "UPDATE " + tabela + " SET  livre=' 1 ' WHERE   id  ='" + id + "'";

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
        String sql = "UPDATE " + tabela + " SET  titulo='" + titulo + "', edicao='" + edicao + "',local='" + local + "',editora='" + editora + "',ano='" + ano + "',pagtotais='" + pagtotais + "',tema = '" + tema + "', autor='" + autor + "' WHERE   id  ='" + id + "'";

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a atualizaçao");

        }

    }

}
