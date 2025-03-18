package org.example.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TB_FUNCIONARIO")
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="quant_horas_trabalhadas", nullable = false, precision = 5, scale = 3)
    private double quantHorasTrabalhadas;

    @Column(name="valor_hora_trabalhada", nullable = false, precision = 8, scale = 2)
    private double valorHoraTrabalhada;

    public Funcionario(long id, String nome, double quantHorasTrabalhadas, double valorHoraTrabalhada) {
        this.id = id;
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

    public double calcularSalario(){
        return quantHorasTrabalhadas *  valorHoraTrabalhada;
    }

    public void imprimirInformacao(){
        System.out.println("Nome do funcionário: " + this.getNome());
        System.out.println("Valor da hora trabalhada: " + this.getValorHoraTrabalhada());
        System.out.println("Quantidade de horas trabalhadas: " + this.getQuantHorasTrabalhadas());
    }
}
