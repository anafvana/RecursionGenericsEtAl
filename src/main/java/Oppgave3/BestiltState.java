package Oppgave3;

public class BestiltState implements PakkeState {
    @Override
    public void neste(Pakke pakke) {
        pakke.setState(new LevertState());
    }

    @Override
    public void forrige(Pakke pakke) {
        System.out.println("Pakken er i sin intiale tilstand.");
    }

    @Override
    public void printStatus() {
        System.out.println("Pakke bestilt, ikke levert til kunde enda.");
    }
}
