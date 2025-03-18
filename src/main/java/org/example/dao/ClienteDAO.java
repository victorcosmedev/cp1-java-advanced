package org.example.dao;

import org.example.entity.Funcionario;
import org.example.exception.CommitException;
import org.example.exception.IDException;

public interface ClienteDAO {
    void cadastrar(Funcionario funcionario);
    void atualizar (Funcionario funcionario) throws IDException;
    void remover (long id) throws IDException;
    Funcionario bucarPorID(long id)  throws IDException;
    Funcionario buscarTodos();
    void commit() throws CommitException;
}
