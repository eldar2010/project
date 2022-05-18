import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentTeachingOnGrid {
    JFrame f;
    JTextField student;
    JTextField course;
    JTextField prepod;

    StudentTeachingOnGrid() {
        f = new JFrame("SetBounds Example");

        student = new JTextField(16);
        course = new JTextField(16);


        prepod = new JTextField(16);
        f.setSize(400, 300);
        // Create button
        JPanel jPanel = new JPanel();
        JTextArea textArea = new JTextArea(Main.student.toString(), 10, 10);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        jPanel.add(textArea);
        f.add(jPanel);
//        JTextArea textArea1 = new JTextArea(Main.course.toString(), 40, 40);
//        textArea1.setFont(new Font("Serif", Font.ITALIC, 16));
//        textArea1.setLineWrap(true);
//        textArea1.setWrapStyleWord(true);
//        f.add(textArea1);
//        JTextArea textArea2 = new JTextArea(Main.prepod.toString(), 40 ,40);
//        textArea2.setFont(new Font("Serif", Font.ITALIC, 16));
//        textArea2.setLineWrap(true);
//        textArea2.setWrapStyleWord(true);
//        f.add(textArea2);
//        JButton btn = new JButton("Выбрать");
//        // Define the position and size of the button
//        btn.setBounds(210,115,100,30);
//        f.add(btn);
//        btn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae) {
//                course courseEntity = Main.course.get(Integer.parseInt(course.getText()) - 1);
//                student studentEntity = Main.student.get(Integer.parseInt(student.getText()) - 1);
//                prepod prepodEntity = Main.prepod.get(Integer.parseInt(prepod.getText()) - 1);
//                courseEntity.getStudents().put(studentEntity, null);
//                prepodEntity.prepodCourse.add(courseEntity);
//
//                f.dispose();
//                new UserGrid();
//                modelDialog.setVisible(true);
//
//            }
//        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
