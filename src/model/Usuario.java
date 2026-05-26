package model;

/**
 * Representa um usuário que colabora registrando obstáculos no sistema.
 */
public class Usuario {

    private int    id;
    private String nome;
    private String email;

    // Construtor completo
    public Usuario(int id, String nome, String email) {
        this.id    = id;
        this.nome  = nome;
        this.email = email;
    }

    // Construtor sobrecarregado (overload): sem e-mail
    public Usuario(int id, String nome) {
        this.id    = id;
        this.nome  = nome;
        this.email = "não informado";
    }

    // --- Getters e Setters ---

    public int    getId()               { return id; }
    public void   setId(int v)          { this.id = v; }

    public String getNome()             { return nome; }
    public void   setNome(String v)     { this.nome = v; }

    public String getEmail()            { return email; }
    public void   setEmail(String v)    { this.email = v; }

    @Override
    public String toString() {
        return "[ID: " + id + " | Nome: " + nome + " | Email: " + email + "]";
    }
}
