package model;


public class RampaInexistente extends Obstaculo {

    private String localizacaoFaltante; 

   
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo, String localizacaoFaltante) {
        super(localizacao, descricao, nivelDePerigo);
        this.localizacaoFaltante = localizacaoFaltante;
    }

   
    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo) {
        super(localizacao, descricao, nivelDePerigo);
        this.localizacaoFaltante = "Ponto nao especificado";
    }

    

    public String getLocalizacaoFaltante() { return localizacaoFaltante; }
    public void setLocalizacaoFaltante(String localizacaoFaltante) { this.localizacaoFaltante = localizacaoFaltante; }

   
    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA: RAMPA INEXISTENTE ===");
        System.out.println(super.toString());
        System.out.println("Onde deveria ter rampa: " + localizacaoFaltante);
        System.out.println("----------------------");
    }

    
    @Override
    public void validarPosicao() {
        if (getLocalizacao() == null || getLocalizacao().isEmpty()) {
            System.out.println("Erro: Localizacao nao informada.");
        } else {
            System.out.println("Posicao validada: rampa inexistente em " + getLocalizacao());
        }
    }
}
