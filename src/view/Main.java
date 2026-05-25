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

        System.out.println("============================================");
        System.out.println("   Bem-vindo ao RotaAcessivel!");
        System.out.println("   Sistema de Mapeamento de Obstaculos");
        System.out.println("   Usuario: " + usuarioAtual.getNome());
        System.out.println("============================================");

        
        mapa.adicionarPonto(new Degrau("Rua Augusta, 100", "Degrau alto na entrada da farmacia", 8, 25.5));
        mapa.adicionarPonto(new CalcadaIrregular("Av. Paulista, 1500", "Buracos na via de pedestres", 6, "Raizes de arvore quebrando o cimento"));
        mapa.adicionarPonto(new RampaInexistente("Rua Consolacao, 50", "Cruzamento sem guia rebaixada", 10, "Esquina com Rua Oscar Freire"));
        System.out.println("3 obstaculos de exemplo carregados.\n");

       
        int opcao = -1;
        do {
            exibirMenu();

         
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida! Digite um numero.");
                continue;
            }

        
            switch (opcao) {

                case 1: 
                    usuarioAtual.registrarObstaculo();
                    adicionarObstaculo(scanner, mapa);
                    break;

                case 2: 
                    mapa.listarAlertas();
                    break;

                case 3: 
                    System.out.print("Digite a palavra-chave para buscar: ");
                    String busca = scanner.nextLine().trim();
                    mapa.buscarObstaculo(busca);
                    break;

                case 4: 
                    System.out.println("Total de obstaculos: " + mapa.getTotalObstaculos());
                    System.out.print("Numero do obstaculo a atualizar: ");
                    int numAtualizar = lerInteiro(scanner);
                    System.out.print("Novo nivel de perigo (1-10): ");
                    int novoNivel = lerInteiro(scanner);
                    mapa.atualizarNivelPerigo(numAtualizar, novoNivel);
                    break;

                case 5: 
                    mapa.listarAlertas();
                    System.out.print("Numero do obstaculo a remover: ");
                    int numRemover = lerInteiro(scanner);
                    mapa.removerObstaculo(numRemover);
                    break;

                case 6: 
                    mapa.exibirEstatisticas();
                    break;

                case 0: 
                    System.out.println("\nObrigado por usar o RotaAcessivel!");
                    System.out.println("Juntos tornamos a cidade mais inclusiva.");
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha entre 0 e 6.");
            }

        } while (opcao != 0);

        scanner.close();
    }

   
    private static void exibirMenu() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1. Adicionar obstaculo");
        System.out.println("2. Listar todos os obstaculos");
        System.out.println("3. Buscar obstaculo por local/descricao");
        System.out.println("4. Atualizar nivel de perigo");
        System.out.println("5. Remover obstaculo");
        System.out.println("6. Ver estatisticas do mapa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

   
    private static void adicionarObstaculo(Scanner scanner, MapaService mapa) {
        System.out.println("\n--- TIPO DE OBSTACULO ---");
        System.out.println("1 - Degrau");
        System.out.println("2 - Calcada Irregular");
        System.out.println("3 - Rampa Inexistente");
        System.out.print("Escolha o tipo: ");

        int tipo = lerInteiro(scanner);

        System.out.print("Localizacao (ex: Rua X, numero Y): ");
        String local = scanner.nextLine().trim();

       
        if (local.isEmpty()) {
            System.out.println("Erro: localizacao nao pode ser vazia. Operacao cancelada.");
            return;
        }

        System.out.print("Descricao do problema: ");
        String desc = scanner.nextLine().trim();

        System.out.print("Nivel de perigo (1-10): ");
        int nivel = lerInteiro(scanner);


        if (nivel < 1 || nivel > 10) {
            System.out.println("Nivel fora do intervalo. Usando valor 5.");
            nivel = 5;
        }

        switch (tipo) {
            case 1:
                System.out.print("Altura do degrau em cm (0 para nao saber): ");
                double altura = lerDouble(scanner);
                if (altura <= 0) {
                    
                    mapa.adicionarPonto(new Degrau(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new Degrau(local, desc, nivel, altura));
                }
                break;

            case 2:
                System.out.print("Tipo de irregularidade (ex: buraco, raiz, piso solto): ");
                String tipoIrreg = scanner.nextLine().trim();
                if (tipoIrreg.isEmpty()) {
                  
                    mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new CalcadaIrregular(local, desc, nivel, tipoIrreg));
                }
                break;

            case 3:
                System.out.print("Ponto exato onde deveria ter rampa: ");
                String pontoRampa = scanner.nextLine().trim();
                if (pontoRampa.isEmpty()) {
               
                    mapa.adicionarPonto(new RampaInexistente(local, desc, nivel));
                } else {
                    mapa.adicionarPonto(new RampaInexistente(local, desc, nivel, pontoRampa));
                }
                break;

            default:
                System.out.println("Tipo invalido. Operacao cancelada.");
        }
    }

    
    private static int lerInteiro(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Usando valor 0.");
            return 0;
        }
    }

  
    private static double lerDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Usando valor 0.0.");
            return 0.0;
        }
    }
}
