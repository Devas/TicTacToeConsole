package locale;

public class Localization {

    private static Language language;

    // By default use ENG locale
    static {
        setENG();
    }

    public static void setENG() {
        language = new English();
    }

    public static void setPL() {
        language = new Polish();
    }

}
