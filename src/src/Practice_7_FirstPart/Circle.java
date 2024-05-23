package Practice_7_FirstPart;

public class Circle implements Component{
    @Override
    public void draw(String color){
        System.out.println("Painting circle with color: " + color);
    }
}
