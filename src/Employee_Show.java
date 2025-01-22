import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Employee_Show implements FileFunctions {

    private static void openDirectory(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }

    @Override
    public void createFileBaseHTML() throws IOException {

    }

    @Override
    public void listUserdataFiles() throws IOException {

    }

    @Override
    public void removeFile(String id) throws IOException {

    }

    public void viewFile(String id) {
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

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {

    }
}

