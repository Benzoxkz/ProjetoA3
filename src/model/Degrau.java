package model;

// Degrau é um tipo de obstáculo que tem altura específica.
// Herda os atributos básicos de Obstaculo (localizacao, descricao, nivelDePerigo).
public class Degrau extends Obstaculo {

    private double alturaCm;

    public Degrau(String localizacao, String descricao, int nivelDePerigo, double alturaCm) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaCm = alturaCm;
    }

    // Segundo construtor para quando a pessoa não sabe a altura exata
    public Degrau(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaCm = 5.0; // colocamos 5cm como padrão
    }

    public double getAlturaCm() { return alturaCm; }
    public void setAlturaCm(double alturaCm) { this.alturaCm = alturaCm; }

    @Override
    public void exibirDetalhes() {
        System.out.println(">>> DEGRAU");
        System.out.println(toString());
        System.out.println("Altura: " + alturaCm + " cm");
        System.out.println("---");
    }
}
