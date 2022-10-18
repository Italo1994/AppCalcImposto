package br.ufrn.imd.modelo;

public class ContaCorrente implements Tributavel {
    protected String numero;
    protected String agencia;
	protected double saldo;
	
	public ContaCorrente(){
		this.saldo = 0;
	}

    public void transfere(double valor, ContaCorrente conta){
		if(valor > 0){
			System.out.println("Transferindo...");
			
            if(saca(valor)) {
				conta.deposita(valor);
                System.out.println("Tranferindo o valor de R$ " + valor + " para a conta de número " + conta.getNumero());
            }
			else {
				System.out.println("Não foi possível realizar a transferência!");
            }
		}
		else { 
            System.out.println("Valor negativo informado!");
        }
	}

    public void deposita(double valor){
		if(valor > 0){
			this.saldo += this.saldo + valor;
			System.out.println("Depósito no valor de R$ " + valor + " na conta de número " + getNumero() + " realizado com sucesso!");
		}
		else {
            System.out.println("Valores negativos não são aceitos!");
        }
	}

    public boolean saca(double valor){
		boolean autorizado = false;

		if(valor > 0 && this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.println("Saque no valor de R$ " + valor + " ena conta de número " + getNumero() + " realizado com sucesso!");
			autorizado = true;
		}
		else {
            System.out.println("Saldo insuficiente ou valor negativo!");
        }
        
		return autorizado;
	}

    public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

    public String getAgencia() {
		return agencia;
	}

    public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public double calculaTributos() {
		return saldo * 0.0038;
	}
}
