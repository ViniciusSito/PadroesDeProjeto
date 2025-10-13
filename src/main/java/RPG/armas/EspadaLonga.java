package RPG.armas;

import java.util.Arrays;
import java.util.List;
import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;

public class EspadaLonga implements Arma {
    private static final int DANO_BASE = 15;
    private static final int CUSTO_MANA = 0;
    private static final int REQUISITO_FORCA = 10;
    private static final double CHANCE_SANGRAMENTO = 0.30;
    private static final int DANO_SANGRAMENTO = 5;
    private static final int DURACAO_SANGRAMENTO = 3;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        if (Math.random() < 0.10) {
            dano *= 2;
            System.out.println("Golpe crítico!");
        }
        
        if (Math.random() < CHANCE_SANGRAMENTO) {
            StatusEffect sangramento = new StatusEffect(
                "Sangramento", 
                DURACAO_SANGRAMENTO, 
                DANO_SANGRAMENTO, 
                StatusEffect.TipoEfeito.SANGRAMENTO
            );
            alvo.adicionarEfeito(sangramento);
            System.out.println("Corte Profundo! " + alvo.getNome() + " está sangrando!");
        }
        
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
        return "Espada Longa";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getForca() >= REQUISITO_FORCA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList(
            new StatusEffect("Sangramento", DURACAO_SANGRAMENTO, DANO_SANGRAMENTO, 
                           StatusEffect.TipoEfeito.SANGRAMENTO)
        );
    }
}
