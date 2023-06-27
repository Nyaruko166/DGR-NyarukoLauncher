package nyaruko166;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String pathSteam = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Deep Rock Galactic\\FSD\\Saved";
        String pathCrack = "D:\\Games\\Deep.Rock.Galactic_LinkNeverDie.Com\\FSD\\Saved";
        String fileExtention = ".sav";
        File steamFile = getFileSteam(pathSteam, fileExtention);
        File crackFile = getFileSteam(pathCrack, fileExtention);
        if (steamFile != null && crackFile != null) {
            Date dateSteam = new Date(steamFile.lastModified());
            Date dateCrack = new Date(crackFile.lastModified());
            int result = dateSteam.compareTo(dateCrack);
            if (result<0){
                System.out.println("Steam cũ hơn Crack");
            } else if (result>0) {
                System.out.println("Steam mới hơn Crack");
            }else {
                System.out.println("Steam == Crack");
            }
        }
    }

    public static File getFileSteam(String path, String fileExtension) {
        File folderSteam = new File(path + "\\SaveGames");
        if (folderSteam.exists() && folderSteam.isDirectory()) {
            File lastestFile = null;

            Long lastestModifiedTime = Long.MIN_VALUE;

            File[] lstFile = folderSteam.listFiles();

            if (lstFile != null) {
                for (File x : lstFile) {
                    if (x.isFile() && x.getName().endsWith(fileExtension)) {
                        if (!x.getName().contains("Backup") && !x.getName().contains("ExternalBackup")) {
                            Long modifiedTime = x.lastModified();
                            if (modifiedTime > lastestModifiedTime) {
                                lastestModifiedTime = modifiedTime;
                                lastestFile = x;
                            }
                        }

                    }
                }
            }
//            if (lastestFile != null) {
//                System.out.println("File có ngày chỉnh sửa gần nhất là: " + lastestFile.getAbsolutePath());
//                System.out.println("Ngày chỉnh sửa gần nhất: " + lastestFile.lastModified());
//            } else {
//                System.out.println("Không tìm thấy file có đuôi " + fileExtension + " trong thư mục.");
//            }
//        } else {
//            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
//
            //}
            return lastestFile;
        }
        return null;
    }
}