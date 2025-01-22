import java.io.File;
import java.io.IOException;

public class EmployeeDataView implements FileFunctions{
    @Override
    public void createFileBaseHTML() throws IOException {

    }

    public void listUserdataFiles() {
        System.out.println("\nList of Employee IDs EXIST\n");
        File userdataDir = new File("userdata");
        if (userdataDir.exists() && userdataDir.isDirectory()) {
            String[] fileList = userdataDir.list();
            if (fileList != null) {
                for (String fileName : fileList) {
                    int startIndex = fileName.indexOf("employee") + "employee".length();
                    int endIndex = fileName.indexOf(".html");
                    if (endIndex != -1 && startIndex < endIndex) {
                        StringBuffer buffer = new StringBuffer(fileName);
                        String extractedWord = buffer.substring(startIndex, endIndex);
                        System.out.println(" - " + extractedWord);
                    }
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    @Override
    public void removeFile(String id) throws IOException {

    }

    @Override
    public void viewFile(String id) throws IOException {

    }

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {

    }

}
