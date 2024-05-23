package Practice_6;

// Product interface
interface Product {
    void use();
}

// Concrete Product A
class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using product A");
    }
}

// Concrete Product B
class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using product B");
    }
}

// Creator interface
interface Creator {
    Product factoryMethod();
}

// Concrete Creator A
class ConcreteCreatorA implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// Concrete Creator B
class ConcreteCreatorB implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}