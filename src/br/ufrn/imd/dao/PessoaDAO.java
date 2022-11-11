package br.ufrn.imd.dao;

import br.ufrn.imd.controle.GeradorImpostoRenda;
import br.ufrn.imd.modelo.Pessoa;

import java.util.ArrayList;

public class PessoaDAO {
	
	private ArrayList<Pessoa> pessoas;
	private GeradorImpostoRenda geradorImpostoRenda;
	
	public PessoaDAO(){
		pessoas = new ArrayList<Pessoa>();
		geradorImpostoRenda = new GeradorImpostoRenda();
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public void removerPessoa(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}

	public void listarPessoas() {
        System.out.println("\n==================== LISTAGEM DE PESSOAS ====================\n");
		
		for(Pessoa pessoa : pessoas){
			System.out.println("*******************************************************");
            System.out.println("Nome...: " + pessoa.getNome() + "\t" + "Salário.: " + pessoa.getSalario());
			System.out.println("Agência: " + pessoa.getConta().getAgencia() + " Conta.: " + pessoa.getConta().getNumero() + "\t" + "Saldo.: " + pessoa.getConta().getSaldo());
			System.out.println("Seguro.: " + pessoa.getSeguro().getNumero() + "\tBeneficiário.: " + pessoa.getSeguro().getBeneficiado());
			System.out.println("Valor Seguro: " + pessoa.getSeguro().getValor());
			System.out.println("*******************************************************");
            System.out.println("");
 		}
		System.out.println("");
	}
	
	public void imprimeImpostoTotal() {
		
		Pessoa pessoa = null;
		String nomeBeneficiado = "";
		double impostoTotal = 0;
		double maiorImposto = 0;
		double maiorSeguro = 0;
		
		for(Pessoa pessoa2 : pessoas) {
			impostoTotal = impostoTotal + geradorImpostoRenda.calculaValorTotalTributo(pessoa2);
			if (geradorImpostoRenda.calculaValorTotalTributo(pessoa2) > maiorImposto) {
				maiorImposto = geradorImpostoRenda.calculaValorTotalTributo(pessoa2);
				pessoa = pessoa2;
			}
			
			if (pessoa2.getSeguro().getValor() > maiorSeguro) {
				maiorSeguro = pessoa2.getSeguro().getValor();
				nomeBeneficiado = pessoa2.getSeguro().getBeneficiado();
			}
		}

        System.out.println("Total de impostos arrecadados: " + impostoTotal);
        System.out.println("Pessoa com o maior imposto a pagar: " + pessoa.getNome());
        System.out.println("Valor do imposto a pagar por " + pessoa.getNome() + ": R$ " + geradorImpostoRenda.calculaValorTotalTributo(pessoa));

        System.out.println("\nNome do beneficiado com o maior valor de seguro: " + nomeBeneficiado);
        System.out.println("Valor do benefício: R$ " + maiorSeguro);
	}

    public void calcularTributosPessoas() {
		
		System.out.println("==================== TRIBUTOS DAS PESSOAS ====================\n");
		
		for(Pessoa pessoa : pessoas){
			System.out.println("*********************************************");
            System.out.println("Nome...: " + pessoa.getNome() + "\t" + "IRPF...: " + geradorImpostoRenda.calculaValorTotalTributo(pessoa));
            System.out.println("*********************************************");
 		}
		System.out.println("\n");
	}
}