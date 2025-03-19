package org.example.entity;

import org.example.anotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FUNCIONARIO_PLENO")
@Tabela(nome = "TB_FUNCIONARIO_PLENO")
@SequenceGenerator(name="seq_funcionario_pleno", sequenceName = "SQ_TB_FUNCIONARIO_PLENO", allocationSize = 1)
public class FuncionarioPleno extends Funcionario{

    public FuncionarioPleno(String nome, double quantHorasTrabalhadas, double valorHoraTrabalhada) {
        super(nome, quantHorasTrabalhadas, valorHoraTrabalhada);
    }

    public FuncionarioPleno() {
    }

    @Override
    double calcularSalario() {
        double quantHorasTrabalhadas = this.getQuantHorasTrabalhadas();
        int multiplicadorBonus = 1;
        if(quantHorasTrabalhadas >= 17.5){
            multiplicadorBonus = (int) (quantHorasTrabalhadas / 15);
            double percentualBonus = multiplicadorBonus * 0.03;
            double salarioSemBonificacao = this.getQuantHorasTrabalhadas() * this.getValorHoraTrabalhada();

            return salarioSemBonificacao + (salarioSemBonificacao * percentualBonus);
        }
        return this.getQuantHorasTrabalhadas() * this.getValorHoraTrabalhada();
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Nome do funcionário sênior: " + this.getNome());
        System.out.println("Valor/hora: R$" + this.getValorHoraTrabalhada());
        System.out.println("Quantidade de horas trabalhadas: " + this.getQuantHorasTrabalhadas());
        System.out.println("Salário: R$" + this.calcularSalario());
    }
}
