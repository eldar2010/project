import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class GridLayoutCustom {

    private JFrame frame;

    GridLayoutCustom() {
        frame = new JFrame("Система студенты");
        frame.setSize(300, 300);
        frame.setLayout(null);

        JButton adminButton = new JButton("Администратор");
        adminButton.setBounds(40,30,200,40);
        JButton userButton = new JButton("Пользователь");
        userButton.setBounds(40,80,200,40);
        frame.add(adminButton);
        frame.add(userButton);

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new AdministratorGrid();
            }
        });

        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new UserGrid();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
