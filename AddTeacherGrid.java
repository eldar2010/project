import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddTeacherGrid {
    JFrame f;

    JTextField nameField;
    JTextField surnameField;

    AddTeacherGrid() {
        f = new JFrame("SetBounds Example");

        final JDialog modelDialog = Dialog.createDialog(f);

        nameField = new JTextField(16);
        surnameField = new JTextField(16);

        f.setSize(400, 300);
        // Set the layout to null
        f.setLayout(null);
        // Create button
        JLabel label = new JLabel("1.Введите имя");
        f.add(label);
        f.add(nameField);
        nameField.setBounds(150, 5, 200, 20);
        label.setBounds(5, 5, 200, 20);
        JLabel label1 = new JLabel("2.Добавление курса");
        f.add(label1);
        f.add(surnameField);
        surnameField.setBounds(150, 35, 200, 20);
        label1.setBounds(5, 35, 200, 20);
        JButton btn = new JButton("Добавить");
        // Define the position and size of the button
        btn.setBounds(5,65,100,30);
        f.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                prepod newPrepod = new prepod(nameField.getText(), surnameField.getText());
                Main.prepod.add(newPrepod);
                f.dispose();
                new AdministratorGrid();
                modelDialog.setVisible(true);
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
