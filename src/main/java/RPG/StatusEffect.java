package RPG;

public class StatusEffect {
    private String nome;
    private int duracao;
    private int danoPorTurno;
    private TipoEfeito tipo;
    
    public enum TipoEfeito {
        SANGRAMENTO,
        QUEIMADURA,
        ATORDOADO,
        OUTRO
    }
    
    public StatusEffect(String nome, int duracao, int danoPorTurno, TipoEfeito tipo) {
        this.nome = nome;
        this.duracao = duracao;
        this.danoPorTurno = danoPorTurno;
        this.tipo = tipo;
    }
    
    public int aplicarEfeito(Personagem alvo) {
        if (duracao <= 0) return 0;
        
        int dano = danoPorTurno;
        duracao--;
        
        if (tipo == TipoEfeito.ATORDOADO) {
            alvo.setAtordoado(true);
            return 0;
        }
        
        return dano;
    }
    
    public boolean isAtivo() {
        return duracao > 0;
    }
    public String getNome() { return nome; }
    public int getDuracao() { return duracao; }
    public int getDanoPorTurno() { return danoPorTurno; }
    public TipoEfeito getTipo() { return tipo; }
    
    @Override
    public String toString() {
        return String.format("%s (%d turnos restantes, %d dano/turno)", 
                           nome, duracao, danoPorTurno);
    }
}
