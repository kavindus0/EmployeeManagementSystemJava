import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Employee_Update implements FileFunctions {
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

    @Override
    public void viewFile(String id) throws IOException {
        // Not implemented
    }

    public void updateFile(String id, String oldData, String newData) {
        File file = new File(FileFunctions.USER_DATA_DIR + "employee" + id + ".html");
        if (!file.exists()) {
            System.out.println("Employee record not found.");
            return;
        }

        try (Scanner sc = new Scanner(file);
             FileWriter writer = new FileWriter(file)) {

            StringBuilder fileContent = new StringBuilder();
            while (sc.hasNextLine()) {
                fileContent.append(sc.nextLine()).append("\n");
            }

            String content = fileContent.toString();
            if (!content.contains(oldData)) {
                System.out.println("The old data was not found in the file.");
                return;
            }

            String updatedContent = content.replace(oldData, newData);
            writer.write(updatedContent);

            System.out.println("Employee record has been updated successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}