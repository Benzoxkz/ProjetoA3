package model;

public class RampaInexistente extends Obstaculo {
    private String localizacaoFaltante;

    public RampaInexistente(String localizacao, String descricao, int nivelDePerigo, String localizacaoFaltante) {
        super(localizacao, descricao, nivelDePerigo);
        this.localizacaoFaltante = localizacaoFaltante;
    }

    public String getLocalizacaoFaltante() { return localizacaoFaltante; }
    public void setLocalizacaoFaltante(String localizacaoFaltante) { this.localizacaoFaltante = localizacaoFaltante; }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALERTA DE FALTA DE RAMPA ===");
        System.out.println(super.toString());
        System.out.println("Ponto exato onde deveria ter rampa: " + localizacaoFaltante);
    }

    @Override
    public void validarPosicao() {
        System.out.println("Validando viabilidade de instalação de rampa em: " + getLocalizacao());
    }
}