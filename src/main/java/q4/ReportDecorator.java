package q4;

public abstract class ReportDecorator implements Report {
    protected final Report inner;

    protected ReportDecorator(Report inner) {
        this.inner = inner;
    }
}


