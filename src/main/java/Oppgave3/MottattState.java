package Oppgave3;

public class MottattState implements PakkeState {
    @Override
    public void neste(Pakke pakke) {
        System.out.println("Pakken er allerede mottatt av kunden.");
    }

    @Override
    public void forrige(Pakke pakke) {
        pakke.setState(new LevertState());
    }

    @Override
    public void printStatus(){
        System.out.println("Pakken er mottatt.");
    }
}
