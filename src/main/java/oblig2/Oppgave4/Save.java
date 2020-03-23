package oblig2.Oppgave4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save{
    private int version;
    private String content;

    public Save(int version, String content){
        this.version = version;
        this.content = content;
    }

    public int getVersion(){
        return version;
    }

    public void setVersion(int version){
        this.version = version;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public static void saveNow(String content, int versjon){
        Path path = Paths.get("MyHtmlV" + versjon + ".html");

        //File selectedFile = new File("MyHtmlV" + versjon + ".html");
        try {
            Files.write(path, content.getBytes());
            Save thisVersion = new Save(versjon, content);
            thisVersion.setContent(content);
        } catch (FileNotFoundException e){
            Alert FileNotFound = new Alert(AlertType.ERROR);
            FileNotFound.setContentText("File not found: " + e.getMessage());
        }catch (IOException e){
            Alert IOExcep = new Alert(AlertType.ERROR);
            IOExcep.setContentText("Input/Output error: " + e.getMessage());
        }
    }
}
