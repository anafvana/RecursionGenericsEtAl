module oblig2.Oppgave4 {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens oblig2.Oppgave4 to javafx.fxml;
    exports oblig2.Oppgave4;
}