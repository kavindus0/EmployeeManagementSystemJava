import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmergencyContactAddPage extends EmergencyContact implements FileFunctions {

    private EmployDetail emp;

    public EmergencyContactAddPage(EmployDetail emp) {
        super(emp.getEmergencyContact_name(), emp.getEmergencyContact_contact(), emp.getEmergencyContact_email(), emp.getEmergencyContact_address());
        this.emp = emp;
    }

    // Method to create an HTML file for the emergency contact
    @Override
    public void createFileBaseHTML() throws IOException {
        try {
           File directory = new File("./emergencydata");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the HTML file for the employee
        File file = new File(directory, "emergency_" + emp.getEmploy_id() + ".html");

            if (file.createNewFile()) {
                try (FileWriter writer = new FileWriter(file)) {
                    // Write HTML content to the file
                    writer.write("<html>");
                    writer.write("<head>");
                    writer.write("<title>Emergency Contact Details</title>");
                    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../asset/style.css\">");
                    writer.write("</head>");
                    writer.write("<body>");
                    writer.write("<div class=\"container\">");
                    writer.write("<h1 class=\"title\">Emergency Contact Details</h1>");
                    writer.write("<div class=\"details\">");
                    writer.write("<p><strong>Name:</strong> <span class=\"fade-in\">" + getName() + "</span></p>");
                    writer.write("<p><strong>Contact No:</strong> <span class=\"fade-in\">" + getContactNo() + "</span></p>");
                    writer.write("<p><strong>Email:</strong> <span class=\"fade-in\">" + getEmail() + "</span></p>");
                    writer.write("<p><strong>Address:</strong> <span class=\"fade-in\">" + getAddress() + "</span></p>");
                    writer.write("</div>");
                    writer.write("</div>");
                    writer.write("<script src=\"../asset/script.js\"></script>");
                    writer.write("</body>");
                    writer.write("</html>");

                    System.out.println("\nEmergency contact has been added successfully: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("\nEmergency contact already exists!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Override methods from FileFunctions interface (not used in this context)
    @Override
    public void listUserdataFiles() throws IOException {
        // Not implemented for emergency contacts
    }

    @Override
    public void removeFile(String id) throws IOException {
        // Not implemented for emergency contacts
    }

    @Override
    public void viewFile(String id) throws IOException {
        // Not implemented for emergency contacts
    }

    @Override
    public void updateFile(String id, String oldData, String newData) throws IOException {
        // Not implemented for emergency contacts
    }
}