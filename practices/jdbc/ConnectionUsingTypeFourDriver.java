package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUsingTypeFourDriver {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "MYDB4PM";
        String password = "MYDB4PM";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            IO.println("Connection Established Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
}
