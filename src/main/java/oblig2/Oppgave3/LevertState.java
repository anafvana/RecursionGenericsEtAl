package oblig2.Oppgave3;

public class LevertState implements PakkeState {
    @Override
    public void neste(Pakke pakke) {
        pakke.setState(new MottattState());
    }

    @Override
    public void forrige(Pakke pakke) {
        pakke.setState(new BestiltState());
    }

    @Override
    public void printStatus() {
        System.out.println("Pakke sendt, ikke levert enda.");
    }
}
