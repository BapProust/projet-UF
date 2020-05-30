import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;

class mysql {
    static Connection sql() throws ClassNotFoundException, SQLException, IOException {
        //connexion à la base de données
        Properties p = new Properties();
        p.load(new FileInputStream("db.ini"));

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String servername = p.getProperty("servername");
        String database = p.getProperty("database");
        String user = p.getProperty("user");
        String pass = p.getProperty("pass");

        String url = "jdbc:mysql://" + servername + "/" + database;

        return DriverManager.getConnection(url, user, pass);
    }
}