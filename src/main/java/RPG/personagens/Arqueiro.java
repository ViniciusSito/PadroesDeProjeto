package RPG.personagens;

import RPG.Personagem;
import RPG.Arma;
import RPG.armas.ArcoElfico;
import RPG.armas.AdagaSombria;

public class Arqueiro extends Personagem {
    private static final int FORCA_BASE = 8;
    private static final int DESTREZA_BASE = 15;
    private static final int INTELIGENCIA_BASE = 7;
    private static final int VIDA_BASE = 90;
    private static final int MANA_BASE = 80;
    private static final double CHANCE_ESQUIVA = 0.25;
    
    public Arqueiro(String nome) {
        super(nome, FORCA_BASE, DESTREZA_BASE, INTELIGENCIA_BASE, VIDA_BASE, MANA_BASE);
    }
    
    @Override
    protected boolean podeUsarArma(Arma arma) {
        return arma instanceof ArcoElfico || arma instanceof AdagaSombria;
    }
    
    @Override
    protected int aplicarReducaoDano(int dano) {
        if (Math.random() < CHANCE_ESQUIVA) {
            System.out.println("Esquiva! " + getNome() + " evitou o ataque!");
            return 0;
        }
        return dano;
    }
    
    @Override
    protected void aplicarRegeneracaoMana() {
    }
    
    @Override
    public String toString() {
        return "Arqueiro " + super.toString();
    }
}
