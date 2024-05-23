package Practice_7_SecondPart;

public class ConcreteFlyweight implements Flyweight{
    private String name;
    public ConcreteFlyweight(String name){
        this.name = name;
    }

    @Override
    public void display(String feature) {
        System.out.println("Entity: " + name + " feature: " + feature);
    }
}
