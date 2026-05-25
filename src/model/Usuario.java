package model;

/**
 * Representa um usuário colaborador do sistema RotaAcessível.
 * Usuários podem registrar e consultar obstáculos no mapa.
 */
public class Usuario {

    // Atributos privados — encapsulamento
    private int id;
    private String nome;
    private String email;

    /**
     * Construtor completo.
     */
    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    /**
     * Construtor sobrecarregado (overload) — cria usuário sem e-mail.
     */
    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.email = "nao informado";
    }

    // ---------- Getters e Setters ----------

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    /**
     * Simula a ação de iniciar um registro de obstáculo.
     */
    public void registrarObstaculo() {
        System.out.println("Usuario " + this.nome + " esta iniciando um novo registro.");
    }

    @Override
    public String toString() {
        return "[ID: " + id + " | Nome: " + nome + " | Email: " + email + "]";
    }
}
