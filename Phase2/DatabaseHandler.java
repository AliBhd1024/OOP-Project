import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {
    public Connection databaseLink;
    
    public Connection getConnection() throws Exception {
        String dbUser = "root" , dbPass = "123456897a#" , dbName = "snappfood_db_p1" , url = "jdbc:mysql://localhost/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url , dbUser , dbPass);

        return databaseLink;
    }
}