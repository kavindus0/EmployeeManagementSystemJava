import java.util.Scanner;

class EmployManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        Employee_Show viewer = new Employee_Show();
        menu.menu();
        int choice = 0;
        while (choice != 5) {
            StaticsArt.SelectList();
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    new Employee_Add().createFile();
                    break;

                case 2:
                    System.out.print("\nEnter Employee ID to view: ");
                    String viewId = sc.nextLine();
                    try {
                        viewer.viewFile(viewId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("\nEnter Employee ID to remove: ");
                    String removeId = sc.nextLine();
                    new Employee_Remove().removeFile(removeId);
                    break;

                case 4:
                    System.out.print("\nEnter Employee ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("Enter old data to update: ");
                    String oldData = sc.nextLine();
                    System.out.print("Enter new data: ");
                    String newData = sc.nextLine();
                    new Employee_Update().updateFile(updateId, oldData, newData);
                    break;

                case 5:
                    new CodeExit().out();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
