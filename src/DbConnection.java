
import java.sql.DriverManager;
import java.sql.Connection;

public class DbConnection {

    public Connection getConnection() throws Exception {
        encrypt ery = new encrypt();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                " ", ery.getDbUserName(), ery.getDbPassword());
        return connection;

    }
}
