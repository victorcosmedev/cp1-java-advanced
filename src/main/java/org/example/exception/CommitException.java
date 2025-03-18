package org.example.exception;

public class CommitException extends Exception{

    public CommitException(){
        super("Erro ao commitar.");
    }

    public CommitException(String message){
        super(message);
    }
}
