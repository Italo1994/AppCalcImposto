package br.ufrn.imd.modelo;

public class ContaCorrente implements ITributavel {
    protected String numero;
    protected String agencia;
	protected double saldo;
	
	public ContaCorrente(){
		this.saldo = 0;
	}

    public boolean transferir(double valor, ContaCorrente conta) {
		boolean autorizado = false;

		if(valor > 0) {
			System.out.println("Transferindo...");
			
            if(sacar(valor)) {
				conta.depositar(valor);
                System.out.println("Valor de R$ " + valor + " transferido para a conta de número " + conta.getNumero());
				autorizado = true;
            }
			else {
				System.out.println("Não foi possível realizar a transferência!");
            }
		}
		else { 
            System.out.println("Valor negativo informado!");
        }

		return autorizado;
	}

    public void depositar(double valor){
		if(valor > 0){
			this.saldo += this.saldo + valor;
			System.out.println("Depósito no valor de R$ " + valor + " na conta de número " + getNumero() + " realizado com sucesso!");
		}
		else {
            System.out.println("Valores negativos não são aceitos!");
        }
	}

    public boolean sacar(double valor){
		boolean autorizado = false;

		if(valor > 0 && this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.println("Saque no valor de R$ " + valor + " na conta de número " + getNumero() + " realizado com sucesso!");
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
	public double calcularTributos() { // 0,38% do saldo
		return saldo * 0.0038;
	}
}
