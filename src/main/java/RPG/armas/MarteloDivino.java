package RPG.armas;

import java.util.Arrays;
import java.util.List;
import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;

public class MarteloDivino implements Arma {
    private static final int DANO_BASE = 16;
    private static final int CUSTO_MANA = 20;
    private static final int REQUISITO_FORCA = 12;
    private static final int REQUISITO_INTELIGENCIA = 10;
    private static final double CHANCE_CRITICO_DIVINO = 0.15;
    private static final int DANO_SAGRADO = 8;
    private static final int DURACAO_SAGRADO = 2;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        if (Math.random() < CHANCE_CRITICO_DIVINO) {
            dano *= 2;
            System.out.println("Poder divino despertado! Crítico sagrado!");
        }
        
        StatusEffect danoSagrado = new StatusEffect(
            "Dano Sagrado", 
            DURACAO_SAGRADO, 
            DANO_SAGRADO, 
            StatusEffect.TipoEfeito.OUTRO
        );
        alvo.adicionarEfeito(danoSagrado);
        System.out.println("Golpe Sagrado! " + alvo.getNome() + " foi abençoado com poder divino!");
        
        return dano;
    }
    
    @Override
    public int getDanoBase() {
        return DANO_BASE;
    }
    
    @Override
    public int getCustoMana() {
        return CUSTO_MANA;
    }
    
    @Override
    public String getNome() {
        return "Martelo Divino";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getForca() >= REQUISITO_FORCA || 
               personagem.getInteligencia() >= REQUISITO_INTELIGENCIA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList(
            new StatusEffect("Dano Sagrado", DURACAO_SAGRADO, DANO_SAGRADO, 
                           StatusEffect.TipoEfeito.OUTRO)
        );
    }
}
