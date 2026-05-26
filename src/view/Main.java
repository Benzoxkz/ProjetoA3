package view;

import model.CalcadaIrregular;
import model.Degrau;
import model.RampaInexistente;
import model.Usuario;
import service.MapaService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MapaService mapa = new MapaService();
        Usuario usuarioAtual = new Usuario(1, "Rinat", "rinat@email.com");

        System.out.println("===========================================");
        System.out.println("  Bem-vindo ao RotaAcessivel!");
        System.out.println("  Usuario: " + usuarioAtual.getNome());
        System.out.println("===========================================");

        // Alguns exemplos ja carregados para facilitar a demonstracao
        mapa.adicionarPonto(new Degrau("Rua Augusta, 100", "Degrau na entrada da farmacia", 8, 25.5));
        mapa.adicionarPonto(new CalcadaIrregular("Av. Paulista, 1500", "Buracos na calcada", 6, "Raizes de arvore"));
        mapa.adicionarPonto(new RampaInexistente("Rua Consolacao, 50", "Sem guia rebaixada", 10, "Esquina com R. Oscar Freire"));
        System.out.println("3 obstaculos de exemplo carregados.\n");

        int opcao = -1;

        do {
            exibirMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarObstaculo(scanner, mapa);
                    break;
                case 2:
                    mapa.listarAlertas();
                    break;
                case 3:
                    System.out.print("Palavra-chave: ");
                    mapa.buscarObstaculo(scanner.nextLine().trim());
                    break;
                case 4:
                    System.out.println("Total de obstaculos: " + mapa.getTotalObstaculos());
                    System.out.print("Qual o numero do obstaculo? ");
                    int numAtualizar = lerInteiro(scanner);
                    System.out.print("Novo nivel de perigo (1-10): ");
                    int novoNivel = lerInteiro(scanner);
                    mapa.atualizarNivelPerigo(numAtualizar, novoNivel);
                    break;
                case 5:
                    mapa.listarAlertas();
                    System.out.print("Qual o numero do obstaculo a remover? ");
                    mapa.removerObstaculo(lerInteiro(scanner));
                    break;
                case 6:
                    mapa.exibirEstatisticas();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o RotaAcessivel!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente de novo.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Adicionar obstaculo");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Buscar por palavra-chave");
        System.out.println("4 - Atualizar nivel de perigo");
        System.out.println("5 - Remover obstaculo");
        System.out.println("6 - Ver estatisticas");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");
    }

    private static void adicionarObstaculo(Scanner scanner, MapaService mapa) {
        System.out.println("\nTipo de obstaculo:");
        System.out.println("1 - Degrau");
        System.out.println("2 - Calcada Irregular");
        System.out.println("3 - Rampa Inexistente");
        System.out.print("Tipo: ");
        int tipo = lerInteiro(scanner);

        System.out.print("Localizacao: ");
        String local = scanner.nextLine().trim();
        if (local.isEmpty()) {
            System.out.println("Localizacao nao pode ser vazia. Cancelado.");
            return;
        }

        System.out.print("Descricao do problema: ");
        String desc = scanner.nextLine().trim();

        System.out.print("Nivel de perigo (1-10): ");
        int nivel = lerInteiro(scanner);
        if (nivel < 1 || nivel > 10) {
            System.out.println("Nivel invalido, usando 5.");
            nivel = 5;
        }

        try {
            if (tipo == 1) {
                System.out.print("Altura em cm (0 se nao sabe): ");
                double altura = lerDouble(scanner);
                if (altura <= 0) {
                    mapa.adicionarPonto(new Degrau(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new Degrau(local, desc, nivel, altura));
                }

            } else if (tipo == 2) {
                System.out.print("Tipo de irregularidade (ex: buraco, raiz): ");
                String irreg = scanner.nextLine().trim();
                if (irreg.isEmpty()) {
                    mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel, irreg));
                }

            } else if (tipo == 3) {
                System.out.print("Onde deveria ter a rampa: ");
                String ponto = scanner.nextLine().trim();
                if (ponto.isEmpty()) {
                    mapa.adicionarPonto(new RampaInexistente(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new RampaInexistente(local, desc, nivel, ponto));
                }

            } else {
                System.out.println("Tipo invalido. Cancelado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Nao foi possivel cadastrar: " + e.getMessage());
        }
    }

    private static int lerInteiro(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido, usando 0.");
            return 0;
        }
    }

    private static double lerDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido, usando 0.");
            return 0.0;
        }
    }
}
