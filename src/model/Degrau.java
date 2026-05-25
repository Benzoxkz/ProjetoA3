package model;

/**
 * Representa um degrau ou obstáculo de altura em calçadas.
 * Herda de Obstaculo e adiciona o atributo específico alturaDegrau.
 */
public class Degrau extends Obstaculo {

    private double alturaDegrau; // Altura em centímetros

    /**
     * Construtor completo com todos os atributos.
     */
    public Degrau(String localizacao, String descricao, int nivelDePerigo, double alturaDegrau) {
        super(localizacao, descricao, nivelDePerigo); // Chama o construtor da classe pai
        this.alturaDegrau = alturaDegrau;
    }

    /**
     * Construtor sobrecarregado (overload) — cria degrau com altura padrão de 5.0 cm.
     * Útil para registros rápidos quando a altura não é conhecida.
     */
    public Degrau(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaDegrau = 5.0; // Valor padrão
    }

    // ---------- Getter e Setter ----------

    public double getAlturaDegrau() { return alturaDegrau; }
    public void setAlturaDegrau(double alturaDegrau) { this.alturaDegrau = alturaDegrau; }

    /**
     * Exibe detalhes específicos do degrau (sobrescrita / polimorfismo).
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: DEGRAU ===");
        System.out.println(super.toString());
        System.out.println("Altura do degrau: " + alturaDegrau + " cm");
        System.out.println("----------------------");
    }

    /**
     * Valida a posição do degrau (sobrescrita).
     */
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao do degrau nao informada.");
        } else {
            System.out.println("Posicao validada: degrau em " + getLocalizacao());
        }
    }
}
