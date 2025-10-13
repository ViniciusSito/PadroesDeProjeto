package RPG.personagens;

import RPG.Personagem;
import RPG.Arma;
import RPG.armas.EspadaLonga;
import RPG.armas.MachadoDeGuerra;
import RPG.armas.CajadoArcano;
import RPG.armas.MarteloDivino;

public class Paladino extends Personagem {
    private static final int FORCA_BASE = 12;
    private static final int DESTREZA_BASE = 10;
    private static final int INTELIGENCIA_BASE = 12;
    private static final int VIDA_BASE = 100;
    private static final int MANA_BASE = 100;
    private static final double REDUCAO_DANO = 0.15;
    private static final int REGENERACAO_MANA = 5;
    
    public Paladino(String nome) {
        super(nome, FORCA_BASE, DESTREZA_BASE, INTELIGENCIA_BASE, VIDA_BASE, MANA_BASE);
    }
    
    @Override
    protected boolean podeUsarArma(Arma arma) {
        return arma instanceof EspadaLonga || 
               arma instanceof MachadoDeGuerra || 
               arma instanceof CajadoArcano ||
               arma instanceof MarteloDivino;
    }
    
    @Override
    protected int aplicarReducaoDano(int dano) {
        int danoReduzido = (int) (dano * (1 - REDUCAO_DANO));
        if (danoReduzido != dano) {
            System.out.println("Proteção Divina reduz " + (dano - danoReduzido) + " de dano!");
        }
        return danoReduzido;
    }
    
    @Override
    protected void aplicarRegeneracaoMana() {
        int manaAnterior = manaAtual;
        manaAtual = Math.min(manaMaxima, manaAtual + REGENERACAO_MANA);
        int manaRegenerada = manaAtual - manaAnterior;
        if (manaRegenerada > 0) {
            System.out.println("Bênção Divina: +" + manaRegenerada + " mana!");
        }
    }
    
    public void curarDivina() {
        int custoMana = 30;
        int cura = 25;
        
        if (manaAtual >= custoMana) {
            manaAtual -= custoMana;
            vidaAtual = Math.min(vidaMaxima, vidaAtual + cura);
            System.out.println(getNome() + " usa Cura Divina! +" + cura + " de vida!");
        } else {
            System.out.println(getNome() + " não tem mana suficiente para Cura Divina!");
        }
    }
    
    @Override
    public String toString() {
        return "Paladino " + super.toString();
    }
}
