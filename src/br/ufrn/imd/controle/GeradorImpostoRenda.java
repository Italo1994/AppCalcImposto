package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.*;

public class GeradorImpostoRenda {
    private double totalTributo;
	
	public GeradorImpostoRenda(){
		totalTributo = 0;
	}
	
	public double calculaValorTotalTributo(Pessoa pessoa){
		totalTributo = 0;
		
		totalTributo = totalTributo + pessoa.calcularTributos();
		
		totalTributo = totalTributo + pessoa.getConta().calcularTributos();
		
		totalTributo = totalTributo + pessoa.getSeguro().calcularTributos();
		
		return totalTributo;
	}
}
