public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

import java.io.*;
import java.util.*;

/****************** MENU OF EMS ********************/
class MainMenu {
    public void menu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\nPress 1 : To Add an Employee Details");
        System.out.println("Press 2 : To See an Employee Details");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");
    }
}

/****************** Taking Employee Details ********************/
class EmployDetail {
    String name, father_name, email, position, employ_id, employ_salary, employ_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee's Name --------: ");
        name = sc.nextLine();
        System.out.print("Enter Employee's Father Name -: ");
        father_name = sc.nextLine();
        System.out.print("Enter Employee's ID ----------: ");
        employ_id = sc.nextLine();
        System.out.print("Enter Employee's Email ID ----: ");
        email = sc.nextLine();
        System.out.print("Enter Employee's Position ----: ");
        position = sc.nextLine();
        System.out.print("Enter Employee's Contact Info : ");
        employ_contact = sc.nextLine();
        System.out.print("Enter Employee's Salary ------: ");
        employ_salary = sc.nextLine();
    }
}

/****************** Add Employee Details ********************/
class Employee_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);
        EmployDetail emp = new EmployDetail();
        emp.getInfo();

        try {
            File f1 = new File("employee" + emp.employ_id + ".html");
            if (f1.createNewFile()) {
                FileWriter writer = new FileWriter(f1);
                writer.write("<html><head><title>Employee Details</title></head><body>");
                writer.write("<h1>Employee Details</h1>");
                writer.write("<p><strong>Employee ID:</strong> " + emp.employ_id + "</p>");
                writer.write("<p><strong>Name:</strong> " + emp.name + "</p>");
                writer.write("<p><strong>Father's Name:</strong> " + emp.father_name + "</p>");
                writer.write("<p><strong>Contact:</strong> " + emp.employ_contact + "</p>");
                writer.write("<p><strong>Email:</strong> " + emp.email + "</p>");
                writer.write("<p><strong>Position:</strong> " + emp.position + "</p>");
                writer.write("<p><strong>Salary:</strong> " + emp.employ_salary + "</p>");
                writer.write("</body></html>");
                writer.close();
                System.out.println("\nEmployee has been added successfully!");
            } else {
                System.out.println("\nEmployee already exists!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

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

/****************** Remove Employee Details ********************/
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

/****************** Update Employee Details ********************/
class Employee_Update {
    public void updateFile(String id, String oldData, String newData) {
        try {
            File file = new File("employee" + id + ".html");
            if (!file.exists()) {
                System.out.println("Employee record not found.");
                return;
            }

            Scanner sc = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();
            while (sc.hasNextLine()) {
                fileContent.append(sc.nextLine()).append("\n");
            }

            String updatedContent = fileContent.toString().replace(oldData, newData);
            FileWriter writer = new FileWriter(file);
            writer.write(updatedContent);
            writer.close();

            System.out.println("Employee record has been updated successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

/****************** Exit Program ********************/
class CodeExit {
    public void out() {
        System.out.println("\nThank you for using the Employee Management System!");
        System.exit(0);
    }
}

/****************** Main Class ********************/
class EmployManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        Employee_Show viewer = new Employee_Show();
        menu.menu();

        int choice = 0;
        while (choice != 5) {
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