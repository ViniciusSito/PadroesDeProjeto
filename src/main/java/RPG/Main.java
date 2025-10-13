package RPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import RPG.armas.*;
import RPG.personagens.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE COMBATE RPG ===");
        System.out.println("Bem-vindo ao sistema de combate medieval!");
        System.out.println();
        
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int escolha = lerInteiro("Digite sua escolha: ", 1, 4);
            
            switch (escolha) {
                case 1:
                    demonstrarArmas();
                    break;
                case 2:
                    demonstrarPersonagens();
                    break;
                case 3:
                    iniciarBatalhaPersonalizada();
                    break;
                case 4:
                    continuar = false;
                    break;
            }
        }
        
        System.out.println("Obrigado por usar o sistema de combate RPG!");
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Demonstrar armas e efeitos");
        System.out.println("2. Demonstrar personagens");
        System.out.println("3. Iniciar batalha personalizada");
        System.out.println("4. Sair");
        System.out.println();
    }
    
    private static void demonstrarArmas() {
        System.out.println("\n=== ARMAS DISPONÍVEIS ===");
        
        List<Arma> armas = criarTodasArmas();
        
        for (Arma arma : armas) {
            System.out.println("\n" + arma.getNome() + ":");
            System.out.println("  Dano Base: " + arma.getDanoBase());
            System.out.println("  Custo Mana: " + arma.getCustoMana());
            System.out.println("  Efeitos Especiais: " + arma.getEfeitosEspeciais().size());
            
            for (StatusEffect efeito : arma.getEfeitosEspeciais()) {
                System.out.println("    - " + efeito);
            }
        }
        
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void demonstrarPersonagens() {
        System.out.println("\n=== PERSONAGENS DISPONÍVEIS ===");
        
        // Cria um personagem de cada classe
        Guerreiro guerreiro = new Guerreiro("Conan");
        Arqueiro arqueiro = new Arqueiro("Legolas");
        Mago mago = new Mago("Gandalf");
        Paladino paladino = new Paladino("Tirion");
        
        List<Personagem> personagens = List.of(guerreiro, arqueiro, mago, paladino);
        
        for (Personagem personagem : personagens) {
            System.out.println("\n" + personagem);
            System.out.println("  Atributos: Força=" + personagem.getForca() + 
                             ", Destreza=" + personagem.getDestreza() + 
                             ", Inteligência=" + personagem.getInteligencia());
            
            // Mostra armas que pode usar
            List<Arma> armas = criarTodasArmas();
            System.out.println("  Pode usar:");
            for (Arma arma : armas) {
                if (personagem.podeUsarArma(arma)) {
                    System.out.println("    - " + arma.getNome());
                }
            }
        }
        
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void iniciarBatalhaPersonalizada() {
        System.out.println("\n=== BATALHA PERSONALIZADA ===");
        
        // Cria jogadores
        List<Personagem> jogadores = criarJogadores();
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador criado. Voltando ao menu...");
            return;
        }
        
        // Cria inimigos
        List<Personagem> inimigos = criarInimigos();
        
        // Inicia a batalha
        Batalha batalha = new Batalha(jogadores, inimigos);
        batalha.iniciarBatalha();
        
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static List<Personagem> criarJogadores() {
        List<Personagem> jogadores = new ArrayList<>();
        
        System.out.println("Quantos jogadores deseja criar? (1-3)");
        int quantidade = lerInteiro("Digite a quantidade: ", 1, 3);
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Jogador " + (i + 1) + " ---");
            Personagem jogador = criarPersonagem();
            if (jogador != null) {
                jogadores.add(jogador);
            }
        }
        
        return jogadores;
    }
    
    private static Personagem criarPersonagem() {
        System.out.println("Escolha a classe:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Arqueiro");
        System.out.println("3. Mago");
        System.out.println("4. Paladino");
        
        int escolha = lerInteiro("Digite a classe (1-4): ", 1, 4);
        String nome = lerString("Digite o nome do personagem: ");
        
        return switch (escolha) {
            case 1 -> new Guerreiro(nome);
            case 2 -> new Arqueiro(nome);
            case 3 -> new Mago(nome);
            case 4 -> new Paladino(nome);
            default -> null;
        };
    }
    
    private static List<Personagem> criarInimigos() {
        List<Personagem> inimigos = new ArrayList<>();
        
        // Cria inimigos de diferentes classes
        inimigos.add(new Guerreiro("Orc Guerreiro"));
        inimigos.add(new Arqueiro("Elfo Sombrio"));
        inimigos.add(new Mago("Lich"));
        
        // Equipa armas aleatórias
        List<Arma> armas = criarTodasArmas();
        for (Personagem inimigo : inimigos) {
            List<Arma> armasUsaveis = armas.stream()
                .filter(inimigo::podeUsarArma)
                .toList();
            
            if (!armasUsaveis.isEmpty()) {
                Arma armaAleatoria = armasUsaveis.get((int) (Math.random() * armasUsaveis.size()));
                inimigo.equiparArma(armaAleatoria);
            }
        }
        
        System.out.println("Inimigos criados:");
        for (Personagem inimigo : inimigos) {
            System.out.println("  " + inimigo);
        }
        
        return inimigos;
    }
    
    private static List<Arma> criarTodasArmas() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new EspadaLonga());
        armas.add(new ArcoElfico());
        armas.add(new CajadoArcano());
        armas.add(new MachadoDeGuerra());
        armas.add(new AdagaSombria());
        armas.add(new MarteloDivino());
        return armas;
    }
    
    private static int lerInteiro(String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                valor = -1;
            }
        } while (valor < min || valor > max);
        return valor;
    }
    
    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
