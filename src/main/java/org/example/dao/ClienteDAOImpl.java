package org.example.dao;

import org.example.entity.Funcionario;
import org.example.exception.CommitException;
import org.example.exception.IDException;

import javax.persistence.EntityManager;

public class ClienteDAOImpl implements ClienteDAO {


    private EntityManager em;

    public ClienteDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) throws IDException{
        bucarPorID(funcionario.getId());
        em.merge(funcionario);
    }

    @Override
    public void remover(long id) throws IDException {
        Funcionario funcionario = bucarPorID(id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario bucarPorID(long id) throws IDException {
        Funcionario funcionario =em.find(Funcionario.class, id);
        if (funcionario == null){
            throw new IDException("Cliente não encontrado");
        }
        return funcionario;
    }

    @Override
    public Funcionario buscarTodos() {
        return null;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
