package model;


public abstract class Obstaculo {


    private String localizacao;
    private String descricao;
    private int nivelDePerigo; 

 
    public Obstaculo(String localizacao, String descricao, int nivelDePerigo) {
        this.localizacao = localizacao;
        this.descricao = descricao;
      
        if (nivelDePerigo < 1 || nivelDePerigo > 10) {
            System.out.println("Aviso: nivel de perigo deve ser entre 1 e 10. Valor ajustado para 1.");
            this.nivelDePerigo = 1;
        } else {
            this.nivelDePerigo = nivelDePerigo;
        }
    }


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

  
    public abstract void exibirDetalhes();

    
    public abstract void validarPosicao();

    
    @Override
    public String toString() {
        return "Local: " + localizacao +
               " | Descricao: " + descricao +
               " | Perigo (1-10): " + nivelDePerigo;
    }
}
