package service;

import model.Obstaculo;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável por gerenciar a lista de obstáculos.
 * Aqui ficam todas as operações CRUD: criar, ler, atualizar e remover.
 */
public class MapaService {

    // ArrayList polimórfico: armazena qualquer subclasse de Obstaculo
    private List<Obstaculo> obstaculos = new ArrayList<>();

    // ==================== CREATE ====================

    public void adicionarPonto(Obstaculo o) {
        if (o == null) {
            System.out.println("Erro: obstáculo inválido.");
            return;
        }
        if (o.getLocalizacao() == null || o.getLocalizacao().trim().isEmpty()) {
            System.out.println("Erro: localização não pode ser vazia.");
            return;
        }
        obstaculos.add(o);
        System.out.println("Obstáculo registrado! Total no mapa: " + obstaculos.size());
    }

    // ==================== READ ====================

    public void listarAlertas() {
        if (obstaculos.isEmpty()) {
            System.out.println("Nenhum obstáculo mapeado no momento.");
            return;
        }
        System.out.println("\n===== OBSTÁCULOS MAPEADOS (" + obstaculos.size() + ") =====");
        for (int i = 0; i < obstaculos.size(); i++) {
            System.out.println("[ #" + (i + 1) + " ]");
            obstaculos.get(i).exibirDetalhes(); // polimorfismo: cada tipo exibe do seu jeito
        }
    }

    public void buscarObstaculo(String palavraChave) {
        if (palavraChave == null || palavraChave.trim().isEmpty()) {
            System.out.println("Informe uma palavra-chave.");
            return;
        }

        String chave = palavraChave.toLowerCase();
        List<Obstaculo> encontrados = new ArrayList<>();

        for (Obstaculo o : obstaculos) {
            if (o.getLocalizacao().toLowerCase().contains(chave)
             || o.getDescricao().toLowerCase().contains(chave)) {
                encontrados.add(o);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum resultado para: \"" + palavraChave + "\"");
        } else {
            System.out.println(encontrados.size() + " resultado(s):");
            for (Obstaculo o : encontrados) {
                o.exibirDetalhes();
            }
        }
    }

    // ==================== UPDATE ====================

    public void atualizarNivelPerigo(int numero, int novoNivel) {
        if (numero < 1 || numero > obstaculos.size()) {
            System.out.println("Número inválido. Use entre 1 e " + obstaculos.size() + ".");
            return;
        }
        try {
            Obstaculo o = obstaculos.get(numero - 1);
            int anterior = o.getNivelDePerigo();
            o.setNivelDePerigo(novoNivel); // setter já valida o intervalo
            System.out.println("Nível atualizado: " + anterior + " → " + novoNivel
                             + " | Local: " + o.getLocalizacao());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // ==================== DELETE ====================

    public void removerObstaculo(int numero) {
        if (obstaculos.isEmpty()) {
            System.out.println("Não há obstáculos para remover.");
            return;
        }
        if (numero < 1 || numero > obstaculos.size()) {
            System.out.println("Número inválido. Use entre 1 e " + obstaculos.size() + ".");
            return;
        }
        Obstaculo removido = obstaculos.remove(numero - 1);
        System.out.println("Removido: " + removido.getLocalizacao()
                         + " | Restam: " + obstaculos.size());
    }

    // ==================== UTILITÁRIOS ====================

    public int getTotalObstaculos() {
        return obstaculos.size();
    }

    // Conta obstáculos por faixa de perigo e exibe um resumo
    public void exibirEstatisticas() {
        if (obstaculos.isEmpty()) {
            System.out.println("Sem dados para estatística.");
            return;
        }

        int criticos  = 0;
        int moderados = 0;
        int baixos    = 0;

        for (Obstaculo o : obstaculos) {
            int n = o.getNivelDePerigo();
            if      (n >= 8) criticos++;
            else if (n >= 4) moderados++;
            else             baixos++;
        }

        System.out.println("\n--- ESTATÍSTICAS ---");
        System.out.println("Total      : " + obstaculos.size());
        System.out.println("Críticos   (8-10): " + criticos);
        System.out.println("Moderados  (4-7) : " + moderados);
        System.out.println("Baixos     (1-3) : " + baixos);
        System.out.println("--------------------");
    }
}
