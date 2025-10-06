package q4;

public class StatisticsDecorator extends ReportDecorator {
    public StatisticsDecorator(Report inner) {
        super(inner);
    }

    @Override
    public String generate() {
        // Decoração: acrescenta estatísticas sem modificar o componente base
        return inner.generate() + " | Estatísticas: faturamento total = R$ 12345.67";
    }
}


