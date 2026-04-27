package model;

public class Degrau extends Obstaculo {
    private double alturaDegrau;

    public Degrau(String localizacao, String descricao, int nivelDePerigo, double alturaDegrau) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaDegrau = alturaDegrau;
    }

    public double getAlturaDegrau() { return alturaDegrau; }
    public void setAlturaDegrau(double alturaDegrau) { this.alturaDegrau = alturaDegrau; }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA DE DEGRAU ===");
        System.out.println(super.toString());
        System.out.println("Altura do degrau: " + alturaDegrau + " cm");
    }

    @Override
    public void validarPosicao() {
        System.out.println("Validando coordenadas do degrau em: " + getLocalizacao());
    }
}