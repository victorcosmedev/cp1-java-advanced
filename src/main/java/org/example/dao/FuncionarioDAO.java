package org.example.dao;

import org.example.entity.Funcionario;
import org.example.exception.CommitException;
import org.example.exception.IDException;

import java.util.List;

public interface FuncionarioDAO {
    void cadastrar(Funcionario funcionario);
    void atualizar (Long id, Funcionario funcionario) throws IDException;
    void remover (long id) throws IDException;
    Funcionario bucarPorID(long id)  throws IDException;
    List<Funcionario> buscarTodosFuncionarios();
    void commit() throws CommitException;
}
