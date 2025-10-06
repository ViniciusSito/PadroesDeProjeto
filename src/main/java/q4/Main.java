package q4;

public class Main {
    public static void main(String[] args) {
        Report base = new BasicReport();
        System.out.println(base.generate());

        Report stats = new StatisticsDecorator(base);
        System.out.println(stats.generate());

        Report charts = new ChartDecorator(stats);
        System.out.println(charts.generate());

        Report pdf = new PdfExportDecorator(charts);
        System.out.println(pdf.generate());
    }
}


