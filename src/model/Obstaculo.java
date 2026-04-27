package model;

public abstract class Obstaculo {
    private String localizacao;
    private String descricao;
    private int nivelDePerigo;

    public Obstaculo(String localizacao, String descricao, int nivelDePerigo) {
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.nivelDePerigo = nivelDePerigo;
    }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getNivelDePerigo() { return nivelDePerigo; }
    public void setNivelDePerigo(int nivelDePerigo) { this.nivelDePerigo = nivelDePerigo; }

    // Métodos a serem sobrescritos (Polimorfismo)
    public abstract void exibirDetalhes();
    public abstract void validarPosicao();

    @Override
    public String toString() {
        return "Local: " + localizacao + " | Descricao: " + descricao + " | Perigo (1-10): " + nivelDePerigo;
    }
}