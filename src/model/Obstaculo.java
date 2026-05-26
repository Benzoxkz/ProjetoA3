package model;

// Classe base para todos os obstáculos do mapa.
// É abstrata porque não faz sentido criar um "obstáculo genérico" — 
// sempre vai ser um degrau, calçada ou rampa.
public abstract class Obstaculo {

    private String localizacao;
    private String descricao;
    private int nivelDePerigo; // 1 = baixo risco, 10 = crítico

    public Obstaculo(String localizacao, String descricao, int nivelDePerigo) {
        this.localizacao = localizacao;
        this.descricao = descricao;

        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            throw new IllegalArgumentException("Nivel de perigo tem que ser entre 1 e 10.");
        }
        this.nivelDePerigo = nivelDePerigo;
    }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getNivelDePerigo() { return nivelDePerigo; }
    public void setNivelDePerigo(int nivelDePerigo) {
        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            throw new IllegalArgumentException("Nivel de perigo tem que ser entre 1 e 10.");
        }
        this.nivelDePerigo = nivelDePerigo;
    }

    // Cada subclasse vai implementar esse método do seu jeito
    public abstract void exibirDetalhes();

    @Override
    public String toString() {
        return "Local: " + localizacao + " | Descricao: " + descricao + " | Perigo: " + nivelDePerigo + "/10";
    }
}
