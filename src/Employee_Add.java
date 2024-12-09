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
