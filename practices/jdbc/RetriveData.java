/*Retrive Data from table */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveData {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "MYDB4PM";
        String password = "MYDB4PM";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            IO.println("Connection Established Successfully");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
