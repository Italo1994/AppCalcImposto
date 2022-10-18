package br.ufrn.imd.modelo;

public class Pessoa implements Tributavel {
    protected String nome;
	protected double salario;
	protected ContaCorrente conta;
	protected SeguroVida seguro;
	
	public Pessoa(){
		salario = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public SeguroVida getSeguro() {
		return seguro;
	}

	public void setSeguro(SeguroVida seguro) {
		this.seguro = seguro;
	}

    @Override
	public double calculaTributos() {
		return salario * 0.11;
	}
}
