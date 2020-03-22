package oblig2.oppgave4;

import javafx.concurrent.Task;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Paths;

public class Thread2 extends Task<Save>{
    @Override
    public Save call() throws Exception{
        Save importedSave = null;
        FileChooser fc = new FileChooser();
        String currentDir = Paths.get(".").toAbsolutePath().normalize().toString();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("ser", "*.ser"));
        fc.setInitialDirectory(new File(currentDir));

        File selectedFile = fc.showOpenDialog(null);

        FileInputStream fis = new FileInputStream(selectedFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        importedSave = (Save) ois.readObject();
        ois.close();

        return importedSave;
    }
}
