package onlineSchool.databases;


import java.sql.*;


public class SchemaConnection {

    String url = "jdbc:mysql://127.0.0.1:3306/onlineschool";
    String username = "Serhii Mashkovets";
    String password = "Mashkovets";

    public void setConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection success");

            String sql = "SELECT * FROM students;";
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    int id = result.getInt("student_id");
                    String name = result.getString("student_name");
                    String surname = result.getString("student_surname");
                    String email = result.getString("student_email");
                    System.out.println("id: " + id + ", name: " + name + ", surname: " + surname + ", email: " + email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
            ex.printStackTrace();
        }


        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SchemaConnection schemaConnection = new SchemaConnection();
        schemaConnection.setConnection();
    }
}

