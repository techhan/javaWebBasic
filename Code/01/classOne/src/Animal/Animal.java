package Animal;
public class Animal {
    public int legCount; //다리 개수

    public Animal() {} // 기본 생성자. 생략 시 컴파일 할 때 자동으로 생성된다.

    public Animal(int legCount) {
        this.legCount = legCount; 
    }

    public int getLegCount() {
        return this.legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }
}
