package Oppgave3;

// Oppgave 3.2 er Pakke programmet.

public class Pakke {

// Oppgave 3.1
// Et problem som passer for designmønsteret State kan for eksempel være et pakkeleveringssystem. Der pakken ha flere forskjellige "states",
// altså levert, i rute, sendt fra lager osv osv. Problemet hvis du bare bruker enkle if - when setninger er at koden kommer til å bli alt for
// stor hvis du har et komplisert system med mange varer. Her kan State brukes til å forenkle problemet.

// Et problem som passer for designmønsteret Strategy kan for eksempel være en online shopping cart der du har to "strategier",
// enten å betale med kredittkort eller via paypal. Da kan du lage en strategi som et interface og lage to spesifikke strategier
// som f.eks kredittkort eller paypal og la de implementere strategien. Dette reduserer mengden kode.

    private PakkeState state = new BestiltState();

    void setState(PakkeState state) {
        this.state = state;
    }

    public PakkeState getState() {
        return state;
    }

    public void forrigeState() {
        state.forrige(this);
    }

    public void nesteState() {
        state.neste(this);
    }

    public void printStatus() {
        state.printStatus();
    }

    public static void main(String[] args) {
        Pakke pakke = new Pakke();
        pakke.printStatus();

        pakke.forrigeState();

        pakke.nesteState();
        pakke.printStatus();

        pakke.nesteState();
        pakke.printStatus();

        pakke.nesteState();
        pakke.printStatus();

        pakke.forrigeState();
        pakke.printStatus();

        pakke.nesteState();
        pakke.printStatus();
    }
}
