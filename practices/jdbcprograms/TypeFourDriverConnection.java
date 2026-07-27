import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TypeFourDriverConnection {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","LION");
            IO.println("Connection Established successfully");
        } catch (ClassNotFoundException | SQLException ce) {
            System.err.println(ce);
        }
    }
}
