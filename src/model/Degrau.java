package model;


public class Degrau extends Obstaculo {

    private double alturaDegrau; 
    public Degrau(String localizacao, String descricao, int nivelDePerigo, double alturaDegrau) {
        super(localizacao, descricao, nivelDePerigo); 
        this.alturaDegrau = alturaDegrau;
    }

   
    public Degrau(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.alturaDegrau = 5.0; 
    }



    public double getAlturaDegrau() { return alturaDegrau; }
    public void setAlturaDegrau(double alturaDegrau) { this.alturaDegrau = alturaDegrau; }

   
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: DEGRAU ===");
        System.out.println(super.toString());
        System.out.println("Altura do degrau: " + alturaDegrau + " cm");
        System.out.println("----------------------");
    }

   
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao do degrau nao informada.");
        } else {
            System.out.println("Posicao validada: degrau em " + getLocalizacao());
        }
    }
}
