package model;

/**
 * Representa uma calçada danificada ou irregular.
 * Herda de Obstaculo e adiciona o tipo de irregularidade encontrada.
 */
public class CalcadaIrregular extends Obstaculo {

    private String tipoIrregularidade; // ex: "buraco", "raiz", "piso solto"

    // Construtor completo
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo, String tipoIrregularidade) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = tipoIrregularidade;
    }

    // Construtor sobrecarregado (overload): tipo não informado
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = "Não especificado";
    }

    public String getTipoIrregularidade()         { return tipoIrregularidade; }
    public void   setTipoIrregularidade(String v) { this.tipoIrregularidade = v; }

    // Polimorfismo: sobrescreve exibirDetalhes() com informações da calçada
    @Override
    public void exibirDetalhes() {
        System.out.println("=== CALÇADA IRREGULAR ===");
        System.out.println(super.toString());
        System.out.println("Tipo: " + tipoIrregularidade);
        System.out.println("------------------------");
    }
}
