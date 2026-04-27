package model;

public class CalcadaIrregular extends Obstaculo {
    private String tipoIrregularidade;

    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo, String tipoIrregularidade) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = tipoIrregularidade;
    }

    public String getTipoIrregularidade() { return tipoIrregularidade; }
    public void setTipoIrregularidade(String tipoIrregularidade) { this.tipoIrregularidade = tipoIrregularidade; }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA DE CALCADA IRREGULAR ===");
        System.out.println(super.toString());
        System.out.println("Tipo: " + tipoIrregularidade);
    }

    @Override
    public void validarPosicao() {
        System.out.println("Validando area da calcada irregular em: " + getLocalizacao());
    }
}