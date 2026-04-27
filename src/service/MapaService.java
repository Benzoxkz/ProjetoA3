package service;

import model.Obstaculo;
import java.util.ArrayList;
import java.util.List;

public class MapaService {
    // Uso de ArrayList como exigido
    private List<Obstaculo> listaDeObstaculos;

    public MapaService() {
        this.listaDeObstaculos = new ArrayList<>();
    }

    public void adicionarPonto(Obstaculo obstaculo) {
        listaDeObstaculos.add(obstaculo);
        System.out.println("Novo obstaculo registrado com sucesso!");
    }

    public void listarAlertas() {
        if (listaDeObstaculos.isEmpty()) {
            System.out.println("Nenhum obstaculo mapeado no momento.");
            return;
        }
        
        System.out.println("\n--- LISTA DE OBSTACULOS MAPEADOS ---");
        for (Obstaculo obs : listaDeObstaculos) {
            obs.exibirDetalhes();
            System.out.println("------------------------------------");
        }
    }
}