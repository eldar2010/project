import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserGrid {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu addStudy;
    private JMenu addMark;
    private JMenu addArchive;
    private JMenu addToFile;
    private JMenu addFromFile;
    private JMenu exit;

    private JButton addButtonStudy;
    private JPanel prepodPanelStudy;
    private JPanel studentPanelStudy;
    private JPanel coursePanelStudy;
    private String choosedPrepodStudyId;
    private String choosedStudentStudyId;
    private String choosedCourseStudyId;

    private JButton addButtonMark;
    private JPanel studentPanelMark;
    private JPanel coursePanelMark;
    private JPanel markPanel;
    private String choosedStudentMarkId;
    private String choosedCourseMarkId;
    private String choosedMarkId;

    private JButton addButtonArchive;
    private JPanel studentPanelArchive;
    private JPanel archivePanel;
    private String choosedStudentArchiveId;

    private JButton addButtonToFile;

    private JButton addButtonFromFile;

    UserGrid() {
        frame = new JFrame("Пользователь");

        final Dialog modelDialog = new Dialog();

        frame.setLayout(null);

        addStudy = new JMenu("Студент проходит обучение");
        addMark = new JMenu("Оценивание студента");
        addArchive = new JMenu("Добавление в архив");
        addToFile = new JMenu("Сохранение в файл");
        addFromFile = new JMenu("Чтение из файла");
        exit = new JMenu("Выйти");

        prepodPanelStudy = new JPanel();
        prepodPanelStudy.setBounds(0, 0, 250, 400);
        prepodPanelStudy.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список преподавателей", TitledBorder.CENTER, TitledBorder.TOP));
        prepodPanelStudy.setVisible(true);
        prepodPanelStudy.setLayout(new GridLayout(20, 1));

        coursePanelStudy = new JPanel();
        coursePanelStudy.setBounds(250, 0, 250, 400);
        coursePanelStudy.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список курсов", TitledBorder.CENTER, TitledBorder.TOP));
        coursePanelStudy.setVisible(true);
        coursePanelStudy.setLayout(new GridLayout(20, 1));

        studentPanelStudy = new JPanel();
        studentPanelStudy.setBounds(500, 0, 250, 400);
        studentPanelStudy.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список студентов", TitledBorder.CENTER, TitledBorder.TOP));
        studentPanelStudy.setVisible(true);
        studentPanelStudy.setLayout(new GridLayout(20, 1));

        studentPanelMark = new JPanel();
        studentPanelMark.setBounds(0, 0, 250, 400);
        studentPanelMark.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список студентов", TitledBorder.CENTER, TitledBorder.TOP));
        studentPanelMark.setVisible(false);
        studentPanelMark.setLayout(new GridLayout(20, 1));

        coursePanelMark = new JPanel();
        coursePanelMark.setBounds(250, 0, 250, 400);
        coursePanelMark.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список курсов", TitledBorder.CENTER, TitledBorder.TOP));
        coursePanelMark.setVisible(false);
        coursePanelMark.setLayout(new GridLayout(20, 1));

        markPanel = new JPanel();
        markPanel.setBounds(500, 0, 250, 400);
        markPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Оценки", TitledBorder.CENTER, TitledBorder.TOP));
        markPanel.setVisible(false);
        markPanel.setLayout(new GridLayout(20, 1));

        studentPanelArchive = new JPanel();
        studentPanelArchive.setBounds(0, 0, 350, 400);
        studentPanelArchive.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Список студентов", TitledBorder.CENTER, TitledBorder.TOP));
        studentPanelArchive.setVisible(false);
        studentPanelArchive.setLayout(new GridLayout(20, 1));

        archivePanel = new JPanel();
        archivePanel.setBounds(400, 0, 350, 400);
        archivePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Архив студентов", TitledBorder.CENTER, TitledBorder.TOP));
        archivePanel.setVisible(false);
        archivePanel.setLayout(new GridLayout(20, 1));

        int numberPrepodStudy = 1;

        for (prepod prepod : Main.prepod) {
            JLabel label = new JLabel(numberPrepodStudy + ". " + prepod.getFirstName() + " " + prepod.getSecondName(), SwingConstants.CENTER);
            prepodPanelStudy.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedPrepodStudyId = label.getText().substring(0,1);
                }
            });
            numberPrepodStudy++;
        }

        frame.add(prepodPanelStudy);

        int numberCourseStudy = 1;

        for (course course : Main.course) {
            JLabel label = new JLabel(numberCourseStudy + ". " + course.getCourseName() + " " + course.getHoureNum() + " ч", SwingConstants.CENTER);
            coursePanelStudy.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedCourseStudyId = label.getText().substring(0,1);
                }
            });
            numberCourseStudy++;
        }

        frame.add(coursePanelStudy);

        int numberStudentStudy = 1;

        for (student student : Main.student) {
            JLabel label = new JLabel(numberStudentStudy + ". " + student.getFirstName() + " " + student.getSecondName() + " " + student.getTeachPlace(), SwingConstants.CENTER);
            studentPanelStudy.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedStudentStudyId = label.getText().substring(0,1);
                }
            });
            numberStudentStudy++;
        }

        frame.add(studentPanelStudy);

        addButtonStudy = new JButton("Добавить");
        addButtonStudy.setBounds(5, 400, 100, 30);
        addButtonStudy.setVisible(true);
        frame.add(addButtonStudy);
        addButtonStudy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (choosedPrepodStudyId == null) {
                    modelDialog.setText("Выберите преподавателя");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (choosedCourseStudyId == null) {
                    modelDialog.setText("Выберите курс");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (choosedStudentStudyId == null) {
                    modelDialog.setText("Выберите студента");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }

                prepod prepod = Main.prepod.get(Integer.parseInt(choosedPrepodStudyId) - 1);
                course course = Main.course.get(Integer.parseInt(choosedCourseStudyId) - 1);
                student student = Main.student.get(Integer.parseInt(choosedStudentStudyId) - 1);

                course.students.put(student, "0");
                prepod.prepodCourse.add(course);

                modelDialog.setText("Студент проходит обучение на курсе");
                frame.dispose();
                new UserGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        int numberCourseMark = 1;

        for (course course : Main.course) {
            JLabel label = new JLabel(numberCourseMark + ". " + course.getCourseName() + " " + course.getHoureNum() + " ч", SwingConstants.CENTER);
            coursePanelMark.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedCourseMarkId = label.getText().substring(0,1);
                }
            });
            numberCourseMark++;
        }

        frame.add(coursePanelMark);

        int numberMark = 1;

        for (String mark : Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")) {
            JLabel label = new JLabel(mark, SwingConstants.CENTER);
            markPanel.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedMarkId = label.getText();
                }
            });
            numberMark++;
        }

        frame.add(markPanel);

        int numberStudentMark = 1;

        for (student student : Main.student) {
            JLabel label = new JLabel(numberStudentMark + ". " + student.getFirstName() + " " + student.getSecondName() + " " + student.getTeachPlace(), SwingConstants.CENTER);
            studentPanelMark.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedStudentMarkId = label.getText().substring(0,1);
                }
            });
            numberStudentMark++;
        }

        frame.add(studentPanelMark);

        addButtonMark = new JButton("Добавить");
        addButtonMark.setBounds(5, 400, 100, 30);
        addButtonMark.setVisible(false);
        frame.add(addButtonMark);
        addButtonMark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (choosedMarkId == null) {
                    modelDialog.setText("Выберите оценку");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (choosedCourseMarkId == null) {
                    modelDialog.setText("Выберите курс");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }
                if (choosedStudentMarkId == null) {
                    modelDialog.setText("Выберите студента");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }

                course course = Main.course.get(Integer.parseInt(choosedCourseMarkId) - 1);
                student student = Main.student.get(Integer.parseInt(choosedStudentMarkId) - 1);
                course.students.put(student, choosedMarkId);

                modelDialog.setText("Студент был оценен");
                frame.dispose();
                new UserGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        int numberArchive = 1;

        for (student student : Main.archive) {
            JLabel label = new JLabel(numberArchive + ". " + student.getFirstName() + " " + student.getSecondName() + " " + student.getTeachPlace(), SwingConstants.CENTER);
            archivePanel.add(label);
            numberArchive++;
        }

        frame.add(archivePanel);

        int numberStudentArchive = 1;

        for (student student : Main.student) {
            JLabel label = new JLabel(numberStudentArchive + ". " + student.getFirstName() + " " + student.getSecondName() + " " + student.getTeachPlace(), SwingConstants.CENTER);
            studentPanelArchive.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    choosedStudentArchiveId = label.getText().substring(0,1);
                }
            });
            numberStudentArchive++;
        }

        frame.add(studentPanelArchive);

        addButtonArchive = new JButton("Добавить");
        addButtonArchive.setBounds(5, 400, 100, 30);
        addButtonArchive.setVisible(false);
        frame.add(addButtonArchive);
        addButtonArchive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (choosedStudentArchiveId == null) {
                    modelDialog.setText("Выберите студента");
                    modelDialog.createDialog(frame).setVisible(true);
                    return;
                }

                student student = Main.student.get(Integer.parseInt(choosedStudentArchiveId) - 1);
                Main.archive.add(student);
                Main.student.remove(student);

                modelDialog.setText("Студентдобавлен в архив");
                frame.dispose();
                new UserGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addButtonToFile = new JButton("Сохранить в файл");
        addButtonToFile.setBounds(5, 0, 250, 30);
        addButtonToFile.setVisible(false);
        frame.add(addButtonToFile);
        addButtonToFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\OIT\\files\\file.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    oos.writeObject(Main.prepod);
                    oos.writeObject(Main.course);
                    oos.writeObject(Main.student);
                    oos.writeObject(Main.archive);
                } catch (IOException e) {
                    modelDialog.setText("Ошибка при сохранении в файл");
                    frame.dispose();
                    new UserGrid();
                    modelDialog.createDialog(frame).setVisible(true);
                }

                modelDialog.setText("Данные были записаны в файл");
                frame.dispose();
                new UserGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addButtonFromFile = new JButton("Считать из файла");
        addButtonFromFile.setBounds(5, 0, 250, 30);
        addButtonFromFile.setVisible(false);
        frame.add(addButtonFromFile);
        addButtonFromFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(new FileInputStream("C:\\Users\\OIT\\files\\file.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Main.prepod = (ArrayList<prepod>) ois.readObject();
                    Main.course = (ArrayList<course>) ois.readObject();
                    Main.student = (ArrayList<student>) ois.readObject();
                    Main.archive = (ArrayList<student>) ois.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                modelDialog.setText("Данные были считаны из файла");
                frame.dispose();
                new UserGrid();
                modelDialog.createDialog(frame).setVisible(true);
            }
        });

        addStudy.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                studentPanelMark.setVisible(false);
                coursePanelMark.setVisible(false);
                markPanel.setVisible(false);
                addButtonMark.setVisible(false);

                studentPanelArchive.setVisible(false);
                archivePanel.setVisible(false);
                addButtonArchive.setVisible(false);

                addButtonToFile.setVisible(false);
                addButtonFromFile.setVisible(false);

                prepodPanelStudy.setVisible(true);
                coursePanelStudy.setVisible(true);
                studentPanelStudy.setVisible(true);
                addButtonStudy.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        addMark.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                studentPanelMark.setVisible(true);
                coursePanelMark.setVisible(true);
                markPanel.setVisible(true);
                addButtonMark.setVisible(true);


                addButtonToFile.setVisible(false);
                addButtonFromFile.setVisible(false);

                studentPanelArchive.setVisible(false);
                archivePanel.setVisible(false);
                addButtonArchive.setVisible(false);

                prepodPanelStudy.setVisible(false);
                coursePanelStudy.setVisible(false);
                studentPanelStudy.setVisible(false);
                addButtonStudy.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        addArchive.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                studentPanelMark.setVisible(false);
                coursePanelMark.setVisible(false);
                markPanel.setVisible(false);
                addButtonMark.setVisible(false);

                addButtonToFile.setVisible(false);
                addButtonFromFile.setVisible(false);

                studentPanelArchive.setVisible(true);
                archivePanel.setVisible(true);
                addButtonArchive.setVisible(true);

                prepodPanelStudy.setVisible(false);
                coursePanelStudy.setVisible(false);
                studentPanelStudy.setVisible(false);
                addButtonStudy.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        addToFile.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                studentPanelMark.setVisible(false);
                coursePanelMark.setVisible(false);
                markPanel.setVisible(false);
                addButtonMark.setVisible(false);

                addButtonToFile.setVisible(true);
                addButtonFromFile.setVisible(false);

                studentPanelArchive.setVisible(false);
                archivePanel.setVisible(false);
                addButtonArchive.setVisible(false);

                prepodPanelStudy.setVisible(false);
                coursePanelStudy.setVisible(false);
                studentPanelStudy.setVisible(false);
                addButtonStudy.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        addFromFile.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                studentPanelMark.setVisible(false);
                coursePanelMark.setVisible(false);
                markPanel.setVisible(false);
                addButtonMark.setVisible(false);

                addButtonToFile.setVisible(false);
                addButtonFromFile.setVisible(true);

                studentPanelArchive.setVisible(false);
                archivePanel.setVisible(false);
                addButtonArchive.setVisible(false);

                prepodPanelStudy.setVisible(false);
                coursePanelStudy.setVisible(false);
                studentPanelStudy.setVisible(false);
                addButtonStudy.setVisible(false);
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

        menuBar.add(addStudy);
        menuBar.add(addMark);
        menuBar.add(addArchive);
        menuBar.add(addToFile);
        menuBar.add(addFromFile);
        menuBar.add(exit);

        frame.add(menuBar);
        frame.setJMenuBar(menuBar);

        frame.setSize(800, 500);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}