public class  Data{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        validacaoData();
    }

    private void validacaoData(){
        boolean dataValida = true;

        if (mes < 1 || mes > 12){
            dataValida = false;
        } else if (dia < 1 || dia > diasPorMes()) {
            dataValida = false;
        }

        if (! dataValida) {
            System.out.println("A data inserida é inválida. Será atribuída a data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    private int diasPorMes() {
        int diasPorMes = 0;

        switch (mes) {
            case 2:
                diasPorMes = (verificaAnoBissexto()) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasPorMes = 30;
                break;
            default:
                diasPorMes = 31;
        }

        return diasPorMes;
    }

    public boolean verificaAnoBissexto() {
        return (ano % 400 == 0) || ((ano % 100 != 0) && (ano % 4 == 0));
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return "Data de criação da loja: " +dia + "/" + mes + "/" + ano;
    }
}
