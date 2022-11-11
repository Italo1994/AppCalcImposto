# AppCalcImposto

#Descrição

a) Crie uma interface ITributavel (dentro do pacote modelo) com um método double
calcularTributos();

b) Crie uma classe ContaCorrente (dentro do pacote modelo) que possui três atributos (String agencia, String numero e double saldo) e três métodos
(sacar(valor: double): void; depositar(valor: double): void; e transferir(valor: double, cc: ContaCorrente): boolean);

c) Crie uma classe SeguroVida (dentro do pacote modelo) com quatro atributos (int numero, String beneficiado, double valor, double taxa);

d) Crie uma classe Pessoa (dentro do pacote modelo) com quatro atributos (String nome, double salario, ContaCorrente conta e SeguroVida seguro).
Cada Pessoa possui um salário, e dessa forma, será cobrado 11% de imposto sobre o mesmo.

e) Por último, os bens de cada pessoa (conta e seguro) serão tributados da seguinte forma:
  1) ContaCorrente paga 0,38% do valor do saldo;
  2) SeguroVida paga uma taxa de R$ 31,50.
  
f) Crie uma classe PessoaDAO (dentro do pacote dao) que se encarregará de guardar todas as pessoas em um ArrayList. Para tal, você precisará implementar cinco métodos:
  1) cadastrarPessoa(Pessoa);
  2) removerPessoa(Pessoa);
  3) listarPessoas()(conforme modelo de impressão abaixo). 
  4) calcularTributosPessoas() (conforme modelo de impressão abaixo)
  
    ***********************************************
    Nome...: Roberto    IRPF...: 87.07
    ***********************************************
    Nome...: Dom Pedro    IRPF...: 142.64
    ***********************************************
    Nome...: Rui Barbosa    IRPF...: 200.96
    ***********************************************
  
  5) imprimeImpostoTotal() que imprime o valor total de imposto a ser recolhido, o nome da pessoa que pagará o maior imposto e o nome do beneficiado com o maior valor de seguro.
  
g) Crie uma classe GeradorImpostoRenda (dentro do pacote controle) que recebe todos os bens tributáveis de uma Pessoa, soma cada um deles e retorna o valor total através do atributo double totalTributo e do método double calculaValorTotalTributo(Pessoa p).

h) Crie uma classe de visão ImpostoRendaPF (dentro do pacote visao) que instancia três (3) objetos do tipo Pessoa, e na sequência, tais objetos precisarão ser persistidos em um ArrayList, pertencente à classe PessoaDAO, assim como os bens (salário, conta e seguro) de cada Pessoa deverão ser calculados, para que os tributos possam ser retidos no Imposto de Renda.
