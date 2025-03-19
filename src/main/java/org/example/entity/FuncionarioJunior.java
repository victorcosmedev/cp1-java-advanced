package org.example.entity;

import org.example.anotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FUNCIONARIO_JUNIOR")
@Tabela(nome = "TB_FUNCIONARIO_JUNIOR")
@SequenceGenerator(name="seq_funcionario_junior", sequenceName = "SQ_TB_FUNCIONARIO_JUNIOR", allocationSize = 1)
public class FuncionarioJunior extends Funcionario{

    public FuncionarioJunior(String nome, double quantHorasTrabalhadas, double valorHoraTrabalhada) {
        super(nome, quantHorasTrabalhadas, valorHoraTrabalhada);
    }

    public FuncionarioJunior() {
    }

    @Override
    double calcularSalario() {
        double quantHorasTrabalhadas = this.getQuantHorasTrabalhadas();
        int multiplicadorBonus = 1;
        if(quantHorasTrabalhadas >= 20){
            multiplicadorBonus = (int) (quantHorasTrabalhadas / 15);
            double percentualBonus = multiplicadorBonus * 0.025;
            double salarioSemBonificacao = this.getQuantHorasTrabalhadas() * this.getValorHoraTrabalhada();

            return salarioSemBonificacao + (salarioSemBonificacao * percentualBonus);
        }
        return this.getQuantHorasTrabalhadas() * this.getValorHoraTrabalhada();
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Nome do funcionário júnior: " + this.getNome());
        System.out.println("Valor/hora: R$" + this.getValorHoraTrabalhada());
        System.out.println("Quantidade de horas trabalhadas: " + this.getQuantHorasTrabalhadas());
        System.out.println("Salário: R$" + this.calcularSalario());
    }
}
