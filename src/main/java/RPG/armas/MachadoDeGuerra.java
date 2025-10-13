package RPG.armas;

import java.util.Arrays;
import java.util.List;
import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;

public class MachadoDeGuerra implements Arma {
    private static final int DANO_BASE = 18;
    private static final int CUSTO_MANA = 5;
    private static final int REQUISITO_FORCA = 15;
    private static final double CHANCE_ATORDOAMENTO = 0.25;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        if (Math.random() < 0.12) {
            dano *= 2;
            System.out.println("Golpe devastador! Crítico!");
        }
        
        if (Math.random() < CHANCE_ATORDOAMENTO) {
            StatusEffect atordoado = new StatusEffect(
                "Atordoado", 
                1, 
                0, 
                StatusEffect.TipoEfeito.ATORDOADO
            );
            alvo.adicionarEfeito(atordoado);
            System.out.println("Golpe Esmagador! " + alvo.getNome() + " está atordoado!");
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
        return "Machado de Guerra";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getForca() >= REQUISITO_FORCA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList(
            new StatusEffect("Atordoado", 1, 0, StatusEffect.TipoEfeito.ATORDOADO)
        );
    }
}
