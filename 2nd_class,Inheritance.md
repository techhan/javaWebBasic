# 기초 강의 2강

다른 부분은 생략하고 클래스 및 상속 부분만 정리했다.<br/><br/>

## 클래스

1. **Animal.java 생성**<br/>
   ![파일생성](https://user-images.githubusercontent.com/70805241/168438892-66784d2b-324b-4fe5-be81-b04b7bf87dd0.png)<br/><br/>

- Animal.java 파일 생성 후 App.java에서 Animal을 객체로 사용할 수 있게 된다. <br/> ![animal사용](https://user-images.githubusercontent.com/70805241/168438956-82a4bacb-de8a-4928-bea4-c15d179a2b21.png)<br/><br/>

2. **Animal 필드 생성**<br/>

```java
public class Animal {
    public int legCount; //다리 개수

    public Animal() {} // 기본 생성자. 생략 시 컴파일 할 때 자동으로 생성된다.

    public Animal(int legCount) {
        this.legCount = legCount;
    }
}
```

<br/>

**필드**는 클래스의 속성을 의미하며 legCount와 같은 변수로 선언된다.<br/>

**생성자**의 경우는 기본 생성자와, 매개변수를 받을 수 있는 생성자가 존재한다. 생성자는 객체를 생성할 때, 즉 `Animal animal = new Animal();`와 같이 new 연산자를 붙여줄 때 초기값을 지정할 수 있는 용도로 사용된다.<br/> 그리고 매개 변수가 있는 생성자의 경우 `this` 때문에 헷갈릴 수 있는데 this가 붙으면 현재 클래스의 필드를 가리킨다고 생각하면된다. 즉 현재 클래스에 있는 legCount에 매개 변수로 받아온 legCount 값을 대입한다.
<br/><br/>

3. **Animal 사용**<br/>

```java
// App.java
public class App {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal(4);
        System.out.println(animal.legCount);
    }
}
```

매개 변수로 넘겨진 `4` 숫자 덕분에 animal 객체는 4개의 다리를 갖는 동물이 되었다. animal.legCount를 출력하면 4가 출력되어야 한다.<br/> ![다리출력](https://user-images.githubusercontent.com/70805241/168439410-2f39dcb4-c866-43d5-b28e-8cde7d0a2ba0.png)<br/><br/>

4. **getter 생성** <br/>
   Java에서는 클래스의 필드 값을 가져올 경우 객체에 직접적으로 animal.legCount 이렇게 불러오는 것보다 getter라는 메서드를 생성해 값을 간접적으로 가져오는 것이 좋다.

```java
// Animal.java
public int getLegCount() {
    return this.legCount; // 현재 legCount 필드에 저장된 값을 리턴
}

// App.java
public class App {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal(4);
        System.out.println(animal.getLegCount()); // getter 사용
    }
}
```

<br/><br/>

5. **setter 생성** <br/>

```java
// Animal.java
public void setLegCount(int legCount) {
    this.legCount = legCount
}

// App.java
Animal animal = new Animal(4);
System.out.println(animal.getLegCount());

animal.setLegCount(2);
System.out.println(animal.getLegCount());
```

setter의 경우 생성자로 legCount 값을 넣지 않고 따로 메서드를 통해서 Animal 객체의 legCount 필드에 값을 저장하는 방법이다. 반환 타입이 `void`인데 void는 return 값이 없다는 의미이다. <br/> ![setter](https://user-images.githubusercontent.com/70805241/168440843-fa099110-3ac5-4c52-a89d-1830b3e4672b.png)
<br/><br/>

- getter와 setter 메서드의 이름은 굳이 getXXX, setXXX가 아니어도 동작하지만 관례상 getXXX, setXXX로 사용한다.

<br/><br/><br/>

## 상속

1. **Cat.java 파일 생성** <br/>
   ![cat](https://user-images.githubusercontent.com/70805241/168440935-999884cf-9b43-428c-a3ba-e6e8df43bf67.png) <br>
   <br/>

2. **extends로 Animal 상속** <br/>

```java
// Cat.java

public class Cat extends Animal{

}
```

extends 키워드는 현재 Cat의 클래스에 Animal이라는 클래스를 상속받는다는 의미이다. Cat 클래스가 Animal 클래스를 상속받으면 Animal 클래스는 `부모 클래스`가 되고, Cat 클래스는 `자식 클래스`가 된다. 자식은 부모로부터 모든 걸 물려받을 수 있다. 즉 Cat 클래스는 Animal 클래스의 필드 및 메서드를 자유롭게 사용할 수 있다.

```java
// App.java
Cat cat = new Cat();
cat.setLegCount(4);
System.out.println(cat.getLegCount()); // 4 출력
```

<br/>

그럼 Animal은 Cat의 필드나 메서드를 사용할 수 있을까?

```java
// Cat.java
public void grooming() {
    System.out.println("털 정리");
}

// App.java
Animal animal = new Animal();
animal.grooming(); // 에러 발생!
```

자식은 부모의 모든 걸 물려받을 수 있지만 부모는 자식의 모든 걸 물려받을 수 없다.

<br/><br/><br/>

## interface

Cat을 class가 아닌 interface로 변경해보자.

```java
// Cat.java
public interface Cat { // class -> interface 변경

    public void grooming() { // 에러 발생
        System.out.println("털 정리");
    }
}
```

cat을 interface로 변경하면 extends Animal 코드에도 에러가 발생한다. interface는 상속을 받을 수 없고, grooming() 메서드처럼 메서드 블록 안에 명령문을 작성할 수 없다. 즉 `메서드의 정의`만 가능하다.

```java
// Cat.java
public interface Cat { // class -> interface 변경

    public String getColor();
}
```

<br/>

KoreanShortHair.java 클래스를 생성한다.

```java
// KoreanShortHair.java
public class KoreanShortHair implements Cat{ // Cat 구현

    @Override
    public String getColor() {
        // TODO Auto-generated method stub

    }

}
```

`implements` 키워드는 interface를 구현하는 클래스에서 사용되는 예약어이다. Cat interface에는 메서드의 정의만 되어있고 안의 내용은 구현이 되지 않았다. getColor()의 기능을 구현하려면 이렇게 implements 키워드를 통해 클래스에서 구현해야 한다. 여기서 주의 점은 interface에 있는 **모든 메서드를 Override로 구현**해야 한다.

```java
// KoreanShortHair.java
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

// App.java
public static void main(String[] args) throws Exception {
    KoreanShortHair luvy = new KoreanShortHair("치즈");
    System.out.println(luvy.getColor()); // 치즈 출력
}
```

<br/><br/>

연습 겸 다른 고양이 종을 생성해보자.

```java
// Siamese.java
public class Siamese implements Cat{

    @Override
    public String getColor(){
        return "검정하양";
    }
}

// App.java
KoreanShortHair luvy = new KoreanShortHair("치즈");
System.out.println(luvy.getColor()); // 치즈 출력

Siamese huchu = new Siamese();
System.out.println(huchu.getColor()); // 검정하양 출력
```

interface를 이용해 클래스를 구현했을 경우에 객체의 타입을 'KoreanShortHair'나 'Siamese'로 하지 않고, `Cat`으로 해도 오류가 발생하지 않는다. 왜냐면 코숏이나 샴이나 Cat의 구현체이기 때문이다.

```java
Cat luvy = new KoreanShortHair("치즈");
System.out.println(luvy.getColor()); // 치즈 출력
```

<br/><br/>

---

<br/>

# 실습

- 붕어빵과 붕어빵 기계 만들기
- 조건
  - 붕어빵 종류는 팥, 슈크림, 피자 +a
  - 붕어빵 크기는 일반, 미니
  - 붕어빵 담는 봉투

<br/>

1. **붕어빵 class 만들기**

```java
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

```

<br/><br/>

2. **붕어빵 Type과 Size enum class 생성**

```java
// Size.java
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

// Type.java
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
```

<br/><br/>

3. **붕어빵 봉투 만들기**

```java
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
```

<br/><br/>

4. **팥붕 만들기**

```java
package BreadFish;

public class RedBeanBreadFish extends BreadFish{

    public RedBeanBreadFish(Size size) {
        super(size);
        this.type = Type.PUFF;
    }
}
```

<br/><br/>

5. **슈붕 만들기**

```java
package BreadFish;

public class PuffBreadFish extends BreadFish{

    public PuffBreadFish(Size size) {
        super(size);
        this.type = Type.PUFF;
    }
}
```

<br/><br/>

6. **붕어빵 기계 만들기**

```java
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
```

<br/><br/>

7. **붕어빵 주문하기**

```java
// App.java
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
```

<br/>

![붕어빵](https://user-images.githubusercontent.com/70805241/168443699-65ff39cb-1de6-4af4-a635-8e0df7e36557.png)

<br/><br/>

---

너무 어렵다....!!! enum은 처음 써보는 타입이기도 하고 또 이렇게까지 클래스를 세세하게 나눠서 작성해본 적이 별로 없어서 열심히 생각해보다가 강사님이 준 파일들을 보고 실습을 했다. 나름의 리팩토링을 해봤지만 맞는지 아닌지는 분간이 안간다.
