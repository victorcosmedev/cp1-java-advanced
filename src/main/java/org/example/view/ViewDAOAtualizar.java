package org.example.view;

import org.example.dao.FuncionarioDAOImpl;
import org.example.entity.Funcionario;
import org.example.entity.FuncionarioJunior;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ViewDAOAtualizar {
    public static void main(String[] args) {

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDAOImpl dao = new FuncionarioDAOImpl(em);

        try {
            Funcionario funcionario = new FuncionarioJunior("João", 50, 13);
            dao.atualizar(1L, funcionario);
            dao.commit();
            System.out.println("Cliente atualizado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
