package BreadFish;

import java.util.ArrayList;
import java.util.List;

public class BreadBag {

    private List<BreadFish> breadFishs = new ArrayList<>();

    public void addBreadFish(BreadFish fish) {
        this.breadFishs.add(fish);
    }

    public BreadFish getFish() {
        return this.breadFishs.remove(0);
    }

    public void showFishList(){
        System.out.println("가방 안에 " + breadFishs.size() + "개의 붕어빵이 들어있습니다.");
        for(BreadFish fish : breadFishs) {
            System.out.println(fish);
        }
    }

    public int getAmount() {
        int amount = 0;
        for(BreadFish fish : breadFishs) {
            amount += fish.getCost();
        }

        return amount;
    }
}
