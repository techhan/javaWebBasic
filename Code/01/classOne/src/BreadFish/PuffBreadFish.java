package BreadFish;

public class PuffBreadFish extends BreadFish{

    public PuffBreadFish(Size size) {
        super(size);
        this.type = Type.PUFF;
        ///this.cost = (size == Size.NORMAL ? 800 : 500);
    }
}
