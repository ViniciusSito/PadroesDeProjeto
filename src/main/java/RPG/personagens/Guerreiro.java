package RPG.personagens;

import RPG.Personagem;
import RPG.Arma;
import RPG.armas.EspadaLonga;
import RPG.armas.MachadoDeGuerra;

public class Guerreiro extends Personagem {
    private static final int FORCA_BASE = 15;
    private static final int DESTREZA_BASE = 8;
    private static final int INTELIGENCIA_BASE = 5;
    private static final int VIDA_BASE = 120;
    private static final int MANA_BASE = 50;
    private static final double REDUCAO_DANO = 0.20;
    
    public Guerreiro(String nome) {
        super(nome, FORCA_BASE, DESTREZA_BASE, INTELIGENCIA_BASE, VIDA_BASE, MANA_BASE);
    }
    
    @Override
    protected boolean podeUsarArma(Arma arma) {
        return arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra;
    }
    
    @Override
    protected int aplicarReducaoDano(int dano) {
        int danoReduzido = (int) (dano * (1 - REDUCAO_DANO));
        if (danoReduzido != dano) {
            System.out.println("Pele Dura reduz " + (dano - danoReduzido) + " de dano!");
        }
        return danoReduzido;
    }
    
    @Override
    protected void aplicarRegeneracaoMana() {
    }
    
    @Override
    public String toString() {
        return "Guerreiro " + super.toString();
    }
}
