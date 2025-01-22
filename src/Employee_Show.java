import java.awt.*;
import java.io.File;
import java.io.IOException;

class Employee_Show implements FileFunctions {
    @Override
    public void createFileBaseHTML() throws IOException {
        // Not implemented
    }

    @Override
    public void listUserdataFiles() throws IOException {
        // Not implemented
    }

    @Override
    public void removeFile(String id) throws IOException {
        // Not implemented
    }

    public void viewFile(String id) {
        File file = new File("./userdata/employee" + id + ".html");
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.printf("Employee with ID: %s shown successfully%n", id);
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.out.println("Employee record not found.");
        }
    }

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {
        // Not implemented
    }
}