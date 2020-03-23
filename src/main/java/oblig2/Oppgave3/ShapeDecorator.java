package oblig2.Oppgave3;

public abstract class ShapeDecorator implements Shape {
    protected Shape outlinedShape;

    public ShapeDecorator(Shape outlinedShape) {
        this.outlinedShape = outlinedShape;
    }

    public void draw() {
        outlinedShape.draw();
    }
}
