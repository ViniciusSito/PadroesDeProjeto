package q5;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DocumentTemplate resume = new DocumentTemplate(
                "Currículo",
                new Style("#222222", "Inter", "logo-resume.png")
        );

        DocumentTemplate resumeForAna = resume.clone();
        resumeForAna.getStyle().setPrimaryColor("#0055AA");
        resumeForAna.getStyle().setFontFamily("Roboto");
        resumeForAna.getStyle().setLogoPath("logo-ana.png");

        System.out.println("Modelo base: " + resume);
        System.out.println("Cópia personalizada: " + resumeForAna);
    }
}


