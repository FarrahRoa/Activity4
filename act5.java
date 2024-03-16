import java.sql.*;
import java.util.Scanner;

public class act5 {
   
    public static void main(String[] args) {
        try (
            Scanner scanner = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/InvoiceSystem", "ppg", "farrahkim12-");   
            Statement stmt = conn.createStatement();
        ) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Enter the task you want to perform (income, view, exit):");
                String task = scanner.nextLine().trim();

                switch (task.toLowerCase()) {
                    case "income":
                        // Calculate total income from Invoice table
                        String incomeQuery = "SELECT SUM(total_amount) AS total_income FROM Invoices";
                        ResultSet incomeResult = stmt.executeQuery(incomeQuery);
                        double totalIncome = 0;
                        if (incomeResult.next()) {
                            totalIncome = incomeResult.getDouble("total_income");
                            System.out.println("Total income from Invoices table: P" + totalIncome);
                        }
                        break;
                    case "view":
                        System.out.println("Enter the table name you want to view (Clients, Invoices, Service_Booking, Service_Inquiry, Payment):");
                        String tableName = scanner.nextLine().trim();

                        String selectQuery = "SELECT * FROM " + tableName;
                        ResultSet result = stmt.executeQuery(selectQuery);

                        System.out.println(tableName + " table:");
                        ResultSetMetaData metaData = result.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        while(result.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                System.out.print(metaData.getColumnLabel(i) + ": " + result.getString(i) + ", ");
                            }
                            System.out.println();
                        }
                        break;
                    case "exit":
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid task specified. Please try again.");
                        break;
                }
            }
      
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
