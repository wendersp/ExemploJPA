/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.dao.uteis.ConexaoDB;

/**
 *
 * @author wender
 */
public class CidadeDao {

    public Cidade novo() {
        return new Cidade();
    }

    public void salvar(Cidade cidade) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (cidade.getId() != null) {
            cidade = em.merge(cidade);
        }
        em.persist(cidade);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Cidade cidade) {
        EntityManager em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        if (cidade.getId() != null) {
            em.remove(em.find(cidade.getClass(), cidade.getId()));
        }
        em.getTransaction().commit();
        em.close();
    }

    public Cidade pesquisar(Long id) {
        EntityManager em = ConexaoDB.getEntityManager();
        Cidade cidade = (Cidade) em.find(Cidade.class, id);
        return cidade;
    }

    public List<Cidade> pesquisar(String nome) {
        EntityManager em = ConexaoDB.getEntityManager();
        Query consulta = em.createNamedQuery("Cidade.findByNome");
        consulta.setParameter("nome", nome + "%");
        return consulta.getResultList();
    }

}
