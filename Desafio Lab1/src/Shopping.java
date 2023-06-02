public class Shopping {
    private String nome;
    private Endereco endereco;

    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaDeLojas ){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaDeLojas];
    }

    public String getNome(){
        return nome;
    }

    public Endereco getEndereco() { return  endereco; }

    public Loja[] getLojas() { return lojas; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public String toString(){
        return "Shopping { " +
                "Nome: " +getNome() + '\'' +
                ", Endereço: " +getEndereco() +
                ", Quantidade de lojas: " +getLojas() +
                " }";
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            Loja loja = lojas[i];
            if (loja != null && loja.getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int quantidade = 0;

        if (tipoLoja.equalsIgnoreCase("Alimentacao") ||
                tipoLoja.equalsIgnoreCase("Bijuteria") ||
                tipoLoja.equalsIgnoreCase("Cosmetico") ||
                tipoLoja.equalsIgnoreCase("Informática") && tipoLoja != null) {

            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] instanceof Alimentacao && tipoLoja.equalsIgnoreCase("Alimentacao")) {
                    quantidade++;
                }else if(lojas[i] instanceof Bijuteria && tipoLoja.equalsIgnoreCase("Bijuteria")){
                    quantidade++;
                }else if(lojas[i] instanceof Cosmetico && tipoLoja.equalsIgnoreCase("Cosmetico")){
                    quantidade++;
                }else if(lojas[i] instanceof Informatica && tipoLoja.equalsIgnoreCase("Informática")){
                    quantidade++;
                }else if(lojas[i] instanceof Vestuario&& tipoLoja.equalsIgnoreCase("Vestuario")){
                    quantidade++;
                }
            }
            return quantidade;
        } else {
            return -1;
        }
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorValorSeguro = 0.0;

        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i] instanceof Informatica) {
                Informatica informatica = (Informatica) lojas[i];
                if (informatica.getSeguroEletronicos() > maiorValorSeguro) {
                    maiorValorSeguro = informatica.getSeguroEletronicos();
                    lojaMaisCara = (Informatica) lojas[i];
                }
            }
        }
        return lojaMaisCara;
    }
}


