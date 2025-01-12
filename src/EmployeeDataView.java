import java.io.File;
public class EmployeeDataView {
    public void listUserdataFiles() {
        System.out.println("\nList of Employee IDs EXIST\n");
        File userdataDir = new File("userdata");
        if (userdataDir.exists() && userdataDir.isDirectory()) {
            String[] fileList = userdataDir.list();
            if (fileList != null) {
                for (String fileName : fileList) {
                    int startIndex = fileName.indexOf("employee") + "employee".length();
                    int endIndex = fileName.indexOf(".html");
                    if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
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

}
