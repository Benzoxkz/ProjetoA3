package model;

/**
 * Representa um local onde falta rampa de acessibilidade.
 * Herda de Obstaculo e adiciona o atributo localizacaoFaltante.
 */
public class RampaInexistente extends Obstaculo {

    private String localizacaoFaltante; // Ponto exato onde deveria haver rampa

    /**
     * Construtor completo.
     */
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo, String localizacaoFaltante) {
        super(localizacao, descricao, nivelDePerigo);
        this.localizacaoFaltante = localizacaoFaltante;
    }

    /**
     * Construtor sobrecarregado (overload) — sem detalhe de localização faltante.
     */
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.localizacaoFaltante = "Ponto nao especificado";
    }

    // ---------- Getter e Setter ----------

    public String getLocalizacaoFaltante() { return localizacaoFaltante; }
    public void setLocalizacaoFaltante(String localizacaoFaltante) { this.localizacaoFaltante = localizacaoFaltante; }

    /**
     * Exibe detalhes da rampa inexistente (sobrescrita / polimorfismo).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: RAMPA INEXISTENTE ===");
        System.out.println(super.toString());
        System.out.println("Onde deveria ter rampa: " + localizacaoFaltante);
        System.out.println("----------------------");
    }

    /**
     * Valida a posição da rampa inexistente (sobrescrita).
     */
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao nao informada.");
        } else {
            System.out.println("Posicao validada: rampa inexistente em " + getLocalizacao());
        }
    }
}
