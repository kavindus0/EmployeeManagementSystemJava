import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/****************** Show Employee Details ********************/
class Employee_Show {

    private static void openDirectory(File file) throws IOException {
      //  File directory = new File("/Users/kavindus/Projects/Sem02/JavaSem02/style.css");
        Desktop.getDesktop().open(file);
    }

    public void viewFile(String id) throws Exception {
        File file = new File("employee" + id + ".html");

        if (file.exists()) {
            Desktop.getDesktop().open(file);

                         //file code from test
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
//            }
        } else {
            System.out.println("Employee record not found.");
        }
    }
}

