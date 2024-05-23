package Practice_7_FirstPart;
import java.util.List;
import java.util.ArrayList;

public class Composite implements Component{
    private List<Component> shapes = new ArrayList();

    @Override
    public void draw(String color){
        for (Component shape : shapes){
            shape.draw(color);
        }
    }

    public void add(Component shape){
        shapes.add(shape);
    }

    public void remove(Component shape){
        shapes.remove(shape);
    }

    public void getChild(int i){
        shapes.get(i).draw("I GOT CALLED THROUGH GETCHILD METHOD");
    }
}


