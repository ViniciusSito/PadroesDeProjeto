package RPG;

import java.util.List;

public interface Arma {

    int atacar(Personagem atacante, Personagem alvo);

    int getDanoBase();
    
    int getCustoMana();

    String getNome();

    boolean podeUsar(Personagem personagem);

    List<StatusEffect> getEfeitosEspeciais();
}
