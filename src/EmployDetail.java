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
