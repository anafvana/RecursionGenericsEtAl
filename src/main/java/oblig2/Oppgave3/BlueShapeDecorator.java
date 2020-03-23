package oblig2.Oppgave3;

public class BlueShapeDecorator extends ShapeDecorator {

    public BlueShapeDecorator(Shape outlinedShape) {
        super(outlinedShape);
    }

    @Override
    public void draw() {
        outlinedShape.draw();
        setBlueBorder(outlinedShape);
    }

    private void setBlueBorder(Shape outlinedShape) {
        System.out.println("Border Color: Blue");
    }
}
