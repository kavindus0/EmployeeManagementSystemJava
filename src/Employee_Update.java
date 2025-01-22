import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Employee_Update implements FileFunctions {
    @Override
    public void createFileBaseHTML() throws IOException {

    }

    @Override
    public void listUserdataFiles() throws IOException {

    }

    @Override
    public void removeFile(String id) throws IOException {

    }

    @Override
    public void viewFile(String id) throws IOException {

    }

    public void updateFile(String id, String oldData, String newData) {
        try {
            File file = new File("employee" + id + ".html");
            if (!file.exists()) {
                System.out.println("Employee record not found.");
                return;
            }

            Scanner sc = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();
            while (sc.hasNextLine()) {
                fileContent.append(sc.nextLine()).append("\n");
            }

            String updatedContent = fileContent.toString().replace(oldData, newData);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedContent);
            writer.close();

            System.out.println("Employee record has been updated successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
