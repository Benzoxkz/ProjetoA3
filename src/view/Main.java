package view;

import model.CalcadaIrregular;
import model.Degrau;
import model.RampaInexistente;
import model.Usuario;
import service.MapaService;

import java.util.Scanner;

/**
 * Classe principal do RotaAcessível.
 * Exibe o menu e lê as opções do usuário.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MapaService mapa = new MapaService();
        Usuario usuarioAtual = new Usuario(1, "Rinat", "rinat@email.com");

        System.out.println("=========================================");
        System.out.println("  Bem-vindo ao RotaAcessível!");
        System.out.println("  Usuário: " + usuarioAtual.getNome());
        System.out.println("=========================================");

        // Dados de exemplo pré-carregados para demonstração
        mapa.adicionarPonto(new Degrau("Rua Augusta, 100", "Degrau na entrada da farmácia", 8, 25.5));
        mapa.adicionarPonto(new CalcadaIrregular("Av. Paulista, 1500", "Buracos na calçada", 6, "Raízes de árvore"));
        mapa.adicionarPonto(new RampaInexistente("Rua Consolação, 50", "Sem guia rebaixada", 10, "Esquina com R. Oscar Freire"));
        System.out.println("3 obstáculos de exemplo carregados.\n");

        int opcao = -1;
        do {
            exibirMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
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
                    System.out.print("Palavra-chave para busca: ");
                    mapa.buscarObstaculo(scanner.nextLine().trim());
                    break;

                case 4:
                    System.out.println("Total de obstáculos: " + mapa.getTotalObstaculos());
                    System.out.print("Número do obstáculo: ");
                    int numAtualizar = lerInteiro(scanner);
                    System.out.print("Novo nível de perigo (1-10): ");
                    int novoNivel = lerInteiro(scanner);
                    mapa.atualizarNivelPerigo(numAtualizar, novoNivel);
                    break;

                case 5:
                    mapa.listarAlertas();
                    System.out.print("Número do obstáculo a remover: ");
                    mapa.removerObstaculo(lerInteiro(scanner));
                    break;

                case 6:
                    mapa.exibirEstatisticas();
                    break;

                case 0:
                    System.out.println("Obrigado por usar o RotaAcessível!");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha entre 0 e 6.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Exibe as opções do menu principal
    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Adicionar obstáculo");
        System.out.println("2. Listar todos");
        System.out.println("3. Buscar por palavra-chave");
        System.out.println("4. Atualizar nível de perigo");
        System.out.println("5. Remover obstáculo");
        System.out.println("6. Estatísticas");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
    }

    // Guia o usuário para cadastrar um novo obstáculo
    private static void adicionarObstaculo(Scanner scanner, MapaService mapa) {
        System.out.println("\n--- Tipo de obstáculo ---");
        System.out.println("1 - Degrau");
        System.out.println("2 - Calçada Irregular");
        System.out.println("3 - Rampa Inexistente");
        System.out.print("Tipo: ");
        int tipo = lerInteiro(scanner);

        System.out.print("Localização (ex: Rua X, número Y): ");
        String local = scanner.nextLine().trim();
        if (local.isEmpty()) {
            System.out.println("Localização não pode ser vazia. Operação cancelada.");
            return;
        }

        System.out.print("Descrição do problema: ");
        String desc = scanner.nextLine().trim();

        System.out.print("Nível de perigo (1-10): ");
        int nivel = lerInteiro(scanner);
        if (nivel < 1 || nivel > 10) {
            System.out.println("Nível inválido. Usando 5.");
            nivel = 5;
        }

        try {
            switch (tipo) {
                case 1:
                    System.out.print("Altura do degrau em cm (0 se não sabe): ");
                    double altura = lerDouble(scanner);
                    if (altura <= 0) {
                        mapa.adicionarPonto(new Degrau(local, desc, nivel));
                    } else {
                        mapa.adicionarPonto(new Degrau(local, desc, nivel, altura));
                    }
                    break;

                case 2:
                    System.out.print("Tipo de irregularidade (ex: buraco, raiz): ");
                    String irreg = scanner.nextLine().trim();
                    if (irreg.isEmpty()) {
                        mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel));
                    } else {
                        mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel, irreg));
                    }
                    break;

                case 3:
                    System.out.print("Ponto onde deveria ter rampa: ");
                    String ponto = scanner.nextLine().trim();
                    if (ponto.isEmpty()) {
                        mapa.adicionarPonto(new RampaInexistente(local, desc, nivel));
                    } else {
                        mapa.adicionarPonto(new RampaInexistente(local, desc, nivel, ponto));
                    }
                    break;

                default:
                    System.out.println("Tipo inválido. Operação cancelada.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    // Lê um inteiro com tratamento de erro
    private static int lerInteiro(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando 0.");
            return 0;
        }
    }

    // Lê um double com tratamento de erro (aceita vírgula ou ponto)
    private static double lerDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando 0.0.");
            return 0.0;
        }
    }
}
