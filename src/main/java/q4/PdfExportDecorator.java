package q4;

public class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(Report inner) {
        super(inner);
    }

    @Override
    public String generate() {
        // Decoração: adiciona exportação sem criar herança múltipla de combinações
        return inner.generate() + " | Exportação: PDF gerado";
    }
}


