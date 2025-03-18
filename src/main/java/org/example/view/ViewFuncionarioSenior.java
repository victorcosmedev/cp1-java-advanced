package org.example.view;

import org.example.entity.Funcionario;
import org.example.entity.FuncionarioSenior;

public class ViewFuncionarioSenior {
    public static void main(String[] args) {
        Funcionario funcionario = new FuncionarioSenior("Adalberto", 40, 10);
        funcionario.imprimirInformacao();
    }
}
