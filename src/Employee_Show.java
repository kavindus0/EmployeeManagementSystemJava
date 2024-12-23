import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Employee_Show {

    private static void openDirectory(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }

    public void viewFile(String id) throws Exception {
        File file = new File("./userdata/employee" + id + ".html");

        if (file.exists()) while (true) {
            try {
                Desktop.getDesktop().open(file);
                System.out.printf("Employee with ID: %s shown successfully%n", id);
            } catch (Exception e) {}
            break;
        }
        else {
            System.out.println("Employee record not found.");
        }
    }
}

