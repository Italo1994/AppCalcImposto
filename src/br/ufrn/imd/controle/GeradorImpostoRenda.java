package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.*;

public class GeradorImpostoRenda {
    private double totalTributo;
	
	public GeradorImpostoRenda(){
		totalTributo = 0;
	}
	
	public double calculaValorTotalTributo(Pessoa pessoa){
		totalTributo = 0;
		
		totalTributo += pessoa.getConta().calculaTributos();
		
		totalTributo += pessoa.getSeguro().calculaTributos();
		
		totalTributo += pessoa.calculaTributos();
		
		return totalTributo;
	}
}
