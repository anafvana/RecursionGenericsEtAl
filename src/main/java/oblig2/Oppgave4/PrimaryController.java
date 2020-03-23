package oblig2.Oppgave4;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class PrimaryController {

    private Opener task;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private TextField lblLoad;

    @FXML
    private TextField lblSave;

    @FXML
    private Button buttonL;

    @FXML
    void btnLoad(ActionEvent event) throws Exception{
        int version = 0;
        try {
            version = Integer.parseInt(lblLoad.getText());
        } catch (Exception e){
            Alert failed = new Alert(Alert.AlertType.ERROR);
            failed.setContentText("Invalid version.");
        }

        task = new Opener(version);
        task.setOnSucceeded(this::threadDone);
        task.setOnFailed(this::threadFailed);
        Thread th = new Thread(task);
        th.setDaemon(true);
        buttonL.setDisable(true);
        htmlEditor.setDisable(true);
        th.start();
    }

    private void threadFailed(WorkerStateEvent e){
        htmlEditor.setHtmlText("");
        Alert failed = new Alert(Alert.AlertType.ERROR);
        failed.setContentText("Import failed.");
        htmlEditor.setDisable(false);
        buttonL.setDisable(false);
    }

    private void threadDone(WorkerStateEvent e){
        Save loadedSave = task.call();
        htmlEditor.setHtmlText(loadedSave.getContent());
        htmlEditor.setDisable(false);
        buttonL.setDisable(false);
    }


    @FXML
    void btnSave(ActionEvent event) {
        String content = htmlEditor.getHtmlText();

        if (content != ""){
            int version = 1;
            try {
                version = Integer.parseInt(lblSave.getText());
            } catch (Exception e){
                Alert failed = new Alert(Alert.AlertType.ERROR);
                failed.setContentText("Invalid version.");
            }
            Save.saveNow(content, version);
        }
    }

}