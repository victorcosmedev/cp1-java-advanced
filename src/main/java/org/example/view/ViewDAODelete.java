package org.example.view;

import org.example.dao.FuncionarioDAOImpl;
import org.example.exception.CommitException;
import org.example.exception.IDException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ViewDAODelete {
    public static void main(String[] args) {

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDAOImpl dao = new FuncionarioDAOImpl(em);

        try{
            dao.remover(21L);
            dao.commit();
            System.out.println("Funcionario Deletado!");
        } catch (IDException | CommitException e) {
            throw new RuntimeException(e);
        }
    }
}
