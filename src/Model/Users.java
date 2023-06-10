/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hassan
 */
public class Users {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String phone;
    private String gender;//enum("male","female")
    private String role;//enum("user","admin")

    public Users(int id, String username, String password, String firstname, String lastname, int age, String email, String phone, String gender, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static Users getUserByUsernameAndPassword(String username, String password) {
        Users user = null;
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = 'patient'");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");

                user = new Users(id, username, password, firstName, lastName, age, email, phone, gender, role);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //////////////////////////////////
    public static Users getAdminByUsernameAndPassword(String username, String password) {
        Users user = null;
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = 'admin'");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");

                user = new Users(id, username, password, firstName, lastName, age, email, phone, gender, role);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void storeUser(Users user) {
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, firstname, lastname, age, email, phone, gender, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstname());
            statement.setString(4, user.getLastname());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhone());
            statement.setString(8, user.getGender());
            statement.setString(9, user.getRole());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> userList = FXCollections.observableArrayList();
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE role='patient'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");

                Users user = new Users(id, username, password, firstName, lastName, age, email, phone, gender, role);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteFromDatabase() {
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Users> getUsersByUsername(String username) {
        ObservableList<Users> userList = FXCollections.observableArrayList();
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND role='patient'");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username2 = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                String role = resultSet.getString("role");

                Users user = new Users(id, username2, password, firstName, lastName, age, email, phone, gender, role);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public int update(Users user) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rowsAffected = 0;
        String sql = "UPDATE USERS SET username = ?, password = ?, firstname = ?, lastname = ?, email = ?, phone = ?, gender = ?, Role = ? WHERE id = ?";
        ps = c.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstname());
        ps.setString(4, user.getLastname());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getPhone());
        ps.setString(7, user.getGender());
        ps.setString(8, user.getRole());
        ps.setInt(9, user.getId());

        rowsAffected = ps.executeUpdate();
        c.close();
        return rowsAffected;
    }

//    public static Users getUserByUsername(String username) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        Users user = null;
//
//        try {
//            // Establishing a database connection
//            connection = DB.getInstance().getConnection();
//
//            // Preparing the SQL statement
//            String sql = "SELECT * FROM USERS WHERE username = ?";
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, username);
//
//            // Executing the query
//            resultSet = statement.executeQuery();
//
//            // Checking if the user exists and creating the Users object
//            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String password = resultSet.getString("password");
//                String firstName = resultSet.getString("firstname");
//                String lastName = resultSet.getString("lastname");
//                int age = resultSet.getInt("age");
//                String email = resultSet.getString("email");
//                String phone = resultSet.getString("phone");
//                String gender = resultSet.getString("gender");
//                String role = resultSet.getString("role");
//
//                user = new Users(id, username, password, firstName, lastName, age, email, phone, gender, role);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Closing the database resources
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return user;
//    }
//   
}
