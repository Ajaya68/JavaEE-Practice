/*JDBC Program to create table using type-4 driver*/
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "MYDB4PM";
        String password = "MYDB4PM";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);
            IO.println("Connection Established Successfully");
            Statement stmt = con.createStatement();
            stmt.execute("create table student(rollno number(3),name varchar2(20),marks number(3))");
            IO.println("Table Created Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
