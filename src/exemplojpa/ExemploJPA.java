/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojpa;

import entidades.Fornecedor;
import modelo.dao.FornecedorDAO;

/**
 *
 * @author wender
 */
public class ExemploJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fornecedor fornecedor;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
//        fornecedor = fornDAO.novo();
//        fornecedor.setNome("Fornecedor 1");
//        fornecedorDAO.salvar(forn);
        fornecedor = fornecedorDAO.pesquisar(1);
        System.out.println("Fornecedor: " + fornecedor.getId() + " - " + fornecedor.getNome());
        fornecedor.setNome("Disdribuidora São Luis");
        fornecedorDAO.salvar(fornecedor);
        
        
    }
    
}
