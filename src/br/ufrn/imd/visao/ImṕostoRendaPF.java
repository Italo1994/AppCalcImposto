package br.ufrn.imd.visao;

// import br.ufrn.imd.modelo.*;
// import br.ufrn.imd.dao.*;

import br.ufrn.imd.modelo.SeguroVida;
import br.ufrn.imd.modelo.Pessoa;
import br.ufrn.imd.dao.PessoaDAO;
import br.ufrn.imd.modelo.ContaCorrente;

public class ImṕostoRendaPF {
    public static void main(String[] args) {
        PessoaDAO repositorio = new PessoaDAO();

        ContaCorrente contaCorrente1 = new ContaCorrente();
		contaCorrente1.setAgencia("1234-5");
		contaCorrente1.setNumero("512.222-4");
		contaCorrente1.setSaldo(850);

        SeguroVida seguro1 = new SeguroVida();
		seguro1.setNumero(1);
		seguro1.setBeneficiado("Brad Pitt");
		seguro1.setValor(2500);
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Mary Jane");
		pessoa1.setSalario(3700.00);
		pessoa1.setConta(contaCorrente1);
		pessoa1.setSeguro(seguro1);

        ContaCorrente contaCorrente2 = new ContaCorrente();
		contaCorrente2.setAgencia("2244-8");
		contaCorrente2.setNumero("123.456-7");
		contaCorrente2.setSaldo(1720);

        SeguroVida seguro2 = new SeguroVida();
		seguro2.setNumero(2);
		seguro2.setBeneficiado("Astrid Berges");
		seguro2.setValor(5500);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Julia Roberts");
		pessoa2.setSalario(2800.00);
		pessoa2.setConta(contaCorrente2);
		pessoa2.setSeguro(seguro2);

        ContaCorrente contaCorrente3 = new ContaCorrente();
		contaCorrente3.setAgencia("5599-7");
		contaCorrente3.setNumero("231.543-1");
		contaCorrente3.setSaldo(1499);

        SeguroVida seguro3 = new SeguroVida();
		seguro3.setNumero(3);
		seguro3.setBeneficiado("Bruce Tatum");
		seguro3.setValor(5500);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Jack Nicolson");
		pessoa3.setSalario(4800.00);
		pessoa3.setConta(contaCorrente3);
		pessoa3.setSeguro(seguro3);

        repositorio.cadastrarPessoa(pessoa1);
        repositorio.cadastrarPessoa(pessoa2);
        repositorio.cadastrarPessoa(pessoa3);

		// testando a listagem
        repositorio.listarPessoas();

		pessoa1.getConta().sacar(100);
		pessoa2.getConta().depositar(120);
		pessoa1.getConta().transferir(400, contaCorrente3);
		
		repositorio.listarPessoas();
        repositorio.calcularTributosPessoas();
        repositorio.imprimeImpostoTotal();
    }
}
