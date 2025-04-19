package Tahsel.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String SQCONN = "jdbc:sqlite:T:\\Database\\sunrise.sqlite";
//    private static final String SQCONN = "jdbc:sqlite:Database/sunrise.sqlite";

    public static Connection getConnection() throws SQLException {
        // Define the path for the "Sunrise" folder inside Documents
        File excelFolder = new File("Database");

        // Check if the Sunrise folder exists, if not, create it
        if (!excelFolder.exists()) {
            boolean created = excelFolder.mkdir(); // Create the Sunrise folder
            if (created) {
                System.out.println("Folder 'Database' was created inside Documents.");
            } else {
                System.out.println("Failed to create 'Database' folder.");
            }
        }

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
