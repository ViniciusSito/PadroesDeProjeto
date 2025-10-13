package RPG.armas;

import java.util.Arrays;
import java.util.List;
import RPG.Arma;
import RPG.Personagem;
import RPG.StatusEffect;

public class CajadoArcano implements Arma {
    private static final int DANO_BASE = 8;
    private static final int CUSTO_MANA = 25;
    private static final int REQUISITO_INTELIGENCIA = 12;
    private static final int DANO_QUEIMADURA = 10;
    private static final int DURACAO_QUEIMADURA = 2;
    
    @Override
    public int atacar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        
        if (Math.random() < 0.20) {
            dano *= 2;
            System.out.println("Poder arcano intensificado! Golpe crítico!");
        }
        
        StatusEffect queimadura = new StatusEffect(
            "Queimadura", 
            DURACAO_QUEIMADURA, 
            DANO_QUEIMADURA, 
            StatusEffect.TipoEfeito.QUEIMADURA
        );
        alvo.adicionarEfeito(queimadura);
        System.out.println("Bola de Fogo! " + alvo.getNome() + " está queimando!");
        
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
        return "Cajado Arcano";
    }
    
    @Override
    public boolean podeUsar(Personagem personagem) {
        return personagem.getInteligencia() >= REQUISITO_INTELIGENCIA;
    }
    
    @Override
    public List<StatusEffect> getEfeitosEspeciais() {
        return Arrays.asList(
            new StatusEffect("Queimadura", DURACAO_QUEIMADURA, DANO_QUEIMADURA, 
                           StatusEffect.TipoEfeito.QUEIMADURA)
        );
    }
}
