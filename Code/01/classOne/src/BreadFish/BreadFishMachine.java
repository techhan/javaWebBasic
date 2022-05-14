package BreadFish;

public class BreadFishMachine {
    private int money;
    private BreadBag bag;

    private boolean needNewBag = true;

    public void showMoney() {
        System.out.println("오늘은 " + money + "원 벌었습니다.");
    }

    public void showMenu() {
        System.out.println("==== 메뉴 ====");
        for(Type type : Type.values()) {
            for(Size size : Size.values()) {
                System.out.println(makeBreadFish(type, size));
            }
        }
    }

    private BreadFish makeBreadFish(Type type, Size size) {
        if(type == Type.RED_BEAN) {
            return new RedBeanBreadFish(size);
        }
        return new PuffBreadFish(size);
    }

    public void order(Type type, Size size, int count) {
        if(needNewBag) {
            bag = new BreadBag();
            needNewBag = false;
        }
        for(int i = 0; i < count; i++) {
            bag.addBreadFish(makeBreadFish(type, size));
        }
    }

    public void showAmount() {
        System.out.println("총 " + bag.getAmount() + "원 입니다.");
    }

    public BreadBag finishOrder(int money) {
        final int amount = bag.getAmount();
        System.out.println(money + "원 받았습니다.");
        if (money < amount) {
            System.out.println("돈이 부족합니다");
            return null;
        } else if (money > amount) {
            System.out.println((money - amount) + "원 거슬러 드렸습니다.");
        }
        needNewBag = true;
        return bag;
    }
}
