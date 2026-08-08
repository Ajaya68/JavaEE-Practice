package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BetchProgram {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "MYDB4PM";
        String password = "MYDB4PM";
        String insertQuery = "insert into student values(107,'naresh',30,'08-aug-2026')";
        String updateQuery = "update student set marks = 99 where rollno=103";
        String deleteQuery = "delete from student where rollno=105";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            IO.println("Connection Established Successfully");

            Statement stmt = con.createStatement();
            stmt.addBatch(insertQuery);
            stmt.addBatch(deleteQuery);
            stmt.addBatch(updateQuery);
            stmt.executeBatch();

            IO.readln("Successfully Executed all Command");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
