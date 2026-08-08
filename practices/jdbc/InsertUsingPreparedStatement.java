package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertUsingPreparedStatement {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "MYDB4PM";
        String password = "MYDB4PM";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            IO.println("Connection Established Successfully");

            int rollno = Integer.parseInt(IO.readln("Enter roll no:"));
            String name = IO.readln("Enter Name:");
            int marks = Integer.parseInt(IO.readln("Enter marks"));

            CallableStatement cstmt = con.prepareCall("call insertpro(?,?,?)");

            cstmt.setInt(1, rollno);
            cstmt.setString(2, name);
            cstmt.setInt(3, marks);

            cstmt.execute();
            IO.println("One Record Inserted Successfully.......");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}