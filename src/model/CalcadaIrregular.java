package model;

public class CalcadaIrregular extends Obstaculo {

    private String tipoIrregularidade;

    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo, String tipoIrregularidade) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = tipoIrregularidade;
    }

   
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = "Nao especificado";
    }

  

    public String getTipoIrregularidade() { return tipoIrregularidade; }
    public void setTipoIrregularidade(String tipoIrregularidade) { this.tipoIrregularidade = tipoIrregularidade; }

 
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: CALCADA IRREGULAR ===");
        System.out.println(super.toString());
        System.out.println("Tipo de irregularidade: " + tipoIrregularidade);
        System.out.println("----------------------");
    }

    
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao da calcada nao informada.");
        } else {
            System.out.println("Posicao validada: calcada irregular em " + getLocalizacao());
        }
    }
}
