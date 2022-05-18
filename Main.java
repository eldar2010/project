
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class Main {

    public static ArrayList<course> course = new ArrayList<course>();
    public static ArrayList<student> student = new ArrayList<>();
    public static ArrayList<prepod> prepod = new ArrayList<>();
    public static ArrayList<student> archive = new ArrayList<>();


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "123456789")) {
                PreparedStatement statement = connection.prepareStatement("select name, hours from course");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    course course1 = new course(resultSet.getString("name"), resultSet.getInt("hours"));
                    course.add(course1);
                }
                PreparedStatement statement1 = connection.prepareStatement("select name, surname from prepod");
                ResultSet resultSet1 = statement1.executeQuery();
                while (resultSet1.next()) {
                    prepod prepod1 = new prepod(resultSet1.getString("name"), resultSet1.getString("surname"));
                    prepod.add(prepod1);
                }
                PreparedStatement statement2 = connection.prepareStatement("select name, surname, faculty from student");
                ResultSet resultSet2 = statement2.executeQuery();
                while (resultSet2.next()) {
                    student student1 = new student(resultSet2.getString("name"), resultSet2.getString("surname"),
                            resultSet2.getString("faculty"), resultSet2.getString("faculty"));
                    student.add(student1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            new GridLayoutCustom();
        } catch (Exception ex) {
        }
    }
}
