package Tahsel.Database;

import Tahsel.Objects.Comment;
import Tahsel.Objects.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchHelper {

    private static Connection connection;

    public static void connectdbTables() {
        try {
            SearchHelper.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (SearchHelper.connection == null) {
            System.exit(1);
        }
    }

    public static ResultSet getLoginTable(String user, String pass, String opt) throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM login WHERE username = ? AND password = ? AND division = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, opt);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            //System.out.println("DatabseTable0: "+resultSet.next());
            return resultSet;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            //mSystem.out.println("DatabseTable: "+resultSet.next());
            preparedStatement.close();
            resultSet.close();
        }
    }

    //=========================================== Users =====================================
    public static ArrayList<User> getUsers() {
        try {
            return PrivateGetUsers();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static ArrayList<User> PrivateGetUsers() throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<User> list = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public static ArrayList<String> getAllUserIDs() {
        try {
            return PrivateGetAllUserIDs();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static ArrayList<String> PrivateGetAllUserIDs() throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id FROM users";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<String> list = new ArrayList<>();

            while (resultSet.next()) {
                list.add(resultSet.getString("id"));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public static User getUserByID(String id) {
        try {
            return privateGetUserByEmployeeID(id);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static User privateGetUserByEmployeeID(String id) throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users where id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<User> list = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));

                list.add(user);
            }
            try {
                return list.get(0);
            } catch (Exception e) {
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    //=========================================== Comments =====================================
    public static ArrayList<Comment> getCommentsByParentID(int id) {
        try {
            return privateGetCommentsByParentID(id);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static ArrayList<Comment> privateGetCommentsByParentID(int id) throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM comments where parent_id=? ORDER BY date_created DESC";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Comment> list = new ArrayList<>();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setParentID(resultSet.getInt("parent_id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setToGetCollected(resultSet.getDouble("to_collect"));
                comment.setRemaining(resultSet.getDouble("remaining"));
                comment.setTotalOwed(resultSet.getDouble("total_owed"));
                comment.setDateToCollect(resultSet.getDate("date_to_collect"));
                comment.setDateCreated(resultSet.getDate("date_created"));
                comment.setCreatedBy(resultSet.getString("created_by"));
                list.add(comment);
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
  
    
    public static Map<Integer, ArrayList<Comment>> getComments() {
        try {
            return PrivateGetComments();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Map<Integer, ArrayList<Comment>> PrivateGetComments() throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM comments ORDER BY date_created DESC";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            Map<Integer, ArrayList<Comment>> commentMap = new HashMap<>();
            
            
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setParentID(resultSet.getInt("parent_id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setCreatedBy(resultSet.getString("created_by"));
                comment.setToGetCollected(resultSet.getDouble("to_collect"));
                comment.setRemaining(resultSet.getDouble("remaining"));
                comment.setTotalOwed(resultSet.getDouble("total_owed"));
                comment.setDateToCollect(resultSet.getDate("date_to_collect"));
                comment.setDateCreated(resultSet.getDate("date_created"));
                int parentID = comment.getParentID();
            if (!commentMap.containsKey(parentID)) {
                commentMap.put(parentID, new ArrayList<>());
            }
            commentMap.get(parentID).add(comment);
            }

            return commentMap;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    
    
    public static Map<String, ArrayList<Comment>> getCommentsMapWithUser() {
        try {
            return PrivateGetCommentsMapWithUser();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Map<String, ArrayList<Comment>> PrivateGetCommentsMapWithUser() throws Exception {
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM comments ORDER BY date_created DESC";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            Map<String, ArrayList<Comment>> commentMap = new HashMap<>();
            
            
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setParentID(resultSet.getInt("parent_id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setCreatedBy(resultSet.getString("created_by"));
                comment.setToGetCollected(resultSet.getDouble("to_collect"));
                comment.setRemaining(resultSet.getDouble("remaining"));
                comment.setTotalOwed(resultSet.getDouble("total_owed"));
                comment.setDateToCollect(resultSet.getDate("date_to_collect"));
                comment.setDateCreated(resultSet.getDate("date_created"));
                String userName = comment.getCreatedBy();
            if (!commentMap.containsKey(userName)) {
                commentMap.put(userName, new ArrayList<>());
            }
            commentMap.get(userName).add(comment);
            }

            return commentMap;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    public static ArrayList<Comment> getTopTwoCommentsByParent(int parentID) {
        try {
            return fetchTopTwoCommentsByParent(parentID);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    private static ArrayList<Comment> fetchTopTwoCommentsByParent(int parentID) throws Exception {
        connectdbTables();  // Your DB connection method
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM comments WHERE parent_id = ? ORDER BY date_created DESC LIMIT 2";

        ArrayList<Comment> topTwo = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, parentID); // ? bind the parent_id
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setParentID(resultSet.getInt("parent_id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setCreatedBy(resultSet.getString("created_by"));
                comment.setToGetCollected(resultSet.getDouble("to_collect"));
                comment.setRemaining(resultSet.getDouble("remaining"));
                comment.setTotalOwed(resultSet.getDouble("total_owed"));
                comment.setDateToCollect(resultSet.getDate("date_to_collect"));
                comment.setDateCreated(resultSet.getDate("date_created"));

                topTwo.add(comment);
            }

            return topTwo;

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }


}
