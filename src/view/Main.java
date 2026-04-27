package view;

import model.CalcadaIrregular;
import model.Degrau;
import model.RampaInexistente;
import model.Usuario;
import service.MapaService;

public class Main {
    public static void main(String[] args) {
        // Inicializando Serviços
        MapaService mapa = new MapaService();

        // Criando Usuário
        Usuario user1 = new Usuario(1, "Rinat", "rinat@email.com");
        System.out.println("Bem-vindo(a), " + user1.getNome() + "!");

        // Cadastrando Obstáculos
        Degrau degrau1 = new Degrau("Rua Augusta, 100", "Degrau alto na entrada da farmacia", 8, 25.5);
        CalcadaIrregular calcada1 = new CalcadaIrregular("Avenida Paulista, 1500", "Buracos na via de pedestres", 6, "Raízes de árvore quebrando o cimento");
        RampaInexistente rampa1 = new RampaInexistente("Rua Consolacao, 50", "Cruzamento sem guia rebaixada", 10, "Esquina com a Rua X");

        // Adicionando ao Mapa
        mapa.adicionarPonto(degrau1);
        mapa.adicionarPonto(calcada1);
        mapa.adicionarPonto(rampa1);

        // Listando tudo (Aplica Polimorfismo)
        mapa.listarAlertas();
    }
}