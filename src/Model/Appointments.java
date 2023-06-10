/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hassan
 */
public class Appointments {

    private int id;
    private String appointment_date;
    private String appointment_day;
    private String appointment_time;
    private String status;//enum("free","booked")

    public Appointments(int id, String appointment_date, String appointment_day, String appointment_time, String status) {
        this.id = id;
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void storeAppointment(Appointments appointments) {
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO appointments (appointment_date, appointment_day, appointment_time, status) VALUES (?, ?, ?, ?)");
            statement.setString(1, appointments.getAppointment_date());
            statement.setString(2, appointments.getAppointment_day());
            statement.setString(3, appointments.getAppointment_time());
            statement.setString(4, appointments.getStatus());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Appointments> getAllFreeAppointments() {
        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appointments WHERE status='free'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String appointment_date = resultSet.getString("appointment_date");
                String appointment_day = resultSet.getString("appointment_day");
                String appointment_time = resultSet.getString("appointment_time");
                String status = resultSet.getString("status");

                Appointments app = new Appointments(id, appointment_date, appointment_day, appointment_time, status);
                appointmentList.add(app);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public static ObservableList<Appointments> getAllBookedAppointments() {
        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appointments WHERE status='booked'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String appointment_date = resultSet.getString("appointment_date");
                String appointment_day = resultSet.getString("appointment_day");
                String appointment_time = resultSet.getString("appointment_time");
                String status = resultSet.getString("status");

                Appointments app = new Appointments(id, appointment_date, appointment_day, appointment_time, status);
                appointmentList.add(app);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public void deleteFromDatabase() {
        try {
            Connection connection = DB.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM appointments WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(Appointments app) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int rowsAffected = 0;
        String sql = "UPDATE APPOINTMENTS SET appointment_date = ?, appointment_day = ?, appointment_time = ?, status = ? WHERE id = ?";
        ps = c.prepareStatement(sql);
        ps.setString(1, app.getAppointment_date());
        ps.setString(2, app.getAppointment_day());
        ps.setString(3, app.getAppointment_time());
        ps.setString(4, app.getStatus());
        ps.setInt(5, app.getId());

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
