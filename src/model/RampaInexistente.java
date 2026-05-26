package model;

/**
 * Representa um local onde falta rampa de acessibilidade.
 * Herda de Obstaculo e registra o ponto exato onde a rampa deveria existir.
 */
public class RampaInexistente extends Obstaculo {

    private String pontoFaltante; // descrição de onde exatamente falta a rampa

    // Construtor completo
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo, String pontoFaltante) {
        super(localizacao, descricao, nivelDePerigo);
        this.pontoFaltante = pontoFaltante;
    }

    // Construtor sobrecarregado (overload): ponto não informado
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.pontoFaltante = "Ponto não especificado";
    }

    public String getPontoFaltante()         { return pontoFaltante; }
    public void   setPontoFaltante(String v) { this.pontoFaltante = v; }

    // Polimorfismo: sobrescreve exibirDetalhes() com informações da rampa
    @Override
    public void exibirDetalhes() {
        System.out.println("=== RAMPA INEXISTENTE ===");
        System.out.println(super.toString());
        System.out.println("Onde deveria ter rampa: " + pontoFaltante);
        System.out.println("------------------------");
    }
}
