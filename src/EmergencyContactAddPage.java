import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmergencyContactAddPage extends EmergencyContact implements FileFunctions {

    public EmergencyContactAddPage(String name, String contactNo, String email, String address) {
        super(name, contactNo, email, address);
    }

    EmployDetail emp = new EmployDetail();

    EmergencyContact emCon = new EmergencyContact(emp.getName(), emp.getEmploy_contact(), emp.getEmail(), emp.getAddress());

    // Method to create an HTML file for the emergency contact
    public void createFileBaseHTML() throws IOException {
        try {
            // Create a new HTML file for the emergency contact
            File file = new File("./emergencydata/emergency_" +emCon.getName().replace(" ", "_") + ".html");
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);

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

                writer.close();
                System.out.println("\nEmergency contact has been added successfully!");
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