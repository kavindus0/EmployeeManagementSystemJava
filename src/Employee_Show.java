import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Employee_Show {

    private static void openDirectory(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }

    public void viewFile(String id) throws Exception {
        File file = new File("employee" + id + ".html");

        if (file.exists()) while (true) {
            Desktop.getDesktop().open(file);
            System.out.printf("Employee with ID: %s shown successfully%n", id);
            break;
        }
        else {
            System.out.println("Employee record not found.");
        }
    }
}

