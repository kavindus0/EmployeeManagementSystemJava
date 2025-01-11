import java.io.File;
public class EmployeeDataView {
    public void listUserdataFiles() {
        System.out.println("List of Employee Data Files:");
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

}

