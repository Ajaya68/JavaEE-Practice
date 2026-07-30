/*JDBC Program to insert data into table. */
package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "MYDB4PM";
        String password = "MYDB4PM";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);
            IO.println("Connection Established Successfully....");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into student values(101,'Ajaya',100)");
            IO.println("1 Row inserted.......");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
