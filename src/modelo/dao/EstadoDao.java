/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.dao.uteis.ConexaoDB;

/**
 *
 * @author wender
 */
public class EstadoDao {

    public Estado novo() {
        return new Estado();
    }

    public void salvar(Estado estado) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (estado.getId() != null) {
            em.merge(estado);
        } else {
            em.persist(estado);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Estado estado) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (estado.getId() != null) {
            em.remove(em.find(estado.getClass(), estado.getId()));
        }
        em.getTransaction().commit();
        em.close();
    }

    public Estado pesquisar(Integer id) {
        EntityManager em = ConexaoDB.getEntityManager();
        Estado estado = (Estado) em.find(Estado.class, id);
        return estado;
    }

    public List<Estado> pesquisar(String nome) {
        EntityManager em = ConexaoDB.getEntityManager();
        Query consulta = em.createNamedQuery("Estado.findByNome");
        consulta.setParameter("nome", nome + "%");
        return consulta.getResultList();
    }

}
