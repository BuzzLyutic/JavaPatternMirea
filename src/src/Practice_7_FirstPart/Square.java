package Practice_7_FirstPart;

public class Square implements Component{
    @Override
    public void draw(String color){
        System.out.println("Painting square with color: " + color);
    }
}
