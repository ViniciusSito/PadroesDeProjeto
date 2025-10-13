package RPG;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int manaMaxima;
    protected int manaAtual;
    protected Arma armaEquipada;
    protected List<StatusEffect> efeitosAtivos;
    protected boolean atordoado;
    
    public Personagem(String nome, int forca, int destreza, int inteligencia, 
                     int vidaMaxima, int manaMaxima) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaMaxima;
        this.efeitosAtivos = new ArrayList<>();
        this.atordoado = false;
    }
    
    public int atacar(Personagem alvo) {
        if (armaEquipada == null) {
            System.out.println(nome + " não tem arma equipada!");
            return 0;
        }
        
        if (!armaEquipada.podeUsar(this)) {
            System.out.println(nome + " não pode usar " + armaEquipada.getNome() + "!");
            return 0;
        }
        
        if (manaAtual < armaEquipada.getCustoMana()) {
            System.out.println(nome + " não tem mana suficiente para usar " + armaEquipada.getNome() + "!");
            return 0;
        }
        
        // Consome mana
        manaAtual -= armaEquipada.getCustoMana();
        
        // Executa o ataque
        int dano = armaEquipada.atacar(this, alvo);
        
        System.out.println(nome + " ataca " + alvo.getNome() + " com " + 
                          armaEquipada.getNome() + " causando " + dano + " de dano!");
        
        return dano;
    }
    
    public void receberDano(int dano) {
        // Aplica habilidade passiva de redução de dano se houver
        dano = aplicarReducaoDano(dano);
        
        vidaAtual = Math.max(0, vidaAtual - dano);
        System.out.println(nome + " recebe " + dano + " de dano! Vida restante: " + vidaAtual);
    }
    
    public void processarEfeitos() {
        List<StatusEffect> efeitosParaRemover = new ArrayList<>();
        
        for (StatusEffect efeito : efeitosAtivos) {
            int dano = efeito.aplicarEfeito(this);
            if (dano > 0) {
                receberDano(dano);
                System.out.println(nome + " sofre " + dano + " de dano por " + efeito.getNome());
            }
            
            if (!efeito.isAtivo()) {
                efeitosParaRemover.add(efeito);
            }
        }
        
        efeitosAtivos.removeAll(efeitosParaRemover);
        
        // Aplica habilidade passiva de regeneração de mana
        aplicarRegeneracaoMana();
    }
    
    public void adicionarEfeito(StatusEffect efeito) {
        efeitosAtivos.add(efeito);
        System.out.println(nome + " foi afetado por " + efeito.getNome());
    }
    
    public void equiparArma(Arma arma) {
        if (podeUsarArma(arma)) {
            this.armaEquipada = arma;
            System.out.println(nome + " equipou " + arma.getNome());
        } else {
            System.out.println(nome + " não pode usar " + arma.getNome());
        }
    }
    
    protected abstract boolean podeUsarArma(Arma arma);
    
    protected abstract int aplicarReducaoDano(int dano);
    
    protected abstract void aplicarRegeneracaoMana();
    
    public boolean isVivo() {
        return vidaAtual > 0;
    }
    
    public boolean isAtordoado() {
        return atordoado;
    }
    
    public void removerAtordoado() {
        this.atordoado = false;
    }
    
    public String getNome() { return nome; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getInteligencia() { return inteligencia; }
    public int getVidaAtual() { return vidaAtual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getManaAtual() { return manaAtual; }
    public int getManaMaxima() { return manaMaxima; }
    public Arma getArmaEquipada() { return armaEquipada; }
    public List<StatusEffect> getEfeitosAtivos() { return efeitosAtivos; }
    
    public void setAtordoado(boolean atordoado) { this.atordoado = atordoado; }
    
    @Override
    public String toString() {
        return String.format("%s - Vida: %d/%d, Mana: %d/%d, Arma: %s", 
                           nome, vidaAtual, vidaMaxima, manaAtual, manaMaxima,
                           armaEquipada != null ? armaEquipada.getNome() : "Nenhuma");
    }
}
