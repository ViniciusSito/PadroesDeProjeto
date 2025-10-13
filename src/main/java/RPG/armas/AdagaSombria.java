package RPG.armas;

import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;
import java.util.Arrays;
import java.util.List;

public class AdagaSombria implements Arma {
    private static final int DANO_BASE = 10;
    private static final int CUSTO_MANA = 10;
    private static final int REQUISITO_DESTREZA = 12;
    private static final double CHANCE_CRITICO_FURTIVO = 0.40;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        boolean desprevenido = alvo.getEfeitosAtivos().isEmpty() && !alvo.isAtordoado();
        
        if (desprevenido) {
            dano *= 3;
            System.out.println("Ataque Furtivo! " + alvo.getNome() + " estava desprevenido!");
        } else if (Math.random() < CHANCE_CRITICO_FURTIVO) {
            dano *= 2;
            System.out.println("Golpe preciso! Crítico!");
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
        return "Adaga Sombria";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getDestreza() >= REQUISITO_DESTREZA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList();
    }
}
