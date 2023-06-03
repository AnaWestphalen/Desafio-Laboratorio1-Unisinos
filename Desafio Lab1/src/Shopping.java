public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome,
                    Endereco endereco,
                    int quantidadeMaximaDeLojas ){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaDeLojas];
    }

    public String getNome(){
        return nome;
    }

    public Endereco getEndereco() {
        return  endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

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
        String lojasString = "";
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null) {
                lojasString += lojas[i].toString();
                if (i < lojas.length - 1) {
                    lojasString += ", ";
                }
            }
        }

        return "Shopping { " +
                "Nome: " +getNome() + '\'' +
                ", Endereço: " +getEndereco() +
                ", Quantidade de lojas: [\" + lojasString + \"]" +
                " }";
    }

    public boolean insereLoja(Loja novaloja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = novaloja;
                return true; //loja foi inserida
            }
        }
        return false; //loja não pode ser inserida
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            Loja loja = lojas[i];
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true; //loja removida
            }
        }
        return false; //loja não localizada
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int quantidade = 0;

        if (tipoLoja.equalsIgnoreCase("Cosmético")) {
            for (Loja loja : lojas) {
                if (loja instanceof Cosmetico) {
                    quantidade++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Vestuário")) {
            for (Loja loja : lojas) {
                if (loja instanceof Vestuario) {
                    quantidade++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Bijuteria")) {
            for (Loja loja : lojas) {
                if (loja instanceof Bijuteria) {
                    quantidade++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Alimentação")) {
            for (Loja loja : lojas) {
                if (loja instanceof Alimentacao) {
                    quantidade++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Informática")) {
            for (Loja loja : lojas) {
                if (loja instanceof Informatica) {
                    quantidade++;
                }
            }
        } else {
            return -1; // Tipo de loja inválido
        }

        return quantidade;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorValorSeguro = 0.0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                double valorSeguro = informatica.getSeguroEletronicos();

                if (valorSeguro > maiorValorSeguro) {
                    maiorValorSeguro = valorSeguro;
                    lojaMaisCara = informatica;
                }
            }
        }
        return lojaMaisCara;
    }
}


