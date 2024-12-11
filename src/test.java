import java.awt.*;
import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        openDirectory();
    }


    private static void openDirectory() throws IOException {
        File directory = new File("/Users/kavindus/Projects/Sem02/JavaSem02/style.css");
        Desktop.getDesktop().open(directory);
    }
}
