package Tahsel.Database;

import Tahsel.Objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseBuilder {

    private static Connection connection;

    public static void createAllTables() {
        connectdbTables();
        try {
            createCommentsTable();
            createUsersTable();
            createNoReplyParent();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void connectdbTables() {
        try {
            DatabaseBuilder.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (DatabaseBuilder.connection == null) {
            System.exit(1);
        }
    }

    public static void createCommentsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS comments ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + // Use AUTOINCREMENT for auto-generated IDs
                "parent_id INTEGER,"
                + "comment TEXT,"
                + "created_by TEXT,"
                + "to_collect DOUBLE,"
                + "remaining DOUBLE,"
                + "total_owed DOUBLE,"
                + "date_to_collect DATE,"
                + "date_created DATE);";

        // Check if the table exists
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='comments'");
        if (!resultSet.next()) {
            System.out.println("Building the comments table...");
            // Create the table
            statement.execute(sql);
        } else {
            System.out.println("Table 'comments' already exists.");
        }

        // Clean up
        statement.close();
        resultSet.close();
    }

    public static void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE users("
                + "id               STRING  PRIMARY KEY,"
                + "name             STRING,"
                + "password         STRING);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='users'");
        if (!resultSet.next()) {
            System.out.println("Building the users table");
            Statement createTableStatement = connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
            DatabaseHelper.addUser(new User("100", "ַֿדה", "pass"));
        }
        statement.close();
        resultSet.close();

    }

    public static void createNoReplyParent() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS no_reply_parent ("
           + "parent_id INTEGER PRIMARY KEY, "
           + "updated_by TEXT, "
           + "date_updated DATE, "
           + "no_reply_flag BOOLEAN DEFAULT 0);";
        
//        String sql = "CREATE TABLE IF NOT EXISTS no_reply_parent ("
//                + "parent_id INTEGER PRIMARY KEY,"
//                + "updated_by TEXT,"
//                + "date_updated DATE);";

        // Check if the table exists
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='no_reply_parent'");
        if (!resultSet.next()) {
            System.out.println("Building the no_reply_parent table...");
            // Create the table
            statement.execute(sql);
        } else {
            System.out.println("Table 'no_reply_parent' already exists.");
        }

        // Clean up
        statement.close();
        resultSet.close();
    }

}
