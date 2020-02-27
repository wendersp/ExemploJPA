/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.dao.uteis.ConexaoDB;

/**
 *
 * @author wender
 */
public class FornecedorDAO {

    public Fornecedor novo() {
        return new Fornecedor();
    }

    public void salvar(Fornecedor fornecedor) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (fornecedor.getId() != null) {
            fornecedor = em.merge(fornecedor);
        }
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Fornecedor fornecedor) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (fornecedor.getId() != null) {
            em.remove(em.find(fornecedor.getClass(), fornecedor.getId()));
        }        
        em.getTransaction().commit();
        em.close();
    }

    public Fornecedor pesquisar(Integer id) {
         EntityManager em = ConexaoDB.getEntityManager();
         Fornecedor fornecedor = (Fornecedor)em.find(Fornecedor.class, id);
         return fornecedor;
    }
    
    public List<Fornecedor> pesquisar(String nome) {
        EntityManager em = ConexaoDB.getEntityManager();
        Query consulta = em.createNamedQuery("Fornecedor.findByNome");
        consulta.setParameter("nome", nome + "%");
        return consulta.getResultList();
    }

}
