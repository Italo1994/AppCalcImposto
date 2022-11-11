package br.ufrn.imd.modelo;

public class SeguroVida implements ITributavel {
    protected double valor;
	protected double taxa;
    protected int numero;
	protected String beneficiado;
	
	public SeguroVida(){
		this.valor = 0;
		this.taxa = 31.50;
	}

    public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

    public void setBeneficiado(String beneficiado) {
		this.beneficiado = beneficiado;
	}

	public String getBeneficiado() {
		return beneficiado;
	}

    public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

    public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

	@Override
	public double calcularTributos() { //taxa de R$ 31,50
		return taxa;
	}
}
