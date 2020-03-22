package oblig2.oppgave4;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.web.HTMLEditor;

import java.time.LocalDateTime;

public class PrimaryController {

    private Thread2 task;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    void brnNew(ActionEvent event) {

    }

    @FXML
    void btnClone(ActionEvent event) {

    }

    @FXML
    void btnDeleteAll(ActionEvent event) {

    }

    @FXML
    void btnDeleteThis(ActionEvent event) {

    }

    @FXML
    void btnLoad(ActionEvent event) throws Exception{
        task = new Thread2();
        task.setOnSucceeded(this::threadDone);
        task.setOnFailed(this::threadFailed);
        Thread th = new Thread(task);
        th.setDaemon(true);
        htmlEditor.setDisable(true);
        th.start();

        Save loadedSave = task.call();

        htmlEditor.setHtmlText(loadedSave.content);

    }

    private void threadFailed(WorkerStateEvent e){
        htmlEditor.setHtmlText("");
        Alert failed = new Alert(Alert.AlertType.ERROR);
        failed.setContentText("Import failed.");
        htmlEditor.setDisable(false);
    }

    private void threadDone(WorkerStateEvent e){
        htmlEditor.setDisable(false);
    }


    @FXML
    void btnSave(ActionEvent event) {
        String content = htmlEditor.getHtmlText();
        Save newVersion = new Save(LocalDateTime.now(), content);
        newVersion.saveNow();
    }


}
