package BreadFish;

public enum Type {
    RED_BEAN("팥"),
    PUFF("슈크림");

    private String kr;
    
    private Type(String kr) {
        this.kr = kr;
    }

    public String toString() {
        return kr;
    }
}
