package oblig2.oppgave4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Save implements Serializable{
    private LocalDateTime saveDate;
    private String content;

    public Save(LocalDateTime saveDate, String content){
        this.saveDate = saveDate;
        this.content = content;
    }

    public LocalDateTime getSaveDate(){
        return saveDate;
    }

    public void setSaveDate(LocalDateTime saveDate){
        this.saveDate = saveDate;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void saveNow(){
        FileChooser fc = new FileChooser();
        String currentDir = Paths.get(".").toAbsolutePath().normalize().toString();
        fc.setInitialFileName("mySave.txt");
        fc.setInitialDirectory(new File(currentDir));

        File selectedFile = fc.showSaveDialog(null);
        try {
            FileOutputStream fos = new FileOutputStream(selectedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(selectedFile);
        } catch (FileNotFoundException e){
            Alert FileNotFound = new Alert(AlertType.ERROR);
            FileNotFound.setContentText("File not found: " + e.getMessage());
        }catch (IOException e){
            Alert IOExcep = new Alert(AlertType.ERROR);
            IOExcep.setContentText("Input/Output error: " + e.getMessage());
        }


    }
}
