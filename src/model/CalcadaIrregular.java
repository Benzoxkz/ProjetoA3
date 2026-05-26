package model;

// Representa calçadas com buracos, raízes, piso solto, etc.
// Herda de Obstaculo e adiciona o campo tipoIrregularidade.
public class CalcadaIrregular extends Obstaculo {

    private String tipoIrregularidade;

    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo, String tipoIrregularidade) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = tipoIrregularidade;
    }

    // Segundo construtor para quando o tipo não foi informado
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = "nao informado";
    }

    public String getTipoIrregularidade() { return tipoIrregularidade; }
    public void setTipoIrregularidade(String tipoIrregularidade) { this.tipoIrregularidade = tipoIrregularidade; }

    @Override
    public void exibirDetalhes() {
        System.out.println(">>> CALCADA IRREGULAR");
        System.out.println(toString());
        System.out.println("Tipo: " + tipoIrregularidade);
        System.out.println("---");
    }
}
