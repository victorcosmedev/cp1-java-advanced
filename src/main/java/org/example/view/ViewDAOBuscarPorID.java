package org.example.view;

import org.example.dao.FuncionarioDAOImpl;
import org.example.entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ViewDAOBuscarPorID {
    public static void main(String[] args) {

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDAOImpl dao = new FuncionarioDAOImpl(em);


        try {
            Funcionario funcionario = dao.bucarPorID(1L);
            funcionario.imprimirInformacao();

            Funcionario funcionario2 = dao.bucarPorID(2L);
            funcionario2.imprimirInformacao();

            Funcionario funcionario3 = dao.bucarPorID(3L);
            funcionario3.imprimirInformacao();

            Funcionario funcionario4 = dao.bucarPorID(4L);
            funcionario4.imprimirInformacao();


        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
