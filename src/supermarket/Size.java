package supermarket;
// TODO 衣服尺寸
public enum Size {

    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("RL")
    ;

    private String abbreviation;

    Size(String abbreviation) {this.abbreviation=abbreviation;}

    public String getAbbreviation() {
        return abbreviation;
    }
}
