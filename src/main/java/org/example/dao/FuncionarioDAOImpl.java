package org.example.dao;

import org.example.anotation.Tabela;
import org.example.entity.Funcionario;
import org.example.exception.CommitException;
import org.example.exception.IDException;
import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioDAOImpl implements FuncionarioDAO {


    private EntityManager em;

    public FuncionarioDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
        Tabela anotacao = funcionario.getClass().getAnnotation(Tabela.class);
        System.out.println("INSERTO INTO " + anotacao.nome()+ " VALUES "+ "("+funcionario.getNome()+","+funcionario.getQuantHorasTrabalhadas()+","+funcionario.getValorHoraTrabalhada()+")");

    }

    @Override
    public void atualizar(Long id, Funcionario funcionario) throws IDException{
        Funcionario funcionarioExistente = bucarPorID(id);
        if (funcionarioExistente == null) {
            throw new IDException("Funcionário não encontrado");
        }
        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setQuantHorasTrabalhadas(funcionario.getQuantHorasTrabalhadas());
        funcionarioExistente.setValorHoraTrabalhada(funcionario.getValorHoraTrabalhada());
        em.merge(funcionarioExistente);
        Tabela anotacao = funcionario.getClass().getAnnotation(Tabela.class);
        System.out.println("UPDATE " + anotacao.nome()+" SET NOME =  "+funcionario.getNome()+", quantHorasTrabalhadas "+funcionario.getQuantHorasTrabalhadas()+
                ", valorHoraTrabalhada = "+ funcionario.getValorHoraTrabalhada()+ "WHERE id = "+ id);
    }

    @Override
    public void remover(long id) throws IDException {
        Funcionario funcionario = bucarPorID(id);
        Tabela anotacao = funcionario.getClass().getAnnotation(Tabela.class);
        System.out.println("DELETE FROM " + anotacao.nome()+" WHERE ID = = " +id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario bucarPorID(long id) throws IDException {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null){
            throw new IDException("Funcionario não encontrado");
        }
        Tabela anotacao = funcionario.getClass().getAnnotation(Tabela.class);
        System.out.println("SELECT * FROM" + anotacao.nome()+" id = " +id);
        return funcionario;
    }

    @Override
    public List<Funcionario> buscarTodosFuncionarios() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class)
                .getResultList();
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
