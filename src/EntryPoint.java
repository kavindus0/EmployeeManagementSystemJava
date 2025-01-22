import java.io.*;
import java.util.Scanner;

public class EntryPoint {
    private static final File USER_DATA_FILE = new File("userdata.txt");
    private static final String USER_DATA_DIR = "./userdata/";
    private static final String EMERGENCY_DATA_DIR = "./emergencydata/";
    private static final String SALARY_DATA_DIR = "./salarydata/";

    public static void main(String[] args) {

        // Create necessary directories and files
        createDirectories();

        createUserDataFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    try {
                        login(scanner);
                    } catch (IOException e) {
                        System.out.println("An error occurred during login: " + e.getMessage());
                    }
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

    private static void createDirectories() {
        File userDataDir = new File(USER_DATA_DIR);
        File emergencyDataDir = new File(EMERGENCY_DATA_DIR);
        File salaryDataDir = new File(SALARY_DATA_DIR);

        if (!userDataDir.exists()) {
            userDataDir.mkdirs();
        }
        if (!emergencyDataDir.exists()) {
            emergencyDataDir.mkdirs();
        }
        if (!salaryDataDir.exists()) {
            salaryDataDir.mkdirs();
        }
    }

    private static void createUserDataFile() {
        if (!USER_DATA_FILE.exists()) {
            try {
                USER_DATA_FILE.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating userdata.txt: " + e.getMessage());
            }
        }
    }

    private static void login(Scanner scanner) throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
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
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        try {
                            new Employee_Add().createFileBaseHTML();
                        } catch (IOException e) {
                            System.out.println("An error occurred while adding an employee: " + e.getMessage());
                        }
                        break;

                    case 2:
                        viewerData.listUserdataFiles();
                        System.out.print("\nEnter Employee ID to view: ");
                        String viewId = sc.nextLine();
                        try {
                            viewer.viewFile(viewId);
                        } catch (Exception e) {
                            System.out.println("An error occurred while viewing the employee: " + e.getMessage());
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

    static boolean isUserExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }

    static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isUserExists(username)) {
            System.out.println("Username already exists. Please try a different username.");
        } else {
            saveUser(username, password);
            System.out.println("Registration successful!");
        }
    }

    static boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }

    static void saveUser(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }
}