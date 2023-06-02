public class Principal {
    public static void main(String[] args) {
        int opcao = 0;
        Loja loja = null;
        Produto produto = null;

        while (opcao != 3) {
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = Teclado.leInt();

            switch (opcao) {
                case 1:
                    loja = criarLoja();
                    System.out.println("Loja criada com sucesso: " + loja);
                    System.out.println(loja.toString());
                    break;
                case 2:
                    produto = criarProduto();
                    System.out.println("Produto criado com sucesso: " + produto);
                    System.out.println(produto.toString());

                    Data dataReferencia = new Data(20, 10, 2023);
                    if (produto.estaVencido(dataReferencia)) {
                        System.out.println("PRODUTO VENCIDO");
                    } else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static Loja criarLoja() {
        System.out.print("Digite o nome da loja: ");
        String nome = Teclado.leString();
        System.out.print("Digite a quantidade de funcionários: ");
        int quantidadeFuncionarios = Teclado.leInt();
        System.out.print("Digite o salário base do funcionário: ");
        double salarioBaseFuncionario = Teclado.leDouble();
        System.out.print("Digite a quantidade de produtos: ");
        int quantidadeMaximaProdutos = Teclado.leInt();

        System.out.println("Digite o endereço da loja:");
        System.out.print("Nome da rua: ");
        String nomeDaRua = Teclado.leString();
        System.out.print("Cidade: ");
        String cidade = Teclado.leString();
        System.out.print("Estado: ");
        String estado = Teclado.leString();
        System.out.print("País: ");
        String pais = Teclado.leString();
        System.out.print("CEP: ");
        String cep = Teclado.leString();
        System.out.print("Número: ");
        String numero = Teclado.leString();
        System.out.print("Complemento: ");
        String complemento = Teclado.leString();

        Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

        System.out.println("Digite a data de fundação da loja:");
        System.out.print("Dia: ");
        int dia = Teclado.leInt();
        System.out.print("Mês: ");
        int mes = Teclado.leInt();
        System.out.print("Ano: ");
        int ano = Teclado.leInt();

        Data dataFundacao = new Data(dia, mes, ano);

        return new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaximaProdutos);
    }

    private static Produto criarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = Teclado.leString();
        System.out.print("Digite o preço do produto: ");
        double preco = Teclado.leDouble();

        System.out.println("Digite a data de validade do produto:");
        System.out.print("Dia: ");
        int dia = Teclado.leInt();
        System.out.print("Mês: ");
        int mes = Teclado.leInt();
        System.out.print("Ano: ");
        int ano = Teclado.leInt();

        Data dataValidade = new Data(dia, mes, ano);

        return new Produto(nome, preco, dataValidade);
    }
}


