package Practice_8_FirstPart;

public class Book implements Item {
    private int price;
    private String id;

    public Book(int cost, String id) {
        this.price = cost;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}


