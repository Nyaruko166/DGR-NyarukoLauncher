package nyaruko166;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.val;
import org.apache.commons.io.FileUtils;

import javax.swing.*;

import static java.awt.Desktop.getDesktop;
import static java.util.Arrays.asList;

public class Main {

    

    public static void main(String[] args) {

//        String steamInstallationPath = "C:\\Program Files (x86)\\Steam\\steam.exe";
//        startGameSteam(steamInstallationPath);
        String pathSteam = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Deep Rock Galactic\\FSD\\Saved";
        String pathCrack = "D:\\Games\\Deep.Rock.Galactic_LinkNeverDie.Com\\FSD\\Saved";
        
    }

    public void copyDir(Path src, Path dest) {
        String destStr = dest.toString();

        try {
            FileUtils.deleteDirectory(new File(destStr));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        new File(destStr).mkdirs();

        try {
            Files.walk(src).forEach(s -> {
                try {
                    Files.copy(s, dest.resolve(src.relativize(s)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}