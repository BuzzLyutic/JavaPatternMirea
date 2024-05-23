package Practice_8_FirstPart;

public class TestVisitor {
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Book(20, "00000"),
                new Book(100, "99999"),
                new Fruit(10, 2, "Dragon fruit"),
                new Fruit(5, 5, "Mango")
        };

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(Item[] items) {
        Visitor visitor = new ConcreteVisitor();
        int sum = 0;
        for (Item item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
