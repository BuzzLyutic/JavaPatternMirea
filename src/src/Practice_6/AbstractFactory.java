package Practice_6;

// Abstract Factory
interface AbstractFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
    public Button createButton() {
        return new Button1();
    }

    public Checkbox createCheckbox() {
        return new Checkbox1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements AbstractFactory {
    public Button createButton() {
        return new Button2();
    }

    public Checkbox createCheckbox() {
        return new Checkbox2();
    }
}

// Products
interface Button {
    void click();
}

interface Checkbox {
    void check();
}

class Button1 implements Button {
    public void click() {
        System.out.println("Button 1 clicked");
    }
}

class Button2 implements Button {
    public void click() {
        System.out.println("Button 2 clicked");
    }
}

class Checkbox1 implements Checkbox {
    public void check() {
        System.out.println("Checkbox 1 checked");
    }
}

class Checkbox2 implements Checkbox {
    public void check() {
        System.out.println("Checkbox 2 checked");
    }
}