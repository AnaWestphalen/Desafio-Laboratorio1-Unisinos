public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
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

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios){
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario){
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public String toString(){
        return "Loja { " +
                "Nome: " +getNome() + '\'' +
                ", Quantidade de funcionários: " +getQuantidadeFuncionarios() +
                ", Salário base do funcionário: " +getSalarioBaseFuncionario() +
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
}
