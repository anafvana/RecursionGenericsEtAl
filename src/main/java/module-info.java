module oblig2 {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens oblig2.oppgave4 to javafx.fxml;
    exports oblig2.oppgave4;
}