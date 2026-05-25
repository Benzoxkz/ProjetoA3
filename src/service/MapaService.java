package service;

import model.Obstaculo;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável por gerenciar a lista de obstáculos do mapa.
 * Implementa operações CRUD (criar, ler, atualizar, remover).
 */
public class MapaService {

    // Lista que armazena todos os obstáculos registrados (polimorfismo: aceita qualquer subclasse)
    private List<Obstaculo> listaDeObstaculos;

    /**
     * Construtor — inicializa a lista vazia.
     */
    public MapaService() {
        this.listaDeObstaculos = new ArrayList<>();
    }

    // ==================== CREATE ====================

    /**
     * Adiciona um novo obstáculo ao mapa.
     * @param obstaculo Qualquer subclasse de Obstaculo (Degrau, CalcadaIrregular, etc.)
     */
    public void adicionarPonto(Obstaculo obstaculo) {
        // Validação: não permite objetos nulos
        if (obstaculo == null) {
            System.out.println("Erro: nao e possivel adicionar um obstaculo nulo.");
            return;
        }
        // Validação: localização não pode ser vazia
        if (obstaculo.getLocalizacao() == null || obstaculo.getLocalizacao().trim().isEmpty()) {
            System.out.println("Erro: localizacao nao pode ser vazia.");
            return;
        }
        listaDeObstaculos.add(obstaculo);
        System.out.println("Obstaculo registrado com sucesso! Total no mapa: " + listaDeObstaculos.size());
    }

    // ==================== READ ====================

    /**
     * Lista todos os obstáculos registrados no mapa.
     * Usa loop para percorrer a lista e chama exibirDetalhes() de cada um (polimorfismo).
     */
    public void listarAlertas() {
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nenhum obstaculo mapeado no momento.");
            return;
        }
        System.out.println("\n========== OBSTACULOS MAPEADOS (" + listaDeObstaculos.size() + " registros) ==========");
        for (int i = 0; i < listaDeObstaculos.size(); i++) {
            System.out.println("[ #" + (i + 1) + " ]");
            listaDeObstaculos.get(i).exibirDetalhes(); // polimorfismo em ação
        }
    }

    /**
     * Busca obstáculos que contenham uma palavra-chave na localização ou descrição.
     * Usa if/else e loop para filtrar resultados.
     * @param palavraChave Texto a buscar
     */
    public void buscarObstaculo(String palavraChave) {
        // Validação da entrada
        if (palavraChave == null || palavraChave.trim().isEmpty()) {
            System.out.println("Erro: informe uma palavra-chave para a busca.");
            return;
        }

        String chave = palavraChave.toLowerCase();
        List<Obstaculo> resultados = new ArrayList<>();

        // Loop para percorrer a lista e filtrar
        for (Obstaculo obs : listaDeObstaculos) {
            if (obs.getLocalizacao().toLowerCase().contains(chave) ||
                obs.getDescricao().toLowerCase().contains(chave)) {
                resultados.add(obs);
            }
        }

        // Switch-case para exibir o resultado conforme a quantidade encontrada
        switch (resultados.size()) {
            case 0:
                System.out.println("Nenhum obstaculo encontrado para: \"" + palavraChave + "\"");
                break;
            case 1:
                System.out.println("1 obstaculo encontrado:");
                resultados.get(0).exibirDetalhes();
                break;
            default:
                System.out.println(resultados.size() + " obstaculos encontrados:");
                for (Obstaculo obs : resultados) {
                    obs.exibirDetalhes();
                }
        }
    }

    // ==================== UPDATE ====================

    /**
     * Atualiza o nível de perigo de um obstáculo pelo índice da lista (base 1).
     * @param numero Número do obstáculo na lista (começa em 1)
     * @param novoNivel Novo nível de perigo (1-10)
     */
    public void atualizarNivelPerigo(int numero, int novoNivel) {
        // Validação de índice
        if (numero < 1 || numero > listaDeObstaculos.size()) {
            System.out.println("Erro: numero invalido. Informe entre 1 e " + listaDeObstaculos.size() + ".");
            return;
        }
        // Validação do nível
        if (novoNivel < 1 || novoNivel > 10) {
            System.out.println("Erro: nivel de perigo deve ser entre 1 e 10.");
            return;
        }
        Obstaculo obs = listaDeObstaculos.get(numero - 1);
        int nivelAnterior = obs.getNivelDePerigo();
        obs.setNivelDePerigo(novoNivel);
        System.out.println("Nivel atualizado: " + nivelAnterior + " -> " + novoNivel +
                           " | Local: " + obs.getLocalizacao());
    }

    // ==================== DELETE ====================

    /**
     * Remove um obstáculo da lista pelo número (base 1).
     * @param numero Número do obstáculo a remover
     */
    public void removerObstaculo(int numero) {
        // Validação: lista não pode estar vazia
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nao ha obstaculos para remover.");
            return;
        }
        // Validação de índice
        if (numero < 1 || numero > listaDeObstaculos.size()) {
            System.out.println("Erro: numero invalido. Informe entre 1 e " + listaDeObstaculos.size() + ".");
            return;
        }
        Obstaculo removido = listaDeObstaculos.remove(numero - 1);
        System.out.println("Obstaculo removido: " + removido.getLocalizacao() +
                           " | Restam: " + listaDeObstaculos.size() + " registros.");
    }

    // ==================== Utilitários ====================

    /**
     * Retorna o número total de obstáculos cadastrados.
     */
    public int getTotalObstaculos() {
        return listaDeObstaculos.size();
    }

    /**
     * Exibe estatísticas simples — conta obstáculos por nível crítico (>= 7).
     */
    public void exibirEstatisticas() {
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nenhum dado para estatistica.");
            return;
        }
        int criticos = 0;
        int moderados = 0;
        int baixos = 0;

        // Loop para contar por categoria de perigo
        for (Obstaculo obs : listaDeObstaculos) {
            int nivel = obs.getNivelDePerigo();
            if (nivel >= 8) {
                criticos++;
            } else if (nivel >= 4) {
                moderados++;
            } else {
                baixos++;
            }
        }

        System.out.println("\n--- ESTATISTICAS DO MAPA ---");
        System.out.println("Total de obstaculos : " + listaDeObstaculos.size());
        System.out.println("Criticos  (8-10)    : " + criticos);
        System.out.println("Moderados (4-7)     : " + moderados);
        System.out.println("Baixos    (1-3)     : " + baixos);
        System.out.println("----------------------------");
    }
}
