package jdbc;

import java.sql.*;

public class DynamicInsertRecord {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "MYDB4PM";
        String password = "MYDB4PM";
        String dynamicInsertQuery = "insert into student values(?,?,?)";

        try {
            // Loading Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establishing Connection
            Connection con = DriverManager.getConnection(url, username, password);
            IO.println("Connection Established Successfully");

            // Taking user input
            int rollno = Integer.parseInt(IO.readln("Enter Roll No"));
            String name = IO.readln("Enter Name");
            int marks = Integer.parseInt(IO.readln("Enter Marks"));

            // Creating preparedStatement for executing dynamic sql query.
            PreparedStatement pstmt = con.prepareStatement(dynamicInsertQuery);
            pstmt.setInt(1, rollno);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);
            int count = pstmt.executeUpdate();

            IO.println(count + " Row Inserted Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}