package model;

/**
 * Representa uma calçada irregular ou danificada.
 * Herda de Obstaculo e adiciona o atributo tipoIrregularidade.
 */
public class CalcadaIrregular extends Obstaculo {

    private String tipoIrregularidade;

    /**
     * Construtor completo.
     */
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo, String tipoIrregularidade) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = tipoIrregularidade;
    }

    /**
     * Construtor sobrecarregado (overload) — tipo padrão "Nao especificado".
     */
    public CalcadaIrregular(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.tipoIrregularidade = "Nao especificado";
    }

    // ---------- Getter e Setter ----------

    public String getTipoIrregularidade() { return tipoIrregularidade; }
    public void setTipoIrregularidade(String tipoIrregularidade) { this.tipoIrregularidade = tipoIrregularidade; }

    /**
     * Exibe detalhes da calçada irregular (sobrescrita / polimorfismo).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: CALCADA IRREGULAR ===");
        System.out.println(super.toString());
        System.out.println("Tipo de irregularidade: " + tipoIrregularidade);
        System.out.println("----------------------");
    }

    /**
     * Valida a posição da calçada (sobrescrita).
     */
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao da calcada nao informada.");
        } else {
            System.out.println("Posicao validada: calcada irregular em " + getLocalizacao());
        }
    }
}
