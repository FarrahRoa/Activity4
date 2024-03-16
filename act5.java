import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class act5 {
   
        public static void main(String[] args) {
            try (
               Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/InvoiceSystem", "ppg", "farrahkim12-");   
               Statement stmt = conn.createStatement();
            ) {
              
               String selectClients = "SELECT * FROM Clients";
               ResultSet clientsResult = stmt.executeQuery(selectClients);
               System.out.println("Clients table:");
               while(clientsResult.next()) {   
                  String clientId = clientsResult.getString("client_id");
                  String name = clientsResult.getString("name");
                  String email = clientsResult.getString("email");
                  String phone = clientsResult.getString("phone");
                  String address = clientsResult.getString("address");
                  System.out.println(clientId + ", " + name + ", " + email + ", " + phone + ", " + address);
               }
               System.out.println();
      
             
               String selectInvoices = "SELECT * FROM Invoices";
               ResultSet invoicesResult = stmt.executeQuery(selectInvoices);
               System.out.println("Invoices table:");
               while(invoicesResult.next()) {   
                 String invoiceId = invoicesResult.getString("invoice_id");
                String clientId = invoicesResult.getString("client_id");
                  Date invoiceDate = invoicesResult.getDate("invoice_date");
                  double totalAmount = invoicesResult.getDouble("total_amount");
                  System.out.println(invoiceId + ", " + clientId + ", " + invoiceDate + ", " + totalAmount);
               }
               System.out.println();
      
         
               String selectServiceBooking = "SELECT * FROM Service_Booking";
               ResultSet serviceBookingResult = stmt.executeQuery(selectServiceBooking);
               System.out.println("Service_Booking table:");
               while(serviceBookingResult.next()) {   
                  String bookingId = serviceBookingResult.getString("booking_id");
                  String clientId = serviceBookingResult.getString("client_id");
                  Date bookingDate = serviceBookingResult.getDate("booking_date");
                  String serviceDescription = serviceBookingResult.getString("service_description");
                  System.out.println(bookingId + ", " + clientId + ", " + bookingDate + ", " + serviceDescription);
               }
               System.out.println();
      
              
               String selectServiceInquiry = "SELECT * FROM Service_Inquiry";
               ResultSet serviceInquiryResult = stmt.executeQuery(selectServiceInquiry);
               System.out.println("Service_Inquiry table:");
               while(serviceInquiryResult.next()) {   
                  String inquiryId = serviceInquiryResult.getString("inquiry_id");
                  String clientId = serviceInquiryResult.getString("client_id");
                  Date inquiryDate = serviceInquiryResult.getDate("inquiry_date");
                  String inquiryDetails = serviceInquiryResult.getString("inquiry_details");
                  System.out.println(inquiryId + ", " + clientId + ", " + inquiryDate + ", " + inquiryDetails);
               }
               System.out.println();
      
               
               String selectPayment = "SELECT * FROM Payment";
               ResultSet paymentResult = stmt.executeQuery(selectPayment);
               System.out.println("Payment table:");
               while(paymentResult.next()) {   
                  String paymentId = paymentResult.getString("payment_id");
                  String invoiceId = paymentResult.getString("invoice_id");
                  double amountPaid = paymentResult.getDouble("amount_paid");
                  Date paymentDate = paymentResult.getDate("payment_date");
                  System.out.println(paymentId + ", " + invoiceId + ", " + amountPaid + ", " + paymentDate);
               }
               System.out.println();
      
            } catch(SQLException ex) {
               ex.printStackTrace();
            }
         }
      }