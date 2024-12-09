//import

import java.io.File;

class Employee_Remove {
    public void removeFile(String id) {
        File file = new File("employee" + id + ".html");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nEmployee has been removed successfully!");
            }
        } else {
            System.out.println("\nEmployee does not exist!");
        }
    }
}
