# DATA1600-Oblig2
Obligatory assignment 2 for subject DATA1600 - Programutvikling.

## 1 Rekursjon
### 1.1

Konverter følgende metode til en løsning med rekursjon:

```
static int sum(int x) {
    int sum = 0;
    for(int i = x; i > 0; i--) {
        sum = sum + i;
    }

    return sum;
}
```

### 1.2

Implementer metoden pow(int base, int exponent), som skal kalkulere baseexponent. Bruk rekursjon.

Du kan ta i bruk følgende relasjon:

`baseexponent = base * baseexponent-1`

og:

`base1 = base`

### 1.3

Implementer en metode som skriver ut verdiene i en tabell (`int[] array`) baklengs. Bruk rekursjon.

### 1.4

Implementer en metode som finner den minste verdien i en heltallstabell (`int[] array`). Bruk rekursjon.

### 1.5

Implementer en metode som søker etter et gitt heltall i en heltallstabell (`int[] array`). Bruk rekursjon. Returner posisjonen til verdien i tabellen eller -1 hvis verdien ikke er i tabellen.

## 2 Generisk programmering
### 2.1

Implementer en generisk metode som skriver ut en array til konsollen. Metoden skal støtte forskjellige typer arrayer (som `Integer[]`, `Double[]` osv.).

### 2.2

Implementer en generisk metode som reverserer en input array (ikke bruk `ArrayList` eller liknende). Metoden skal støtte arrayer av ulike typer. Skriv ut innholdet i arrayen før og etter operasjonen ved å bruke løsningen fra 2.1.

### 2.3

Implementer en enkel versjon av `ArrayList<E>`. Den skal støtte et forhåndsdefinert maksimalt antall objekter. Listen skal være statisk og ikke dynamisk, noe som betyr at du ikke trenger å slette objekter som er lagt til listen og listen må ikke kunne utvides utover maks antall elementer. Klassen skal tilby følgende metoder:

- `boolean add(E elem)` metode for å legge til et element til listen. Hvis listen er full, skal metoden returnere `false`. Hvis ikke, skal den returnere `true`.
- `E get(int index)` som returnerer elementet i listen ved gitt index. Hvis index er negativ eller større enn antall eksisterende elementer i listen, skal et avvik at typen `IndexOutOfBoundsException` kastes.
- `int size()` som returnerer hvor mange elementer som er plassert i listen.

For å oppnå dette, kan du bruke en hjelpeklasse i Java Collections som heter `AbstractList`. Du kan lese dens dokumentasjon her:

https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/AbstractList.html 

ArrayList arver blant annet fra denne klassen.


## 3 Designmønstre
### 3.1

Beskriv et problem som passer for designmønsteret State og et problem som passer for Strategy.

### 3.2

Skriv Java implementasjonen for problemet dere beskrev i 3.1 for State designmønsteret.

### 3.3

Et tegneprogram har en abstrakt Shape klasse som representerer grafiske former. Hver konkrete Shape-klasse støtter en `draw()` metode som tegner formen til skjermen. Eksempler på slike konkrete klasser er `Circle` og `Rectangle`. Programmet håndterer en generell List<Shape> liste for alle formene som skal tegnes til skjermen.

- Burde `draw()` metoden være abstrakt? Begrunn.
- Skriv Java metoden som applikasjonen bruker for å tegne alle elementene i `List<Shape>` listen til skjermen. Beskriv hvordan Observer designmønsteret relaterer til hendelser som kan trigge draw-metoden, som for eksempel museklikk.
- Vis hvordan man kan bruke Composite designmønsteret til å la en gruppe med former være representert som et objekt.
- Hvilket designmønster kan brukes til å utvide programmet til å tegne en ramme rundt noen av formene? Vis hvordan dette kan gjøres. Den konkrete implementasjonen for tegning av rammen må ikke implementeres.

## 4 Trådprogrammering
En tekstbehandler med versjonskontroll

Implementer en html-editor i JavaFX med versjonskontroll. Bruker skal kunne angi versjonen til dokumentet når html-siden blir lagret til fil og skal kunne laste et dokument inn i programmet fra en gitt versjon.

Fil-innlastingen skal gjennomføres i en egen tråd. GUIet skal slås av slik at bruker ikke kan gjøre noe i applikasjonen mens filen lastes inn i programmet. Husk å rapporter til bruker hvis noe feil oppstår i filbehandlingen (dvs. hvis `call()`-metoden kaster et avvik).

Tips: du kan bruke `javafx.scene.web.HTMLEditor` for en standard html editor.

Ellers er det ikke veldig store krav til generell brukbarhet til programmet, siden det viktigste er å løse delen for tråder. I løsningsforslaget er filene lagret i en pre-definert mappe innad i prosjektet (dvs. `ingen FileChooser`), der filnavnet inneholder versjonsnummeret (eks. "htmldata-v1.txt" etc.)
