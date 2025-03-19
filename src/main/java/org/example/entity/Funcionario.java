package org.example.entity;

import org.example.anotation.Tabela;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@Tabela(nome = "TB_FUNCIONARIO")
@SequenceGenerator(name="seq_funcionario", sequenceName = "SQ_FUNCIONARIO", allocationSize = 1)
public abstract class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="quant_horas_trabalhadas", nullable = false, precision = 5, scale = 3)
    private double quantHorasTrabalhadas;

    @Column(name="valor_hora_trabalhada", nullable = false, precision = 8, scale = 2)
    private double valorHoraTrabalhada;

    public Funcionario(String nome, double quantHorasTrabalhadas, double valorHoraTrabalhada) {
        this.nome = nome;
        this.quantHorasTrabalhadas = quantHorasTrabalhadas;
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    public Funcionario(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantHorasTrabalhadas() {
        return quantHorasTrabalhadas;
    }

    public void setQuantHorasTrabalhadas(double quantHorasTrabalhadas) {
        this.quantHorasTrabalhadas = quantHorasTrabalhadas;
    }

    public double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }

    public void setValorHoraTrabalhada(double valorHoraTrabalhada) {
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    abstract double calcularSalario();

    public abstract void imprimirInformacao();
}
