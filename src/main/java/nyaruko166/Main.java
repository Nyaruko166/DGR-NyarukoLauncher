package nyaruko166;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathSteam = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Deep Rock Galactic\\FSD\\Saved";
        String crackPath = "D:\\Games\\Deep.Rock.Galactic_LinkNeverDie.Com\\FSD\\Saved";
    }

    public File getFileSteam(String pathSteam, String fileExtension) {
        File folderSteam = new File(pathSteam + "\\Saved\\SaveGames");
        if (folderSteam.exists() && folderSteam.isDirectory()) {
            File lastestFile = null;

            Long lastestModifiedTime = Long.MIN_VALUE;

            File[] lstFile = folderSteam.listFiles();

        }
        return null;
    }

}