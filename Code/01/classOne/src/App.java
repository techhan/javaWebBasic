import Animal.Cat;
import Animal.KoreanShortHair;
import Animal.Siamese;
import BreadFish.BreadBag;
import BreadFish.BreadFishMachine;
import BreadFish.Size;
import BreadFish.Type;

public class App {
    public static void main(String[] args) throws Exception {

        BreadFishMachine machine = new BreadFishMachine();

        machine.showMenu();

        machine.order(Type.PUFF, Size.MINI, 2);
        machine.order(Type.RED_BEAN, Size.NORMAL, 5);

        machine.showAmount();

        BreadBag bag = machine.finishOrder(5000);

        bag.showFishList();
    }
}
