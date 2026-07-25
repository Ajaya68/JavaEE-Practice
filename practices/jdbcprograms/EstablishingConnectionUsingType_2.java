/*JDBC Program to establish connection between java application and oracle 
database by using type-2 driver */


import java.sql.*;

public class EstablishingConnectionUsingType_2 {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@orcl", "SYSTEM", "LION");
            System.err.println("Connection Established successfully");
        } catch (ClassNotFoundException ce) {
            System.err.println(ce);
        } catch (SQLException se) {
            System.err.println(se);
        }
    }
}