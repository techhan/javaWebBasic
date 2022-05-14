package BreadFish;

public class RedBeanBreadFish extends BreadFish{

    public RedBeanBreadFish(Size size) {
        super(size);
        this.type = Type.PUFF;
        //this.cost = (size == Size.NORMAL ? 500 : 300);
    }
}