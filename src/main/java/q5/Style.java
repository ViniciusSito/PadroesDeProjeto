package q5;

public class Style implements Cloneable {
    private String primaryColor;
    private String fontFamily;
    private String logoPath;

    public Style(String primaryColor, String fontFamily, String logoPath) {
        this.primaryColor = primaryColor;
        this.fontFamily = fontFamily;
        this.logoPath = logoPath;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public Style clone() throws CloneNotSupportedException {
        return (Style) super.clone();
    }

    @Override
    public String toString() {
        return "Style{" +
                "primaryColor='" + primaryColor + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                ", logoPath='" + logoPath + '\'' +
                '}';
    }
}


