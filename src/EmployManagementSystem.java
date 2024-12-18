import java.util.*;
import java.io.*;

class EmployManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        Employee_Show viewer = new Employee_Show();
        menu.menu();
        int choice = 0;
        while (choice != 12) {
            StaticsArt.SelectList();
            System.out.println("\n1. Add Employee\n2. View Employee\n3. Remove Employee\n4. Update Employee");
            System.out.println("5. Search Employee\n6. List All Employees\n7. Salary Management");
            System.out.println("8. Attendance Management\n9. Performance Review\n10. Export Data\n11. Sort Employees");
            System.out.println("12. Exit");
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
                   // new Employee_Remover().removeFile(removeId);
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
                    System.out.print("\nEnter name or ID to search: ");
                    String searchKey = sc.nextLine();
                    new Employee_Search().searchFile(searchKey);
                    break;

                case 6:
                    new Employee_List().listAll();
                    break;

                case 7:
                    System.out.print("\nEnter Employee ID to manage salary: ");
                    String salaryId = sc.nextLine();
                    new SalaryManagement().manageSalary(salaryId);
                    break;

                case 8:
                    System.out.print("\nEnter Employee ID to mark attendance: ");
                    String attendanceId = sc.nextLine();
                    new Attendance().markAttendance(attendanceId);
                    break;

                case 9:
                    System.out.print("\nEnter Employee ID to update performance: ");
                    String performanceId = sc.nextLine();
                    new PerformanceReview().updatePerformance(performanceId);
                    break;

                case 10:
                    new DataExport().exportToCSV();
                    break;

                case 11:
                    System.out.println("\nSort By: 1. ID 2. Name 3. Salary");
                    int sortChoice = Integer.parseInt(sc.nextLine());
                    new Employee_Sort().sortBy(sortChoice);
                    break;

                case 12:
                    new CodeExit().out();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Class to Search Employee
class Employee_Search {
    void searchFile(String key) {
        System.out.println("Searching for: " + key);
        // Code to search employees in files
    }
}

// Class to List All Employees
class Employee_List {
    void listAll() {
        System.out.println("Listing all employees...");
        // Code to display all employee details
    }
}

// Class for Salary Management
class SalaryManagement {
    void manageSalary(String empId) {
        System.out.println("Managing salary for Employee ID: " + empId);
        // Code to add/update salary, calculate bonuses, etc.
    }
}

// Class for Attendance Management
class Attendance {
    void markAttendance(String empId) {
        System.out.println("Marking attendance for Employee ID: " + empId);
        // Code to mark attendance
    }
}

// Class for Performance Review
class PerformanceReview {
    void updatePerformance(String empId) {
        System.out.println("Updating performance for Employee ID: " + empId);
        // Code to update and store employee performance
    }
}

// Class to Export Data
class DataExport {
    void exportToCSV() {
        System.out.println("Exporting employee data to CSV...");
        // Code to export employee data to CSV
    }
}

// Class for Sorting Employees
class Employee_Sort {
    void sortBy(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Sorting by ID...");
                break;
            case 2:
                System.out.println("Sorting by Name...");
                break;
            case 3:
                System.out.println("Sorting by Salary...");
                break;
            default:
                System.out.println("Invalid sorting option.");
        }
    }
}

class Employee_Updater {
    void updateFile(String empId, String oldData, String newData) {
        System.out.println("Updating employee with ID: " + empId);
        System.out.println("Replacing \"" + oldData + "\" with \"" + newData + "\".");
        // Code to update employee file
    }
}