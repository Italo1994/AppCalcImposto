package br.ufrn.imd.modelo;

public class Pessoa implements ITributavel {
    protected String nome;
	protected double salario;
	protected ContaCorrente conta;
	protected SeguroVida seguro;
	
	public Pessoa(){
		salario = 0;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setSeguro(SeguroVida seguro) {
		this.seguro = seguro;
	}

	public SeguroVida getSeguro() {
		return seguro;
	}

    @Override
	public double calcularTributos() { // 11% do salário
		return salario * 0.11;
	}
}
