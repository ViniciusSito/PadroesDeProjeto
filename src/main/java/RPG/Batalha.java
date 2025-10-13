package RPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import RPG.armas.*;

public class Batalha {
    private List<Personagem> jogadores;
    private List<Personagem> inimigos;
    private int turnoAtual;
    private Scanner scanner;
    
    public Batalha(List<Personagem> jogadores, List<Personagem> inimigos) {
        this.jogadores = new ArrayList<>(jogadores);
        this.inimigos = new ArrayList<>(inimigos);
        this.turnoAtual = 1;
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciarBatalha() {
        System.out.println("=== BATALHA INICIADA ===");
        System.out.println("Jogadores: " + jogadores.size());
        System.out.println("Inimigos: " + inimigos.size());
        System.out.println();
        
        while (!isBatalhaTerminada()) {
            executarTurno();
            turnoAtual++;
        }
        
        anunciarResultado();
    }

    private void executarTurno() {
        System.out.println("=== TURNO " + turnoAtual + " ===");
        
        processarEfeitosStatus();
        
        for (Personagem jogador : jogadores) {
            if (jogador.isVivo() && !jogador.isAtordoado()) {
                executarAcaoJogador(jogador);
            } else if (jogador.isAtordoado()) {
                System.out.println(jogador.getNome() + " está atordoado e perdeu o turno!");
                jogador.removerAtordoado();
            }
        }
        
        for (Personagem inimigo : inimigos) {
            if (inimigo.isVivo() && !inimigo.isAtordoado()) {
                executarAcaoInimigo(inimigo);
            } else if (inimigo.isAtordoado()) {
                System.out.println(inimigo.getNome() + " está atordoado e perdeu o turno!");
                inimigo.removerAtordoado();
            }
        }
        
        System.out.println();
    }
    
    private void processarEfeitosStatus() {
        List<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(jogadores);
        todosPersonagens.addAll(inimigos);
        
        for (Personagem personagem : todosPersonagens) {
            if (personagem.isVivo()) {
                personagem.processarEfeitos();
            }
        }
    }
    
    private void executarAcaoJogador(Personagem jogador) {
        System.out.println("\n--- " + jogador.getNome() + " ---");
        System.out.println(jogador);
        
        if (jogador.getArmaEquipada() == null) {
            System.out.println("Você não tem arma equipada! Escolha uma arma:");
            equiparArma(jogador);
            return;
        }
        
        System.out.println("Escolha sua ação:");
        System.out.println("1. Atacar");
        System.out.println("2. Trocar arma");
        System.out.println("3. Ver status dos inimigos");
        
        int escolha = lerInteiro("Digite sua escolha (1-3): ", 1, 3);
        
        switch (escolha) {
            case 1:
                atacarInimigo(jogador);
                break;
            case 2:
                equiparArma(jogador);
                break;
            case 3:
                mostrarStatusInimigos();
                executarAcaoJogador(jogador);
                break;
        }
    }

    private void executarAcaoInimigo(Personagem inimigo) {
        if (inimigo.getArmaEquipada() == null) {
            // Inimigo sem arma - equipa uma aleatória
            equiparArmaAleatoria(inimigo);
        }
        
        List<Personagem> alvosVivos = jogadores.stream()
            .filter(Personagem::isVivo)
            .toList();
        
        if (!alvosVivos.isEmpty()) {
            Personagem alvo = alvosVivos.get((int) (Math.random() * alvosVivos.size()));
            int dano = inimigo.atacar(alvo);
            alvo.receberDano(dano);
            
            if (inimigo.getArmaEquipada() instanceof ArcoElfico) {
                aplicarAtaqueArea(inimigo, alvosVivos);
            }
        }
    }
    
    private void aplicarAtaqueArea(Personagem atacante, List<Personagem> alvos) {
        System.out.println("Chuva de Flechas atinge todos os inimigos!");
        for (Personagem alvo : alvos) {
            if (alvo != atacante) {
                int danoArea = atacante.getArmaEquipada().getDanoBase() / 2;
                alvo.receberDano(danoArea);
            }
        }
    }

    private void atacarInimigo(Personagem jogador) {
        List<Personagem> inimigosVivos = inimigos.stream()
            .filter(Personagem::isVivo)
            .toList();
        
        if (inimigosVivos.isEmpty()) {
            System.out.println("Não há inimigos vivos para atacar!");
            return;
        }
        
        System.out.println("Escolha um inimigo para atacar:");
        for (int i = 0; i < inimigosVivos.size(); i++) {
            System.out.println((i + 1) + ". " + inimigosVivos.get(i));
        }
        
        int escolha = lerInteiro("Digite o número do inimigo: ", 1, inimigosVivos.size());
        Personagem alvo = inimigosVivos.get(escolha - 1);
        
        int dano = jogador.atacar(alvo);
        alvo.receberDano(dano);
        
        if (jogador.getArmaEquipada() instanceof ArcoElfico) {
            aplicarAtaqueArea(jogador, inimigosVivos);
        }
    }
    
    private void equiparArma(Personagem jogador) {
        List<Arma> armasDisponiveis = criarArmasDisponiveis();
        List<Arma> armasUsaveis = armasDisponiveis.stream()
            .filter(jogador::podeUsarArma)
            .toList();
        
        if (armasUsaveis.isEmpty()) {
            System.out.println("Nenhuma arma disponível para sua classe!");
            return;
        }
        
        System.out.println("Escolha uma arma:");
        for (int i = 0; i < armasUsaveis.size(); i++) {
            Arma arma = armasUsaveis.get(i);
            System.out.println((i + 1) + ". " + arma.getNome() + 
                             " (Dano: " + arma.getDanoBase() + 
                             ", Mana: " + arma.getCustoMana() + ")");
        }
        
        int escolha = lerInteiro("Digite o número da arma: ", 1, armasUsaveis.size());
        jogador.equiparArma(armasUsaveis.get(escolha - 1));
    }
    
    private void equiparArmaAleatoria(Personagem inimigo) {
        List<Arma> armasDisponiveis = criarArmasDisponiveis();
        List<Arma> armasUsaveis = armasDisponiveis.stream()
            .filter(inimigo::podeUsarArma)
            .toList();
        
        if (!armasUsaveis.isEmpty()) {
            Arma armaAleatoria = armasUsaveis.get((int) (Math.random() * armasUsaveis.size()));
            inimigo.equiparArma(armaAleatoria);
        }
    }
    private List<Arma> criarArmasDisponiveis() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new EspadaLonga());
        armas.add(new ArcoElfico());
        armas.add(new CajadoArcano());
        armas.add(new MachadoDeGuerra());
        armas.add(new AdagaSombria());
        return armas;
    }
    private void mostrarStatusInimigos() {
        System.out.println("\n--- STATUS DOS INIMIGOS ---");
        for (Personagem inimigo : inimigos) {
            if (inimigo.isVivo()) {
                System.out.println(inimigo);
            } else {
                System.out.println(inimigo.getNome() + " - MORTO");
            }
        }
        System.out.println();
    }

    private boolean isBatalhaTerminada() {
        boolean jogadoresVivos = jogadores.stream().anyMatch(Personagem::isVivo);
        boolean inimigosVivos = inimigos.stream().anyMatch(Personagem::isVivo);
        
        return !jogadoresVivos || !inimigosVivos;
    }

    private void anunciarResultado() {
        boolean jogadoresVivos = jogadores.stream().anyMatch(Personagem::isVivo);
        
        if (jogadoresVivos) {
            System.out.println("=== VITÓRIA! ===");
            System.out.println("Todos os inimigos foram derrotados!");
        } else {
            System.out.println("=== DERROTA! ===");
            System.out.println("Todos os jogadores foram derrotados!");
        }
    }

    private int lerInteiro(String mensagem, int min, int max) {
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
}
