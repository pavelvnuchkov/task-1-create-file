import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        List<String> listPathDir = new ArrayList<>();
        listPathDir.add("Game");
        listPathDir.add("Game/res");
        listPathDir.add("Game/src");
        listPathDir.add("Game/savegame");
        listPathDir.add("Game/temp");
        listPathDir.add("Game/src/main");
        listPathDir.add("Game/src/test");
        listPathDir.add("Game/res/drawables");
        listPathDir.add("Game/res/vectors");
        listPathDir.add("Game/res/icons");

        List<String> listPathFile = new ArrayList<>();
        listPathFile.add("Game/src/main/Main.java");
        listPathFile.add("Game/src/main/Utils.java");
        listPathFile.add("Game/temp/temp.txt");

        for (String path : listPathDir) {
            addDirectory(path);
        }
        for (String path : listPathFile) {
            addFile(path);
        }
        addLogFile("Game/temp/temp.txt");
        System.out.println(builder);
    }

    public static void addDirectory(String pathDir) {
        File newDir = new File(pathDir);
        builder.append("Папка " + newDir.getName() + " создана  - " + newDir.mkdir() + "\n");
    }

    public static void addFile(String pathDir) {
        File newFile = new File(pathDir);
        try {
            builder.append("Файл " + newFile.getName() + " создан  - " + newFile.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addLogFile(String path) {
        try(FileWriter writer = new FileWriter(path)) {
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
