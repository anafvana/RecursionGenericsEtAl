package Oppgave3;

@SuppressWarnings("NonAsciiCharacters")
public class DesignMønster {

// Oppgave 3.3.1
// draw() metoden bør være abstrakt, fordi vi kan da garantere at alle de konkrete klassene faktisk implementerer draw,
// som er en viktig metode i alle tegneklasser. Hvis vi glemmer det i en klasse vil vi får en error som gjør at vi ikke engang kan starte programmet,
// så det blir enkelt å finne feil!

// Oppgave 3.3.2
// Noe som dette, litt usikker på akkurat hva oppgaven spør om.. Den følgende metoden er en veldig generell måte å vise hvordan den abstrakte
// draw() metoden vil bli brukt i den aktuelle tegnemetoden.

/*
    public static void tegnFormer(List<Shape> formListe) {
        for (int i = 0; i < formListe.length; i++) {
            formListe[i].draw();
        }
    }
*/

// Observer designmønsteret brukes når det er en en-til-mange relasjon mellom objekter,
// som hvis ett objekt blir endret så blir dets avhengige objekter oppdatert om det umiddelbart.
// I vårt eksempel når det kommer til museklikk vil den da kunne oppdatere tegningen som blir gjort av draw() metoden.

// Oppgave 3.3.4
// Dette kan implementeres med designmønsteret Decorator. Vi må først lage en abstrakt Decorator klasse som vi kan kalle f.eks ShapeDecorator
// som implementerer Shape. Den kan se f.eks sånn ut:

/*
abstract class ShapeDecorator implements Shape {
    protected Shape outlinedShape;

    public ShapeDecorator(Shape outlinedShape) {
        this.outlinedShape = outlinedShape;
    }

    public void draw() {
        outlinedShape.draw();
    }
}
*/

// Etter dette lager vi en konkret klasse som extender ShapeDecorator.

/*
class BlueShapeDecorator extends ShapeDecorator {
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
*/

// Sånn vil oppsettet av Decorator klassene være

}
