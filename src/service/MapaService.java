package service;

import model.Obstaculo;
import java.util.ArrayList;
import java.util.List;

public class MapaService {


    private List<Obstaculo> listaDeObstaculos;

    public MapaService() {
        this.listaDeObstaculos = new ArrayList<>();
    }

 
    public void adicionarPonto(Obstaculo obstaculo) {
   
        if (obstaculo == null) {
            System.out.println("Erro: nao e possivel adicionar um obstaculo nulo.");
            return;
        }
   
        if (obstaculo.getLocalizacao() == null || obstaculo.getLocalizacao().trim().isEmpty()) {
            System.out.println("Erro: localizacao nao pode ser vazia.");
            return;
        }
        listaDeObstaculos.add(obstaculo);
        System.out.println("Obstaculo registrado com sucesso! Total no mapa: " + listaDeObstaculos.size());
    }

  
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

    public void buscarObstaculo(String palavraChave) {
  
        if (palavraChave == null || palavraChave.trim().isEmpty()) {
            System.out.println("Erro: informe uma palavra-chave para a busca.");
            return;
        }

        String chave = palavraChave.toLowerCase();
        List<Obstaculo> resultados = new ArrayList<>();


        for (Obstaculo obs : listaDeObstaculos) {
            if (obs.getLocalizacao().toLowerCase().contains(chave) ||
                obs.getDescricao().toLowerCase().contains(chave)) {
                resultados.add(obs);
            }
        }

        
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


    public void atualizarNivelPerigo(int numero, int novoNivel) {

        if (numero < 1 || numero > listaDeObstaculos.size()) {
            System.out.println("Erro: numero invalido. Informe entre 1 e " + listaDeObstaculos.size() + ".");
            return;
        }

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

   
    public void removerObstaculo(int numero) {
   
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nao ha obstaculos para remover.");
            return;
        }
   
        if (numero < 1 || numero > listaDeObstaculos.size()) {
            System.out.println("Erro: numero invalido. Informe entre 1 e " + listaDeObstaculos.size() + ".");
            return;
        }
        Obstaculo removido = listaDeObstaculos.remove(numero - 1);
        System.out.println("Obstaculo removido: " + removido.getLocalizacao() +
                           " | Restam: " + listaDeObstaculos.size() + " registros.");
    }

   
    public int getTotalObstaculos() {
        return listaDeObstaculos.size();
    }


    public void exibirEstatisticas() {
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nenhum dado para estatistica.");
            return;
        }
        int criticos = 0;
        int moderados = 0;
        int baixos = 0;

     
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
