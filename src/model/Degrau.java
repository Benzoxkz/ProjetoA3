package model;

/**
 * Representa um degrau em calçadas ou entradas de estabelecimentos.
 * Herda de Obstaculo e adiciona o atributo específico: altura do degrau.
 */
public class Degrau extends Obstaculo {

    private double alturaCm; // altura do degrau em centímetros

    // Construtor completo
    public Degrau(String localizacao, String descricao, int nivelDePerigo, double alturaCm) {
        super(localizacao, descricao, nivelDePerigo); // chama o construtor da classe pai
        this.alturaCm = alturaCm;
    }

    // Construtor sobrecarregado (overload): usa altura padrão quando não se sabe o valor
    public Degrau(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaCm = 5.0; // valor padrão de 5 cm
    }

    public double getAlturaCm()           { return alturaCm; }
    public void   setAlturaCm(double v)   { this.alturaCm = v; }

    // Polimorfismo: sobrescreve exibirDetalhes() com informações do degrau
    @Override
    public void exibirDetalhes() {
        System.out.println("=== DEGRAU ===");
        System.out.println(super.toString());
        System.out.println("Altura: " + alturaCm + " cm");
        System.out.println("--------------");
    }
}
