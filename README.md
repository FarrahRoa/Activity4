## Invoice System MySQL Database and Java Application

This repository contains MySQL code to create tables for an invoice system and a Java application (`act5.java`) to interact with the database.
The Invoice System MySQL Database Schema contains the following Tables:
## 1. Clients
   Contains information about individual clients, including their unique identifier, name, email address, phone number, and physical address.
   
## 2. Service_Booking
   Contains the record bookings made by clients, with details such as a unique booking identifier, the associated client, the date of booking, and a description of the service.
   
## 5. Invoices 
   Contains  details of invoices issued to clients for their bookings are stored. This includes a unique invoice identifier, the client associated with the invoice, the booking for which the invoice was issued, the date of the invoice, and the total amount due.
   
## 6. Service_Inquiry 
   Keeps track of inquiries made by clients regarding services. It includes a unique inquiry identifier, the client making the inquiry, the date of the inquiry, and the details of the inquiry.
   
## 7. Payment 
   Contains ayments made by clients for their invoices are recorded in the Payment table. This table includes a unique payment identifier, the invoice for which the payment was made, the amount paid, and the date of payment.


## The Java application interacts with the database to perform the following tasks:
- Retrieve and display information from the `Clients`, `Invoices`, `Service_Booking`, `Service_Inquiry`, and `Payment` tables.
- Establishes a connection to the MySQL database using JDBC.

## Instructions
1. Ensure MySQL is installed on your system.
2. Run the MySQL script provided to create the database and tables.
3. Compile and run the Java application (`act5.java`) to interact with the database.





