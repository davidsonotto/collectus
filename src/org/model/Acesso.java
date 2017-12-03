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
public class Acesso implements Modelo{
    private int login;
    private static final String tabela = "acesso";
    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String senha;
    
    
   public static ArrayList<Acesso> logar(Connection conexao,int login) {
        ArrayList<Acesso> logars = new ArrayList();
        String sql = "SELECT senha FROM " + tabela + " WHERE login='" +login+ "' ";
        
       
        try {
            Statement st = conexao.createStatement();
            st.executeQuery(sql);
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Acesso acesso = new Acesso(rs.getString("senha"));
                logars.add(acesso);
            }
            rs.close();
            
            st.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer a o login");
        }
    return logars;
}
   
   public Acesso(String senha){
this.senha=senha;   
   }
   public Acesso(int login, String senha){
       this.login = login;
       this.senha = senha;
   }

    @Override
    public void inserir(Connection conexao, String s) {
        String sql = "INSERT INTO " + tabela + "(login, senha) values(" + login + ",'" + senha + "')";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Connection conexao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
