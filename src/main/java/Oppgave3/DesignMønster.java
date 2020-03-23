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
        for (int i = 0; i < formListe.size(); i++) {
            formListe[i].draw();
        }
    }
*/

// Observer designmønsteret brukes når det er en en-til-mange relasjon mellom objekter,
// som hvis ett objekt blir endret så blir dets avhengige objekter oppdatert om det umiddelbart.
// I vårt eksempel når det kommer til museklikk vil den da kunne oppdatere tegningen som blir gjort av draw() metoden.


// Oppgave 3.3.3
// Et Composite designmønster blir brukt når du vil selektivt behandle en gruppe med objekter som er en del av et hierarki som om
// de er like, når de i realiteten ikke er like. Som i vårt eksempel kan vi ha masse forskjellige former som er rektangler og sirkler og alt mulig og
// de vil alle bli sett på som ett type objekt.

// I vårt eksempel har vi interfacet "Shape" og to "Leaf" klasser som f.eks Rectangle og Circle.
// Vår Composite klasse vil da være "Drawing" eller noe lignende. Der har vi instansiert List<Shape> shapeList og vi har også add / remove metoder
// for objekter (rektangler eller sirkler) som skal legges til eller fjernes fra listen. Den abstrakte metoden draw() vil se slik ut:

    /*
    public void draw() {
		for(Shape shape : shapeList)
		{
			shape.draw();
		}
	}
     */


// Oppgave 3.3.4
// Dette kan implementeres med designmønsteret Decorator. Vi må først lage en abstrakt Decorator klasse ShapeDecorator
// som implementerer Shape. Den kan du se i klassen ShapeDecorator i denne pakken.

// Etter dette lager vi en konkret klasse som extender ShapeDecorator.

// Sånn vil oppsettet av Decorator klassene være, og så kan vi teste at de fungerer her:

    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape blueCircle = new BlueShapeDecorator(new Circle());

        Shape blueRectangle = new BlueShapeDecorator(new Rectangle());
        System.out.println("Circle with no border:");
        circle.draw();

        System.out.println("\nCircle with blue border:");
        blueCircle.draw();

        System.out.println("\nRectangle with blue border:");
        blueRectangle.draw();

        System.out.println();

        Shape circle2 = new Circle();
        Shape rectangle = new Rectangle();
        Shape rectangle2 = new Rectangle();

        Drawing drawing = new Drawing();
        drawing.add(circle2);
        drawing.add(rectangle);
        drawing.add(rectangle2);
        drawing.add(blueRectangle);

        System.out.println("Commencing drawing of several shapes:");
        drawing.draw();
        drawing.clear();
        System.out.println();


        drawing.add(circle);
        drawing.add(blueCircle);
        System.out.println("Drawing new shapes, circle with no border and circle with blue border:");
        drawing.draw();
    }

}
