import java.io.File;

/****************** Show Employee Details ********************/
class Employee_Show {
    public void viewFile(String id) throws Exception {
        File file = new File("employee" + id + ".html");
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } else {
            System.out.println("Employee record not found.");
        }
    }
}
