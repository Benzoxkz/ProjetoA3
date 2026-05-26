package model;

/**
 * Classe abstrata que representa um obstáculo urbano.
 * Todas as barreiras herdam dela — isso é herança (POO).
 */
public abstract class Obstaculo {

    // Atributos privados — encapsulamento
    private String localizacao;
    private String descricao;
    private int nivelDePerigo; // de 1 (baixo) a 10 (crítico)

    // Construtor: inicializa os atributos comuns a todos os obstáculos
    public Obstaculo(String localizacao, String descricao, int nivelDePerigo) {
        this.localizacao = localizacao;
        this.descricao   = descricao;

        // Valida o nível: se vier fora do intervalo, lança exceção
        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            throw new IllegalArgumentException("Nível de perigo deve ser entre 1 e 10.");
        }
        this.nivelDePerigo = nivelDePerigo;
    }

    // --- Getters e Setters ---

    public String getLocalizacao()              { return localizacao; }
    public void   setLocalizacao(String v)      { this.localizacao = v; }

    public String getDescricao()                { return descricao; }
    public void   setDescricao(String v)        { this.descricao = v; }

    public int    getNivelDePerigo()            { return nivelDePerigo; }
    public void   setNivelDePerigo(int v) {
        if (v < 1 || v > 10) {
            throw new IllegalArgumentException("Nível deve ser entre 1 e 10.");
        }
        this.nivelDePerigo = v;
    }

    // Método abstrato: cada subclasse mostra seus próprios detalhes (polimorfismo)
    public abstract void exibirDetalhes();

    // toString — usado no menu para mostrar um resumo do obstáculo
    @Override
    public String toString() {
        return "Local: " + localizacao
             + " | Descrição: " + descricao
             + " | Perigo: " + nivelDePerigo + "/10";
    }
}
