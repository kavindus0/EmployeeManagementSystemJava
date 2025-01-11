import java.io.File;
public class EmployeeDataView {


    public void listUserdataFiles() {
        File userdataDir = new File("userdata");
        if (userdataDir.exists() && userdataDir.isDirectory()) {
            String[] fileList = userdataDir.list();
            if (fileList != null) {
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    // ...existing code...
}

