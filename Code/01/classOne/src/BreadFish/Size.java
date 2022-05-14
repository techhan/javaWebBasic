package BreadFish;

public enum Size {

    NORMAL("일반"),
    MINI("미니");

    private String kr;

    private Size(String kr) {
        this.kr = kr;
    }

    public String toString() {
        return kr;
    }
}
