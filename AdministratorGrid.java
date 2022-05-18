import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministratorGrid {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu addPrepod;
    private JMenu addCourse;
    private JMenu addStudent;
    private JMenu exit;

    private JTextField addName;
    private JLabel labelName;
    private JTextField addSurname;
    private JLabel labelSurname;
    private JButton addButtonPrepod;
    private JButton updatePrepod;
    private JButton deletePrepod;
    private JPanel prepodPanel;
    private String deletePrepodId;
    private String updatePrepodId;

    private JTextField addCourseName;
    private JLabel labelCourseName;
    private JTextField addHours;
    private JLabel labelHours;
    private JButton addButtonCourse;
    private JButton updateCourse;
    private JButton deleteCourse;
    private JPanel coursePanel;
    private String deleteCourseId;
    private String updateCourseId;

    private JTextField addStudentName;
    private JLabel labelStudentName;
    private JTextField addStudentSurname;
    private JLabel labelStudentSurname;
    private JTextField addStudentFaculty;
    private JLabel labelStudentFaculty;
    private JButton addButtonStudent;
    private JButton updateStudent;
    private JButton deleteStudent;
    private JPanel studentPanel;
    private String deleteStudentId;
    private String updateStudentId;

    AdministratorGrid() {
        frame = new JFrame("Администратор");

        final Dialog modelDialog = new Dialog();

        frame.setLayout(null);

        addPrepod = new JMenu("Добавить преподавателя");
        addCourse = new JMenu("Добавить курс");
        addStudent = new JMenu("Регистрация студента");
        exit = new JMenu("Выйти");

        prepodPanel = new JPanel();
        prepodPanel.setBounds(400, 0, 350, 400);
        prepodPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список преподавателей", TitledBorder.CENTER, TitledBorder.TOP));
        prepodPanel.setVisible(true);
        prepodPanel.setLayout(new GridLayout(20, 1));

        coursePanel = new JPanel();
        coursePanel.setBounds(400, 0, 350, 400);
        coursePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список курсов", TitledBorder.CENTER, TitledBorder.TOP));
        coursePanel.setVisible(false);
        coursePanel.setLayout(new GridLayout(20, 1));

        studentPanel = new JPanel();
        studentPanel.setBounds(400, 0, 350, 400);
        studentPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список студентов", TitledBorder.CENTER, TitledBorder.TOP));
        studentPanel.setVisible(false);
        studentPanel.setLayout(new GridLayout(20, 1));

        int number = 1;

        for (prepod prepod : Main.prepod) {
            JLabel label = new JLabel(number + ". " + prepod.getFirstName() + " " + prepod.getSecondName(), SwingConstants.CENTER);
            prepodPanel.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    deletePrepodId = label.getText().substring(0,1);
                    updatePrepodId = deletePrepodId;
                    prepod prepod = Main.prepod.get(Integer.parseInt(updatePrepodId) - 1);
                    addName.setText(prepod.getFirstName());
                    addSurname.setText(prepod.getSecondName());
                }
            });
            number++;
        }

        updatePrepod = new JButton("Изменить");
        updatePrepod.setBounds(400, 400, 100, 30);
        updatePrepod.setVisible(true);
        frame.add(updatePrepod);
        updatePrepod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                prepod prepod = Main.prepod.get(Integer.parseInt(updatePrepodId) - 1);
                prepod.setFirstName(addName.getText());
                prepod.setSecondName(addSurname.getText());

                modelDialog.setText("Преподаватель изменен");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        deletePrepod = new JButton("Удалить");
        deletePrepod.setBounds(505, 400, 100, 30);
        deletePrepod.setVisible(true);
        deletePrepod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Main.prepod.remove(Integer.parseInt(deletePrepodId) - 1);
                modelDialog.setText("Перподаватель удален");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });
        frame.add(deletePrepod);

        frame.add(prepodPanel);

        int numberCourse = 1;

        for (course course : Main.course) {
            JLabel label = new JLabel(numberCourse + ". " + course.getCourseName() + " " + course.getHoureNum() + " ч", SwingConstants.CENTER);
            coursePanel.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    deleteCourseId = label.getText().substring(0,1);
                    updateCourseId = deleteCourseId;
                    course course = Main.course.get(Integer.parseInt(updateCourseId) - 1);
                    addCourseName.setText(course.getCourseName());
                    addHours.setText(String.valueOf(course.getHoureNum()));
                }
            });
            numberCourse++;
        }

        updateCourse = new JButton("Изменить");
        updateCourse.setBounds(400, 400, 100, 30);
        updateCourse.setVisible(false);
        updateCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                course course = Main.course.get(Integer.parseInt(updateCourseId) - 1);
                course.setCourseName(addCourseName.getText());
                course.setHoureNum(Integer.parseInt(addHours.getText()));

                modelDialog.setText("Курс изменен");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });
        frame.add(updateCourse);

        deleteCourse = new JButton("Удалить");
        deleteCourse.setBounds(505, 400, 100, 30);
        deleteCourse.setVisible(false);
        deleteCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Main.course.remove(Integer.parseInt(deleteCourseId) - 1);
                modelDialog.setText("Курс удален");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });
        frame.add(deleteCourse);

        frame.add(coursePanel);

        int numberStudent = 1;

        for (student student : Main.student) {
            JLabel label = new JLabel(numberStudent + ". " + student.getFirstName() + " " + student.getSecondName() + " " + student.getTeachPlace(), SwingConstants.CENTER);
            studentPanel.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    deleteStudentId = label.getText().substring(0,1);
                    updateStudentId = deleteStudentId;
                    student student = Main.student.get(Integer.parseInt(updateStudentId) - 1);
                    addStudentName.setText(student.getFirstName());
                    addStudentSurname.setText(student.getSecondName());
                    addStudentFaculty.setText(student.getTeachPlace());
                }
            });
            numberStudent++;
        }

        updateStudent = new JButton("Изменить");
        updateStudent.setBounds(400, 400, 100, 30);
        updateStudent.setVisible(false);
        updateStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                student student = Main.student.get(Integer.parseInt(updateStudentId) - 1);
                student.setFirstName(addStudentName.getText());
                student.setSecondName(addStudentSurname.getText());
                student.setTeachPlace(addStudentFaculty.getText());

                modelDialog.setText("Студент изменен");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });
        frame.add(updateStudent);

        deleteStudent = new JButton("Удалить");
        deleteStudent.setBounds(505,400, 100, 30);
        deleteStudent.setVisible(false);
        deleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Main.student.remove(Integer.parseInt(deleteStudentId) - 1);
                modelDialog.setText("Студент удален");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });
        frame.add(deleteStudent);

        frame.add(studentPanel);

        labelName = new JLabel("1.Введите имя");
        labelName.setVisible(true);
        labelName.setBounds(5, 10, 200, 20);
        frame.add(labelName);
        addName = new JTextField(16);
        addName.setBounds(150, 10, 200, 20);
        addName.setVisible(true);
        frame.add(addName);

        labelSurname = new JLabel("2.Введите фамилию");
        labelSurname.setVisible(true);
        labelSurname.setBounds(5, 40, 200, 20);
        frame.add(labelSurname);
        addSurname = new JTextField(16);
        addSurname.setBounds(150, 40, 200, 20);
        addSurname.setVisible(true);
        frame.add(addSurname);

        addButtonPrepod = new JButton("Добавить");
        addButtonPrepod.setBounds(5, 70, 100, 30);
        addButtonPrepod.setVisible(true);
        frame.add(addButtonPrepod);
        addButtonPrepod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (addName.getText().isEmpty()) {
                    modelDialog.setText("Введите имя");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (addSurname.getText().isEmpty()) {
                    modelDialog.setText("Введите фамилию");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                prepod newPrepod = new prepod(addName.getText(), addSurname.getText());
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "123456789")) {
                    PreparedStatement statement = connection.prepareStatement("insert into prepod(name, surname) values (?, ?)");
                    statement.setString(1, addName.getText());
                    statement.setString(2, addSurname.getText());
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Main.prepod.add(newPrepod);
                modelDialog.setText("Добавлен преподаватель");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addPrepod.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                labelName.setVisible(true);
                addName.setVisible(true);
                labelSurname.setVisible(true);
                addSurname.setVisible(true);
                addButtonPrepod.setVisible(true);
                prepodPanel.setVisible(true);

                labelStudentName.setVisible(false);
                addStudentName.setVisible(false);
                labelStudentSurname.setVisible(false);
                addStudentSurname.setVisible(false);
                labelStudentFaculty.setVisible(false);
                addStudentFaculty.setVisible(false);
                addButtonStudent.setVisible(false);
                studentPanel.setVisible(false);

                updateStudent.setVisible(false);
                updateCourse.setVisible(false);
                updatePrepod.setVisible(true);

                deleteStudent.setVisible(false);
                deleteCourse.setVisible(false);
                deletePrepod.setVisible(true);

                labelCourseName.setVisible(false);
                addCourseName.setVisible(false);
                labelHours.setVisible(false);
                addHours.setVisible(false);
                addButtonCourse.setVisible(false);
                coursePanel.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        labelCourseName = new JLabel("1.Введите имя");
        labelCourseName.setVisible(false);
        labelCourseName.setBounds(5, 10, 200, 20);
        frame.add(labelCourseName);
        addCourseName = new JTextField(16);
        addCourseName.setBounds(150, 10, 200, 20);
        addCourseName.setVisible(false);
        frame.add(addCourseName);

        labelHours = new JLabel("2.Введите кол-во часов");
        labelHours.setVisible(false);
        labelHours.setBounds(5, 40, 200, 20);
        frame.add(labelHours);
        addHours = new JTextField(16);
        addHours.setBounds(150, 40, 200, 20);
        addHours.setVisible(false);
        frame.add(addHours);

        addButtonCourse = new JButton("Добавить");
        addButtonCourse.setBounds(5, 70, 100, 30);
        addButtonCourse.setVisible(false);
        frame.add(addButtonCourse);
        addButtonCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (addCourseName.getText().isEmpty()) {
                    modelDialog.setText("Введите имя");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (addHours.getText().isEmpty()) {
                    modelDialog.setText("Введите количество часов");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                try {
                    Integer.parseInt(addHours.getText());
                } catch(NumberFormatException ex) {
                    modelDialog.setText("Введите корректно часы");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                course newCourse = new course(addCourseName.getText(), Integer.parseInt(addHours.getText()));
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "123456789")) {
                    PreparedStatement statement = connection.prepareStatement("insert into course(name, hours) values (?, ?)");
                    statement.setString(1, addCourseName.getText());
                    statement.setInt(2, Integer.parseInt(addHours.getText()));
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Main.course.add(newCourse);
                modelDialog.setText("Добавлен курс");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addCourse.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {

                labelName.setVisible(false);
                addName.setVisible(false);
                labelSurname.setVisible(false);
                addSurname.setVisible(false);
                addButtonPrepod.setVisible(false);
                prepodPanel.setVisible(false);

                labelStudentName.setVisible(false);
                addStudentName.setVisible(false);
                labelStudentSurname.setVisible(false);
                addStudentSurname.setVisible(false);
                labelStudentFaculty.setVisible(false);
                addStudentFaculty.setVisible(false);
                addButtonStudent.setVisible(false);
                studentPanel.setVisible(false);

                updateStudent.setVisible(false);
                updateCourse.setVisible(true);
                updatePrepod.setVisible(false);

                deleteStudent.setVisible(false);
                deleteCourse.setVisible(true);
                deletePrepod.setVisible(false);

                labelCourseName.setVisible(true);
                addCourseName.setVisible(true);
                labelHours.setVisible(true);
                addHours.setVisible(true);
                addButtonCourse.setVisible(true);
                coursePanel.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        labelStudentName = new JLabel("1.Введите имя");
        labelStudentName.setVisible(false);
        labelStudentName.setBounds(5, 10, 200, 20);
        frame.add(labelStudentName);
        addStudentName = new JTextField(16);
        addStudentName.setBounds(150, 10, 200, 20);
        addStudentName.setVisible(false);
        frame.add(addStudentName);

        labelStudentSurname = new JLabel("2.Введите фамилию");
        labelStudentSurname.setVisible(false);
        labelStudentSurname.setBounds(5, 40, 200, 20);
        frame.add(labelStudentSurname);
        addStudentSurname = new JTextField(16);
        addStudentSurname.setBounds(150, 40, 200, 20);
        addStudentSurname.setVisible(false);
        frame.add(addStudentSurname);

        labelStudentFaculty = new JLabel("3.Введите факультет");
        labelStudentFaculty.setVisible(false);
        labelStudentFaculty.setBounds(5, 70, 200, 20);
        frame.add(labelStudentFaculty);
        addStudentFaculty = new JTextField(16);
        addStudentFaculty.setBounds(150, 70, 200, 20);
        addStudentFaculty.setVisible(false);
        frame.add(addStudentFaculty);

        addButtonStudent = new JButton("Добавить");
        addButtonStudent.setBounds(5, 100, 100, 30);
        addButtonStudent.setVisible(false);
        frame.add(addButtonStudent);
        addButtonStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (addStudentName.getText().isEmpty()) {
                    modelDialog.setText("Введите имя");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (addStudentSurname.getText().isEmpty()) {
                    modelDialog.setText("Введите фамилию");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (addStudentFaculty.getText().isEmpty()) {
                    modelDialog.setText("Введите факультет");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                student newStudent = new student(addStudentName.getText(), addStudentSurname.getText(), addStudentFaculty.getText(), "0");
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "123456789")) {
                    PreparedStatement statement = connection.prepareStatement("insert into student(name, surname, faculty) values (?, ?, ?)");
                    statement.setString(1, addStudentName.getText());
                    statement.setString(2, addStudentSurname.getText());
                    statement.setString(3, addStudentFaculty.getText());
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Main.student.add(newStudent);
                modelDialog.setText("Добавлен студент");
                frame.dispose();
                new AdministratorGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addStudent.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                labelName.setVisible(false);
                addName.setVisible(false);
                labelSurname.setVisible(false);
                addSurname.setVisible(false);
                addButtonPrepod.setVisible(false);
                prepodPanel.setVisible(false);

                labelCourseName.setVisible(false);
                addCourseName.setVisible(false);
                labelHours.setVisible(false);
                addHours.setVisible(false);
                addButtonCourse.setVisible(false);
                coursePanel.setVisible(false);

                updateStudent.setVisible(true);
                updateCourse.setVisible(false);
                updatePrepod.setVisible(false);

                deleteStudent.setVisible(true);
                deleteCourse.setVisible(false);
                deletePrepod.setVisible(false);

                labelStudentName.setVisible(true);
                addStudentName.setVisible(true);
                labelStudentSurname.setVisible(true);
                addStudentSurname.setVisible(true);
                labelStudentFaculty.setVisible(true);
                addStudentFaculty.setVisible(true);
                addButtonStudent.setVisible(true);
                studentPanel.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        exit.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                frame.dispose();
                new GridLayoutCustom();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        menuBar = new JMenuBar();

        menuBar.add(addPrepod);
        menuBar.add(addCourse);
        menuBar.add(addStudent);
        menuBar.add(exit);

        frame.add(menuBar);
        frame.setJMenuBar(menuBar);

        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
