package oblig2.Oppgave3;

import java.util.ArrayList;

public class Drawing implements Shape {

    private ArrayList<Shape> shapeList = new ArrayList<>();

    @Override
    public void draw() {
        for(Shape shape : shapeList)
        {
            shape.draw();
            System.out.println();
        }
    }

    public void add(Shape shape) {
        this.shapeList.add(shape);
    }

    public void remove(Shape shape) {
        shapeList.remove(shape);
    }

    public void clear() {
        System.out.println("All shapes removed from drawing");
        this.shapeList.clear();
    }
}
