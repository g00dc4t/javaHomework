import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "password";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name AS Courses,\n" +
                    "SUM(Grp.count_all) / COUNT(Grp.date) AS AVG_inMonth \n" +
                    "FROM Courses \n" +
                    "JOIN (SELECT course_name, MONTH(subscription_date) date, COUNT(*) count_all FROM PurchaseList GROUP BY course_name, date) Grp ON name = course_name\n" +
                    "GROUP BY name;");
            while (resultSet.next()) {
                String courseName = resultSet.getString("Courses");
                String avgNumber = resultSet.getString("AVG_inMonth");
                System.out.println(courseName + " - " + avgNumber);
            }
            resultSet.close();
            statement.close();
            connection.close();

//            prpdStmnt(url, user, pass, 3); // Prepared statement
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void prpdStmnt(String url, String user, String pass, int integer) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pass);
        String querySQL = "SELECT * FROM teachers ORDER BY name LIMIT ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
        preparedStatement.setInt(1, integer);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String courseName = resultSet.getString("Name");
            System.out.println(courseName);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}