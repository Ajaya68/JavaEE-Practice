package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsertDate {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "MYDB4PM";
        String password = "MYDB4PM";
        String insertDateQuery = "insert into student values(?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);

            int rollno = Integer.parseInt(IO.readln("Enter Roll No"));
            String name = IO.readln("Enter Name");
            int marks = Integer.parseInt(IO.readln("Enter Marks"));
            Date date = Date.valueOf(IO.readln("Enter Enroll Date(yyyy-mm-dd):"));
            PreparedStatement pstmt = con.prepareStatement(insertDateQuery);
            pstmt.setInt(1, rollno);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);
            pstmt.setDate(4, date);
            int count = pstmt.executeUpdate();
            IO.println(count + " Row Inserted Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
