   import java.io.FileWriter;
import java.io.IOException;

public class SalaryCalculator extends SalaryMaths implements Calculations{

    public static void generateSalarySummary(SalaryMaths salaryMaths, EmployDetail employee) {
        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<!DOCTYPE html>");
        htmlContent.append("<html>");
        htmlContent.append("<head>");
        htmlContent.append("<title>Yearly Salary Summary</title>");
        htmlContent.append("<style>");
        htmlContent.append("table { width: 70%; border-collapse: collapse; margin: 20px auto; }");
        htmlContent.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
        htmlContent.append("th { background-color: #f4f4f4; }");
        htmlContent.append("</style>");
        htmlContent.append("</head>");
        htmlContent.append("<body>");
        htmlContent.append("<h1 style='text-align: center;'>Yearly Salary Summary</h1>");
        htmlContent.append("<table>");
        htmlContent.append("<tr><th>Month</th><th>Days in Month</th><th>Daily Salary (LKR)</th><th>Monthly Salary (LKR)</th></tr>");

        int totalDays = 0;
        double totalSalary = 0;

        for (int month = 1; month <= 12; month++) {
            int daysInMonth = salaryMaths.daysInMonth(month);
            double monthlySalary = employee.getSalary();
            double dailySalary = monthlySalary / daysInMonth;

            totalDays += daysInMonth;
            totalSalary += monthlySalary;

            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(getMonthName(month)).append("</td>");
            htmlContent.append("<td>").append(daysInMonth).append("</td>");
            htmlContent.append("<td>").append(String.format("LKR %.2f", dailySalary)).append("</td>");
            htmlContent.append("<td>").append(String.format("LKR %.2f", monthlySalary)).append("</td>");
            htmlContent.append("</tr>");
        }

        htmlContent.append("<tr><th>Total</th><th>").append(totalDays).append("</th><th>-</th><th>")
                .append(String.format("LKR %.2f", totalSalary)).append("</th></tr>");
        htmlContent.append("</table>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");

        // Write the HTML content to a file
        try (FileWriter fileWriter = new FileWriter("YearlySalarySummary.html")) {
            fileWriter.write(htmlContent.toString());
            System.out.println("Yearly salary summary generated successfully in 'YearlySalarySummary.html'.");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the summary: " + e.getMessage());
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

