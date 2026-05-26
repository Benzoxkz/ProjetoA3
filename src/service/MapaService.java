package service;

import model.Obstaculo;
import java.util.ArrayList;
import java.util.List;

// Essa classe cuida de tudo relacionado à lista de obstáculos:
// adicionar, listar, buscar, atualizar e remover.
public class MapaService {

    private List<Obstaculo> obstaculos = new ArrayList<>();

    // Adiciona um obstáculo na lista
    public void adicionarPonto(Obstaculo o) {
        if (o == null) {
            System.out.println("Obstaculo invalido.");
            return;
        }
        if (o.getLocalizacao() == null || o.getLocalizacao().trim().isEmpty()) {
            System.out.println("Localizacao nao pode ser vazia.");
            return;
        }
        obstaculos.add(o);
        System.out.println("Registrado! Total: " + obstaculos.size() + " obstaculo(s) no mapa.");
    }

    // Mostra todos os obstáculos cadastrados
    public void listarAlertas() {
        if (obstaculos.isEmpty()) {
            System.out.println("Nenhum obstaculo cadastrado ainda.");
            return;
        }
        System.out.println("\n===== " + obstaculos.size() + " OBSTACULO(S) NO MAPA =====");
        for (int i = 0; i < obstaculos.size(); i++) {
            System.out.println("[" + (i + 1) + "]");
            obstaculos.get(i).exibirDetalhes();
        }
    }

    // Busca obstáculos pela localização ou descrição
    public void buscarObstaculo(String palavraChave) {
        if (palavraChave == null || palavraChave.trim().isEmpty()) {
            System.out.println("Digite uma palavra-chave para buscar.");
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
            System.out.println("Nenhum resultado para \"" + palavraChave + "\".");
        } else {
            System.out.println(encontrados.size() + " resultado(s):");
            for (Obstaculo o : encontrados) {
                o.exibirDetalhes();
            }
        }
    }

    // Muda o nível de perigo de um obstáculo pelo número na lista
    public void atualizarNivelPerigo(int numero, int novoNivel) {
        if (numero < 1 || numero > obstaculos.size()) {
            System.out.println("Numero invalido. Escolha entre 1 e " + obstaculos.size() + ".");
            return;
        }
        try {
            Obstaculo o = obstaculos.get(numero - 1);
            int nivelAnterior = o.getNivelDePerigo();
            o.setNivelDePerigo(novoNivel);
            System.out.println("Atualizado: " + nivelAnterior + " -> " + novoNivel + " (" + o.getLocalizacao() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Remove um obstáculo pelo número na lista
    public void removerObstaculo(int numero) {
        if (obstaculos.isEmpty()) {
            System.out.println("Nao ha nada para remover.");
            return;
        }
        if (numero < 1 || numero > obstaculos.size()) {
            System.out.println("Numero invalido. Escolha entre 1 e " + obstaculos.size() + ".");
            return;
        }
        Obstaculo removido = obstaculos.remove(numero - 1);
        System.out.println("Removido: " + removido.getLocalizacao() + ". Restam " + obstaculos.size() + ".");
    }

    public int getTotalObstaculos() {
        return obstaculos.size();
    }

    // Mostra um resumo: quantos são críticos, moderados e de baixo risco
    public void exibirEstatisticas() {
        if (obstaculos.isEmpty()) {
            System.out.println("Sem dados para mostrar.");
            return;
        }

        int criticos = 0;
        int moderados = 0;
        int baixos = 0;

        for (Obstaculo o : obstaculos) {
            int n = o.getNivelDePerigo();
            if (n >= 8) {
                criticos++;
            } else if (n >= 4) {
                moderados++;
            } else {
                baixos++;
            }
        }

        System.out.println("\n--- ESTATISTICAS ---");
        System.out.println("Total     : " + obstaculos.size());
        System.out.println("Criticos  (8-10): " + criticos);
        System.out.println("Moderados (4-7) : " + moderados);
        System.out.println("Baixos    (1-3) : " + baixos);
        System.out.println("--------------------");
    }
}
