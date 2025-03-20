package org.example.view;

import org.example.dao.FuncionarioDAOImpl;
import org.example.entity.Funcionario;
import org.example.entity.FuncionarioJunior;
import org.example.entity.FuncionarioPleno;
import org.example.entity.FuncionarioSenior;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ViewDAOCadastro {
    public static void main(String[] args) {

        Funcionario funcionario = new FuncionarioJunior("Lucas", 45, 10);
        Funcionario funcionario2 = new FuncionarioPleno("Fernanda", 40, 15);
        Funcionario funcionario3 = new FuncionarioSenior("Ismael", 55, 20);

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDAOImpl dao = new FuncionarioDAOImpl(em);

        try {
            dao.cadastrar(funcionario);
            dao.cadastrar(funcionario2);
            dao.cadastrar(funcionario3);
            dao.commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }




    }
}
