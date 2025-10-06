package q5;

/**
 * Prototype de documento. clone() cria nova instância personalizável.
 *
 * Escolha de projeto (Q5): clonar um modelo existente permite criar
 * cópias rápidas e independentes para personalização (cores, fontes,
 * logotipo) sem reconstruir toda a estrutura do documento.
 */
public class DocumentTemplate implements Cloneable {
    private String name;
    private Style style;

    public DocumentTemplate(String name, Style style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public DocumentTemplate clone() throws CloneNotSupportedException {
        DocumentTemplate copy = (DocumentTemplate) super.clone();
        // deep copy do estilo para personalização independente
        copy.style = this.style.clone();
        return copy;
    }

    @Override
    public String toString() {
        return "DocumentTemplate{" +
                "name='" + name + '\'' +
                ", style=" + style +
                '}';
    }
}


