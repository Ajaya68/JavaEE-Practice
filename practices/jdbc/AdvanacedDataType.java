package jdbc;

import java.io.FileInputStream;
import java.sql.*;

public class AdvanacedDataType {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "MYDB4PM";
        String password = "MYDB4PM";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            IO.println("Connection Established Successfully");

            String img = IO.readln("Enter image path :");
            PreparedStatement pstmt = con.prepareStatement("insert into image values(?)");
            FileInputStream fis = new FileInputStream(img);
            pstmt.setBinaryStream(1, fis, fis.available());
            // pstmt.setString(1, img);
            pstmt.executeUpdate();

            IO.println("Successfully inserted Image");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
