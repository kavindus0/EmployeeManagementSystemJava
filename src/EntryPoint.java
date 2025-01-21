import java.util.Scanner;

public static void main() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid choice");
            choice = 3;
        }
        switch (choice) {
            case 1:
                Login.register(scanner);
                break;
            case 2:
                login(scanner);
                break;
            case 3:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}


private static void login(Scanner scanner) {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    if (Login.authenticateUser(username, password)) {
        System.out.println("Login successful!");

        EmployeeDataView viewerData = new EmployeeDataView();
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
                    viewerData.listUserdataFiles();
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
                    viewerData.listUserdataFiles();
                    String removeId = sc.nextLine();
                    new Employee_Remove().removeFile(removeId);
                    break;

                case 4:
                    System.out.print("\nEnter Employee ID to update: ");
                    viewerData.listUserdataFiles();
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

    } else {
        System.out.println("Invalid username or password!");
    }
}




