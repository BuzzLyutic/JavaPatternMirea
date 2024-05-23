package Practice_8_FirstPart;

public class ConcreteVisitor implements Visitor{
    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        System.out.println("Book ID:" + book.getId() + " cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}
