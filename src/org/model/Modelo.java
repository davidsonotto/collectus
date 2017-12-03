/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.sql.Connection;

/**
 *
 * @author Aluno Manha
 */
public interface Modelo {
    
    void inserir(Connection conexao, String s);
    void excluir(Connection conexao);
    void atualizar(Connection conexao);
    
    
    
}
