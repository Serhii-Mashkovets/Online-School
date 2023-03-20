package onlineSchool.databases;

import onlineSchool.Main;
import onlineSchool.loggingJournal.LoggingRepository;

import java.sql.*;


public class SchemaConnection {
    private static final LoggingRepository logRep = new LoggingRepository(Main.class.getName());

    String url = "onlineSchool.databases.SchemaConnection:mysql://127.0.0.1:3306/onlineschool";
    String username = "Serhii Mashkovets";
    String password = "Mashkovets";



public void createConnection () {
    logRep.infoLog("Початок роботи в класі SchemaConnection в методі create conection");

    Connection connection = null;

    try {
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {
        System.out.println("Connection Failed! Check output console");
        ex.printStackTrace();
    }
logRep.infoLog("Робимо запит в базу даних");
    String sql = "SELECT * FROM students;";
    try {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            int id = result.getInt("student_id");
            String name = result.getString("student_name");
            String surname = result.getString("student_surname");
            String email = result.getString("student_email");
            System.out.println("id: " + id + ", name: " + name + "surname: " + surname + "email: " + email);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        if (connection != null) {
            connection.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    logRep.infoLog("Кінець роботи в класі SchemaConnection в методі create connection");
}
}
