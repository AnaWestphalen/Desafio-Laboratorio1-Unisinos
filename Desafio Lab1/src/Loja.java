public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;

    private Produto[] estoqueProdutos;

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeMaximaProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeMaximaProdutos];
    }

    public String getNome(){
        return nome;
    }

    public int getQuantidadeFuncionarios(){
        return quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public Endereco getEndereco() { return endereco; }

    public Data getDataFundacao() { return dataFundacao; }

    public Produto[] getEstoqueProdutos() { return estoqueProdutos; }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios){
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario){
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos, int quantidadeMaximaProdutos) {
        this.estoqueProdutos = new Produto[quantidadeMaximaProdutos];
    }

    public String toString(){
        return "Loja { " +
                "Nome: " +getNome() + '\'' +
                ", Quantidade de funcionários: " +getQuantidadeFuncionarios() +
                ", Salário base do funcionário: " +getSalarioBaseFuncionario() +
                ", Endereço: " +getEndereco() +
                ", Data de fundação: " +getDataFundacao() +
                ", Estoque de produtos: " +getEstoqueProdutos() +
                " }";
    }

    public double gastosComSalario(){
        return this.salarioBaseFuncionario == -1 ? -1 : (this.quantidadeFuncionarios * this.salarioBaseFuncionario);
    }

    public char tamanhoDaLoja(){
        if (this.quantidadeFuncionarios < 10){
            return 'P';
        } else if (10 <= this.quantidadeFuncionarios && this.quantidadeFuncionarios <= 30){
            return 'M';
        } else {
            return 'G';
        }
    }

    public void imprimeProdutos() {
        System.out.println("Produtos da loja:");

        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                System.out.println(produto.toString());
            }
        }
    }

    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            Produto produto = estoqueProdutos[i];
            if (produto != null && produto.getNome().equals(nomeProduto)) {
                estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }
}
