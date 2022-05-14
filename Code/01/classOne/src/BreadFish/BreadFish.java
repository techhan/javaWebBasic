package BreadFish;

public class BreadFish {
    Type type;
    private Size size;
    int cost;

    public BreadFish(Size size) {
        this.size = size;
        setCost(this.size);
    }

    public int getCost() {
        return this.cost;
    }
    
    public void setCost(Size size) {
        int cost = size == Size.NORMAL ? 500 : 300;
        this.cost = cost;
    }
    public String toString() {
        return "종류 [" + type +"], 크기 ["+size+"], 가격 ["+cost+"]";
    }
}
