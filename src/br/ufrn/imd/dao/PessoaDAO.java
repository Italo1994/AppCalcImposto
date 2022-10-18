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
	
	public void adicionarPessoas(Pessoa pessoa) {

		pessoas.add(pessoa);

	}

	public void exibirPessoas() {
        System.out.println("========== LISTA DE PESSOAS ==========\n");
		
		for(Pessoa pessoa : pessoas){
            System.out.println("Nome...: " + pessoa.getNome());
            System.out.println("Salário.: " + pessoa.getSalario());
            System.out.println("Agência: " + pessoa.getConta().getAgencia());
            System.out.println("Número da conta.: " + pessoa.getConta().getNumero());
            System.out.println("Saldo.: " + pessoa.getConta().getSaldo());
            System.out.println("Seguro.: " + pessoa.getSeguro().getNumero());
            System.out.println("Beneficiário.: " + pessoa.getSeguro().getBeneficiado());
            System.out.println("Valor do Seguro: " + pessoa.getSeguro().getValor());
            System.out.println("");
 		}
		System.out.println("========== / ==========");
	}
	
	public void imprimirImpostoTotal() {
		
		double impostoTotal = 0;
		double maiorImposto = 0;
		double maiorSeguro = 0;
		Pessoa pessoa = null;
		String nomeBeneficiado = "";
		
		for(Pessoa pessoa2 : pessoas){
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

        System.out.println("Total de impostos: " + impostoTotal);
        System.out.println("Pessoa com o maior IRPF a pagar: " + pessoa.getNome());
        System.out.println("Valor do IRPF a pagar: " + geradorImpostoRenda.calculaValorTotalTributo(pessoa));

        System.out.println("\nMaior beneficiado: " + nomeBeneficiado);
        System.out.println("Valor do benefício: " + maiorSeguro);
	}

    public void calcularTributosPessoas() {
		
		System.out.println("\n========== TRIBUTOS DAS PESSOAS ==========\n");
		
		for(Pessoa pessoa : pessoas){
            System.out.println("Nome...: " + pessoa.getNome());
            System.out.println("IRPF...: " + geradorImpostoRenda.calculaValorTotalTributo(pessoa));
            System.out.println("");
 		}
		System.out.println("========== / ==========\n");
	}
}