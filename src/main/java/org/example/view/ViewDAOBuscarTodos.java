package org.example.view;

import org.example.dao.FuncionarioDAOImpl;
import org.example.entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ViewDAOBuscarTodos {
    public static void main(String[] args) {

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDAOImpl dao = new FuncionarioDAOImpl(em);


        try{
            List<Funcionario> lista = dao.buscarTodosFuncionarios();
            for (Funcionario l : lista ){
                l.imprimirInformacao();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
