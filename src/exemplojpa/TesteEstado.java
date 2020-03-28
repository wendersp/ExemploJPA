/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojpa;

import entidades.Estado;
import java.util.Date;
import java.util.List;
import modelo.dao.EstadoDao;

/**
 *
 * @author wender
 */
public class TesteEstado {

    private EstadoDao estadoDao = new EstadoDao();
    private Estado estado;

    private void incluirNovoEstado() {
        System.out.println("teste inclusão de um novo estado");
        estado = new Estado();
        estado.setNome("xxxx");
        estado.setSigla("xx");
        estado.setDataCadastro(new Date());
        estadoDao.salvar(estado);
        System.out.println("Estado Incluido com Sucesso....");
    }
    
    private void alterarEstado() {
        System.out.println("teste alteracao de um novo estado.");
        estado = estadoDao.pesquisar(1l);
        imprimir();
        estado.setNome("Nome estado alterado");
        estado.setSigla("AT");
        estado.setDataAlteracao(new Date());
        estadoDao.salvar(estado);
        System.out.println("Estado alterado com sucesso.");
        estado = estadoDao.pesquisar(1l);
        imprimir();         
    }
    
    private void pesquisar() {
        System.out.println("Teste pesquisa por nome");        
        List<Estado> lstEstado = estadoDao.pesquisar("");
        for (Estado e: lstEstado) {
            estado = e;
            imprimir();
        }
    }
    
    private void apagar() {
        System.out.println("teste apagar de um novo estado.");
        estado = estadoDao.pesquisar(1l);
        estadoDao.excluir(estado);
        System.out.println("Estado apagado com sucesso.");
    }
    
    private void imprimir() {
        System.out.println("-----------------------------------------");
        System.out.println("Id: " + estado.getId());
        System.out.println("Nome: " + estado.getNome());
        System.out.println("Sigla: " + estado.getSigla());
        System.out.println("-----------------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          TesteEstado teste = new TesteEstado();
          teste.incluirNovoEstado();
          teste.alterarEstado();
          teste.pesquisar();
          teste.apagar();
          
    }

}
