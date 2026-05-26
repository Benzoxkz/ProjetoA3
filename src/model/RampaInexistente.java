package model;

// Lugar onde deveria ter rampa mas não tem.
// Herda de Obstaculo e guarda onde exatamente a rampa está faltando.
public class RampaInexistente extends Obstaculo {

    private String pontoFaltante;

    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo, String pontoFaltante) {
        super(localizacao, descricao, nivelDePerigo);
        this.pontoFaltante = pontoFaltante;
    }

    // Segundo construtor para quando não se sabe o ponto exato
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.pontoFaltante = "nao especificado";
    }

    public String getPontoFaltante() { return pontoFaltante; }
    public void setPontoFaltante(String pontoFaltante) { this.pontoFaltante = pontoFaltante; }

    @Override
    public void exibirDetalhes() {
        System.out.println(">>> RAMPA INEXISTENTE");
        System.out.println(toString());
        System.out.println("Onde deveria ter rampa: " + pontoFaltante);
        System.out.println("---");
    }
}
