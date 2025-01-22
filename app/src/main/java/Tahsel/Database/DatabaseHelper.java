package Tahsel.Database;

import Tahsel.Objects.Comment;
import Tahsel.Objects.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper {

    private static Connection connection;

    public static void connectdbTables() {
        try {
            DatabaseHelper.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (DatabaseHelper.connection == null) {
            System.exit(1);
        }
    }

    //Comment
    public static void addComment(Comment comment) {
        try {
            privateAddComment(comment);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void privateAddComment(Comment comment) throws SQLException {
        connectdbTables();
        String insertSQL = "INSERT INTO comments (parent_id ,comment, to_collect, remaining, total_owed, date_to_collect, date_created,created_by) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setInt(1, comment.getParentID());
        preparedStatement.setString(2, comment.getComment());
        preparedStatement.setDouble(3, comment.getToGetCollected());
        preparedStatement.setDouble(4, comment.getRemaining());
        preparedStatement.setDouble(5, comment.getTotalOwed());
        preparedStatement.setDate(6, new java.sql.Date(comment.getDateToCollect().getTime()));
        preparedStatement.setDate(7, new java.sql.Date(comment.getDateCreated().getTime()));
        preparedStatement.setString(8, comment.getCreatedBy());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

//    public static void updateUser(User user){
//        try {
//            privatUpdateUser(user);
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private static void privatUpdateUser(User user) throws SQLException{
//        connectdbTables();
//        
//        String updateSQL = "UPDATE users SET name = ?, password = ? WHERE id = ? ";
//        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
//        preparedStatement.setString(1, user.getName());
//        preparedStatement.setString(2, user.getPassword());
//        preparedStatement.setString(3,user.getId());
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
//    }
    //Users
    public static void addUser(User user) {
        try {
            privateAddUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void privateAddUser(User user) throws SQLException {
        connectdbTables();

        String insertSQL = "INSERT INTO users (id,password,name) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void updateUser(User user) {
        try {
            privatUpdateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void privatUpdateUser(User user) throws SQLException {
        connectdbTables();

        String updateSQL = "UPDATE users SET name = ?, password = ? WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    // Delete all comments

    public static void deleteAllComments() {
        try {
            privateDeleteAllComments();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void privateDeleteAllComments() throws SQLException {
        // Connect to the database (make sure you have your connection logic in place)
        connectdbTables();

        // Disable auto-commit mode
        connection.setAutoCommit(false);

        // SQL statement to delete all rows from the comments table
        String deleteSQL = "DELETE FROM comments";

        // Prepare the statement
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

        // Execute the delete statement
        preparedStatement.executeUpdate();

        // Commit the changes (now that auto-commit is disabled)
        connection.commit();

        // Close the prepared statement
        preparedStatement.close();

        // Re-enable auto-commit mode if needed (optional, if you need auto-commit for future queries)
        connection.setAutoCommit(true);
    }

}
