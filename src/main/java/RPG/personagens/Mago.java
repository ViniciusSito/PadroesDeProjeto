package RPG.personagens;

import RPG.Personagem;
import RPG.Arma;
import RPG.armas.CajadoArcano;
import RPG.armas.AdagaSombria;

public class Mago extends Personagem {
    private static final int FORCA_BASE = 5;
    private static final int DESTREZA_BASE = 7;
    private static final int INTELIGENCIA_BASE = 18;
    private static final int VIDA_BASE = 70;
    private static final int MANA_BASE = 150;
    private static final int REGENERACAO_MANA = 10;
    
    public Mago(String nome) {
        super(nome, FORCA_BASE, DESTREZA_BASE, INTELIGENCIA_BASE, VIDA_BASE, MANA_BASE);
    }
    
    @Override
    protected boolean podeUsarArma(Arma arma) {
        return arma instanceof CajadoArcano || arma instanceof AdagaSombria;
    }
    
    @Override
    protected int aplicarReducaoDano(int dano) {
        return dano;
    }
    
    @Override
    protected void aplicarRegeneracaoMana() {
        int manaAnterior = manaAtual;
        manaAtual = Math.min(manaMaxima, manaAtual + REGENERACAO_MANA);
        int manaRegenerada = manaAtual - manaAnterior;
        if (manaRegenerada > 0) {
            System.out.println("Regeneração de Mana: +" + manaRegenerada + " mana!");
        }
    }
    
    @Override
    public String toString() {
        return "Mago " + super.toString();
    }
}
