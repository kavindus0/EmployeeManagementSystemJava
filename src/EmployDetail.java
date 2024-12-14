import java.util.Scanner;
class EmployDetail {
            String name, father_name, email, position, employ_id;
            double employ_salary;
            int employ_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee's Name --------: ");
        name = sc.nextLine();
        System.out.print("Enter "+name+"'s Father Name -: ");
        father_name = sc.nextLine();
        System.out.print("Enter "+name+"'s ID ----------: ");
        employ_id = sc.nextLine();
        System.out.print("Enter "+name+"'s Email ID ----: ");
        email = sc.nextLine();
        System.out.print("Enter "+name+"'s Position ----: ");
        position = sc.nextLine();
        System.out.print("Enter "+name+"'s Contact Info : ");
        employ_contact = sc.nextInt();
        System.out.print("Enter "+name+"'s Salary ------: ");
        employ_salary = sc.nextDouble();
    }
}
