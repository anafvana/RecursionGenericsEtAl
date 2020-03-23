package oblig2.Oppgave4;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Opener extends Task<Save>{

    private int versjonNr;

    public Opener(int versjonNr){
        this.versjonNr = versjonNr;
    }

    @Override
    public Save call(){
        try{
            Thread.sleep(2000);
            File f = new File("MyHtmlV" + versjonNr + ".html");

            var reader = Files.newBufferedReader(f.toPath());

            Save importedSave = new Save(0, "");
            String str;
            while ((str = reader.readLine()) != null){
                str += str + "\n";
                importedSave.setContent(str);
            }

            return importedSave;
        }
        catch(IOException | InterruptedException e){
            Alert failed = new Alert(Alert.AlertType.ERROR);
            failed.setContentText("Could not load.");
            return null;
        }

    }


}
