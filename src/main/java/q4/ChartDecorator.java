package q4;

public class ChartDecorator extends ReportDecorator {
    public ChartDecorator(Report inner) {
        super(inner);
    }

    @Override
    public String generate() {
        // Decoração: acrescenta gráficos sem alterar `BasicReport`
        return inner.generate() + " | Gráficos: barras e pizza";
    }
}


