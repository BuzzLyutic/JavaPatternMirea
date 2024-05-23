package Practice_6.Prototype;


public class ClientPrototype {
    public static void main(String args){
        ConcretePrototype1 firstPrototype = new ConcretePrototype1("First");
        ConcretePrototype2 secondPrototype = new ConcretePrototype2("Second");
        ConcretePrototype1 firstClone = firstPrototype.clone();

    }
}
/*
abstract class Prototype implements Cloneable {
    abstract Prototype clone() throws CloneNotSupportedException;
}

class ConcretePrototype1 extends Prototype {
    private String field;

    public ConcretePrototype1(String field) {
        this.field = field;
    }

    @Override
    Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}

class PrototypeClient {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype1("Default");
        try {
            Prototype clone = prototype.clone2();
            clone.setField("Cloned");
            System.out.println("Original: " + prototype.getField());
            System.out.println("Clone: " + clone.getField());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}*/