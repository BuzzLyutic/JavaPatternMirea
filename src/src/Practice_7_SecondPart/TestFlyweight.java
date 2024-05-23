package Practice_7_SecondPart;

public class TestFlyweight {
    public static void main(String[] args) {
        FlyweightFactory characterFactory = new FlyweightFactory();

        Flyweight characterA = characterFactory.getCharacter("Viktor");
        Flyweight characterB = characterFactory.getCharacter("Boris");
        Flyweight characterC = characterFactory.getCharacter("Pavel");

        characterA.display("drawing");
        characterB.display("dancing");
        characterC.display("singing");
    }
}
