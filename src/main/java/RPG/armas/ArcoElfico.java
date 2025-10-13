package RPG.armas;

import java.util.Arrays;
import java.util.List;
import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;

public class ArcoElfico implements Arma {
    private static final int DANO_BASE = 12;
    private static final int CUSTO_MANA = 15;
    private static final int REQUISITO_DESTREZA = 8;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        if (Math.random() < 0.15) {
            dano *= 2;
            System.out.println("Flecha precisa! Golpe crítico!");
        }
        
        System.out.println("Chuva de Flechas! Ataque em área!");
        
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
        return "Arco Élfico";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getDestreza() >= REQUISITO_DESTREZA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList();
    }
    
    public boolean temAtaqueArea() {
        return true;
    }
}
