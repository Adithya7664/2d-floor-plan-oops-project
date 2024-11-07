
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rooms {

    public JPanel rooms() {
        System.out.println("This is a room");
        frame room = new frame();
        room.setLayout(new GridLayout(4, 1, 3, 3));
        room.setVisible(true);
        room.setBounds(300, 300, 300, 150);
        room.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField tfroom = new JTextField("Enter the name of the ROOM", 20);

        String[] Stype = { "Hall", "Kitchen", "bedroom", "bathroom" };

        JComboBox<String> type = new JComboBox<>(Stype);

        JPanel proom = new JPanel();
        proom.setSize(100, 100);

        JButton submit = new JButton("SUBMIT");

        JButton color = new JButton("chose a color");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked");
                proom.setName(tfroom.getText());

                room.dispose();

            }
        });
        color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JColorChooser chooser = new JColorChooser();
                Color color = chooser.showDialog(room, "Choose a colour", Color.RED);
                if (color != null) {
                    proom.setBackground(color);
                }
            }
        });
        room.add(type);
        room.add(color);
        room.add(tfroom);
        room.add(submit);
        room.pack();

        return proom;

    }

}