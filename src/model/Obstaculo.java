package model;

/**
 * Classe abstrata que representa um obstáculo urbano genérico.
 * Todas as barreiras arquitetônicas herdam desta classe (herança).
 */
public abstract class Obstaculo {

    // Atributos privados — encapsulamento
    private String localizacao;
    private String descricao;
    private int nivelDePerigo; // Escala de 1 a 10

    /**
     * Construtor principal com todos os atributos.
     */
    public Obstaculo(String localizacao, String descricao, int nivelDePerigo) {
        this.localizacao = localizacao;
        this.descricao = descricao;
        // Validação: nível de perigo deve estar entre 1 e 10
        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            System.out.println("Aviso: nivel de perigo deve ser entre 1 e 10. Valor ajustado para 1.");
            this.nivelDePerigo = 1;
        } else {
            this.nivelDePerigo = nivelDePerigo;
        }
    }

    // ---------- Getters e Setters ----------

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getNivelDePerigo() { return nivelDePerigo; }
    public void setNivelDePerigo(int nivelDePerigo) {
        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            System.out.println("Nivel de perigo invalido. Mantendo valor anterior.");
        } else {
            this.nivelDePerigo = nivelDePerigo;
        }
    }

    // ---------- Métodos abstratos (polimorfismo) ----------

    /**
     * Exibe os detalhes específicos de cada tipo de obstáculo.
     * Cada classe filha sobrescreve este método (override / polimorfismo).
     */
    public abstract void exibirDetalhes();

    /**
     * Valida a posição do obstáculo no mapa.
     */
    public abstract void validarPosicao();

    /**
     * Representação em texto do obstáculo.
     */
    @Override
    public String toString() {
        return "Local: " + localizacao +
               " | Descricao: " + descricao +
               " | Perigo (1-10): " + nivelDePerigo;
    }
}
