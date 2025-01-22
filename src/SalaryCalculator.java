import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalaryCalculator extends SalaryMaths implements Calculations {

    public static void generateSalarySummary(String empID, SalaryMaths salaryMaths, double monthlySalary) throws IOException {
        // Ensure the directory exists
        File directory = new File(FileFunctions.SALARY_DATA_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the HTML file for the employee
        File f1 = new File(directory, "employee" + empID + ".html");
        if (f1.createNewFile()) {
            try (FileWriter htmlContent = new FileWriter(f1)) {
                htmlContent.write("<!DOCTYPE html>");
                htmlContent.write("<html>");
                htmlContent.write("<head>");
                htmlContent.write("<title>Yearly Salary Summary</title>");
                htmlContent.write("<style>");
                htmlContent.write("table { width: 70%; border-collapse: collapse; margin: 20px auto; }");
                htmlContent.write("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
                htmlContent.write("th { background-color: #f4f4f4; }");
                htmlContent.write("</style>");
                htmlContent.write("</head>");
                htmlContent.write("<body>");
                htmlContent.write("<h1 style='text-align: center;'>Yearly Salary Summary</h1>");
                htmlContent.write("<table>");
                htmlContent.write("<tr><th>Month</th><th>Days in Month</th><th>Daily Salary (LKR)</th><th>Monthly Salary (LKR)</th></tr>");

                int totalDays = 0;
                double totalSalary = 0;

                for (int month = 1; month <= 12; month++) {
                    int daysInMonth = salaryMaths.daysInMonth(month);
                    double dailySalary = monthlySalary / daysInMonth;

                    totalDays += daysInMonth;
                    totalSalary += monthlySalary;

                    htmlContent.write("<tr>");
                    htmlContent.write("<td>");
                    htmlContent.write(getMonthName(month));
                    htmlContent.write("</td>");
                    htmlContent.write("<td>");
                            htmlContent.write(String.valueOf(daysInMonth));
                            htmlContent.write("</td>");
                    htmlContent.write("<td>");
                            htmlContent.write(String.format("LKR %.2f", dailySalary));
                            htmlContent.write("</td>");
                    htmlContent.write("<td>");
                            htmlContent.write(String.format("LKR %.2f", monthlySalary));
                            htmlContent.write("</td>");
                    htmlContent.write("</tr>");
                }

                htmlContent.write("<tr><th>Total</th><th>");
            htmlContent.write(String.valueOf(totalDays));
            htmlContent.write("</th><th>-</th><th>");
                      htmlContent.write(String.format("LKR %.2f", totalSalary));
                      htmlContent.write("</th></tr>");
                htmlContent.write("</table>");
                htmlContent.write("</body>");
                htmlContent.write("</html>");
            }
            System.out.println("Yearly salary summary generated successfully in 'employee" + empID + ".html'.");
        } else {
            System.out.println("File 'employee" + empID + ".html' already exists.");
        }
    }

    private static String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }
}