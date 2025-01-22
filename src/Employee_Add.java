import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee_Add implements FileFunctions{
    public void createFileBaseHTML() throws IOException {
        Scanner sc = new Scanner(System.in);
        EmployDetail emp = new EmployDetail();
        emp.getInfo();
        EmergencyContactAddPage emrj= new  EmergencyContactAddPage(emp.getName(),emp.getEmploy_contact(),emp.getEmail(),emp.getEmploy_id());
        emrj.createFileBaseHTML(emp);


        try {
            File f1 = new File("./userdata/employee" + emp.getEmploy_id() + ".html");
            if (f1.createNewFile()) {
                FileWriter writer = new FileWriter(f1);
                writer.write("<html>");
                writer.write("<head>");
                writer.write("<title>Employee Details</title>");
                writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../asset/style.css\">");
                writer.write("</head>");
                writer.write("<body>");
                writer.write("<div class=\"container\">");
                writer.write("<h1 class=\"title\">Employee Details</h1>");
                writer.write("<div class=\"details\">");
                writer.write("<p><strong>Employee ID:</strong> <span class=\"fade-in\">" + emp.getEmploy_id() + "</span></p>");
                writer.write("<p><strong>Name:</strong> <span class=\"fade-in\">" + emp.getName() + "</span></p>");
                writer.write("<p><strong>Contact:</strong> <span class=\"fade-in\">" + emp.getEmploy_contact() + "</span></p>");
                writer.write("<p><strong>Email:</strong> <span class=\"fade-in\">" + emp.getEmail() + "</span></p>");
               // writer.write("<p><strong>Father's Name:</strong> <span class=\"fade-in\">" + em() + "</span></p>");
                writer.write("<p><strong>Position:</strong> <span class=\"fade-in\">" + emp.getPosition() + "</span></p>");
                writer.write("<p><strong>Salary:</strong> <span class=\"fade-in\">" + emp.getEmploy_salary() + "</span></p>");
                writer.write("</div>");
                writer.write("<a href=\"../salarydata/employee"+emp.getEmploy_id()+".html\" class=\"button-3d\">View Salary Details</a>");
                writer.write("</div>");
                writer.write("<script src=\"../asset/script.js\"></script>");
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

    @Override
    public void listUserdataFiles() throws IOException {

    }

    @Override
    public void removeFile(String id) throws IOException {

    }

    @Override
    public void viewFile(String id) throws IOException {

    }

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {

    }
}