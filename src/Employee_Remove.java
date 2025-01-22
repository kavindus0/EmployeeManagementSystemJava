import java.io.File;
import java.io.IOException;

class Employee_Remove implements FileFunctions {
    @Override
    public void createFileBaseHTML() throws IOException {
        // Not implemented
    }

    @Override
    public void listUserdataFiles() throws IOException {
        // Not implemented
    }

    public void removeFile(String id) {
        File file = new File("./userdata/employee" + id + ".html");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nEmployee has been removed successfully!");
            } else {
                System.out.println("\nFailed to remove employee.");
            }
        } else {
            System.out.println("\nEmployee does not exist!");
        }
    }

    @Override
    public void viewFile(String id) throws IOException {
        // Not implemented
    }

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {
        // Not implemented
    }
}