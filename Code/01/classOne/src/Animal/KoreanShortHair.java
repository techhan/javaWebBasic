package Animal;
public class KoreanShortHair implements Cat{

    private String hairColor;

    public KoreanShortHair (String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String getColor() {
        return this.hairColor;
    }
}
