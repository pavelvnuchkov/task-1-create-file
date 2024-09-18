import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        //------1--------
        File dirGame = new File("Game");
        builder.append("Папка " + dirGame.getName() + " создана  - " + dirGame.mkdir() + "\n");
        File dirSrc = new File(dirGame, "src");
        builder.append("Папка " + dirSrc.getName() + " создана  - " + dirSrc.mkdir() + "\n");
        File dirRes = new File(dirGame, "res");
        builder.append("Папка " + dirRes.getName() + " создана  - " + dirRes.mkdir() + "\n");
        File dirSaveGame = new File(dirGame, "savegame");
        builder.append("Папка " + dirSaveGame.getName() + " создана  - " + dirSaveGame.mkdir() + "\n");
        File dirTemp = new File(dirGame, "temp");
        builder.append("Папка " + dirTemp.getName() + " создана  - " + dirTemp.mkdir() + "\n");
        //-------2--------
        File dirMain = new File(dirSrc, "main");
        builder.append("Папка " + dirMain.getName() + " создана  - " + dirMain.mkdir() + "\n");
        File dirTest = new File(dirSrc, "test");
        builder.append("Папка " + dirTest.getName() + " создана  - " + dirTest.mkdir() + "\n");
        //-------3------
        File fileMain = new File(dirMain, "Main.java");
        File fileUtils = new File(dirMain, "Utils.java");
        try {
            builder.append("Файл " + fileMain.getName() + " создан  - " + fileMain.createNewFile() + "\n");
            builder.append("Файл " + fileUtils.getName() + " создан  - " + fileUtils.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //-------4------
        File dirDrawables = new File(dirRes, "drawables");
        builder.append("Папка " + dirDrawables.getName() + " создана  - " + dirDrawables.mkdir() + "\n");
        File dirVectors = new File(dirRes, "vectors");
        builder.append("Папка " + dirVectors.getName() + " создана  - " + dirVectors.mkdir() + "\n");
        File dirIcons = new File(dirRes, "icons");
        builder.append("Папка " + dirIcons.getName() + " создана  - " + dirIcons.mkdir() + "\n");
        //-------5------
        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            builder.append("Файл " + fileTemp.getName() + " создан  - " + fileTemp.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(fileTemp)) {
            writer.write(String.valueOf(builder));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
