package Practice_7_FirstPart;

public class TestComposite {
    public static void main(String[] args){
        Circle circle = new Circle();
        Square square = new Square();
        Composite composite = new Composite();
        composite.add(circle);
        composite.add(square);
        composite.draw("Purple");
        composite.getChild(0);
        composite.remove(circle);
        composite.getChild(0);
    }
}
