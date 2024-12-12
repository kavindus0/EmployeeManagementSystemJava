import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Employee_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);
        EmployDetail emp = new EmployDetail();
        emp.getInfo();

        try {
            File f1 = new File("employee" + emp.employ_id + ".html");
            if (f1.createNewFile()) {
                FileWriter writer = new FileWriter(f1);writer.write("<html>");
                writer.write("<head>");
                writer.write("<title>Employee Details</title>");
                writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
                writer.write("</head>");
                writer.write("<body>");
                writer.write("<div class=\"container\">");
                writer.write("<h1 class=\"title\">Employee Details</h1>");
                writer.write("<div class=\"details\">");
                writer.write("<p><strong>Employee ID:</strong> <span class=\"fade-in\">" + emp.employ_id + "</span></p>");
                writer.write("<p><strong>Name:</strong> <span class=\"fade-in\">" + emp.name + "</span></p>");
                writer.write("<p><strong>Father's Name:</strong> <span class=\"fade-in\">" + emp.father_name + "</span></p>");
                writer.write("<p><strong>Contact:</strong> <span class=\"fade-in\">" + emp.employ_contact + "</span></p>");
                writer.write("<p><strong>Email:</strong> <span class=\"fade-in\">" + emp.email + "</span></p>");
                writer.write("<p><strong>Position:</strong> <span class=\"fade-in\">" + emp.position + "</span></p>");
                writer.write("<p><strong>Salary:</strong> <span class=\"fade-in\">" + emp.employ_salary + "</span></p>");
                writer.write("</div>");
                writer.write("</div>");
                writer.write("<script src=\"script.js\"></script>");
                writer.write("</body>");
                writer.write("</html>");
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
