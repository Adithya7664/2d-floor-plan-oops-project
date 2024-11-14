
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rooms {

    int x, y, width, height;

    public rooms(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(rooms other) {
        return !(this.x + this.width <= other.x || // this room is to the left of other
                this.x >= other.x + other.width || // this room is to the right of other
                this.y + this.height <= other.y || // this room is above other
                this.y >= other.y + other.height); // this room is below other
    }

    ArrayList<rooms> rooms = new ArrayList<>();

    public boolean addRoom(int x, int y, int width, int height) {
        rooms newRoom = new rooms(x, y, width, height);

        // Check for overlaps with existing rooms
        for (rooms rooms : rooms) {
            if (rooms.overlaps(newRoom)) {
                return false; // Room overlaps, can't add it
            }
        }

        // No overlap, add room to the roster
        rooms.add(newRoom);
        return true;
    }

    public ArrayList<rooms> getRooms() {
        return rooms;
    }

    Boolean ea = false;

    public JPanel rooms() {
        System.out.println("This is a room");
        frame room = new frame();
        room.setLayout(new GridLayout(10, 1, 3, 3));
        room.setVisible(true);
        room.setBounds(300, 300, 300, 400);
        room.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField tfroom = new JTextField("Enter the name of the ROOM", 20);

        JTextField tfXroom = new JTextField("Enter the X position  of the ROOM", 20);

        JTextField tfYroom = new JTextField("Enter the y position  of the ROOM", 20);

        JTextField tfLroom = new JTextField("Enter the length of the ROOM", 20);

        JTextField tfHroom = new JTextField("Enter the width of the ROOM", 20);

        String[] Stype = { "Hall", "Kitchen", "bedroom", "bathroom" };

        JComboBox<String> type = new JComboBox<>(Stype);

        JPanel proom = new JPanel();
        proom.setSize(100, 100);
        proom.setVisible(false);

        JButton submit = new JButton("SUBMIT");

        JButton color = new JButton("chose a color");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked");
                proom.setName(tfroom.getText());
                try {
                    proom.setBounds(Integer.parseInt(tfXroom.getText()), Integer.parseInt(tfYroom.getText()),
                            Integer.parseInt(tfLroom.getText()), Integer.parseInt(tfHroom.getText()));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input");
                    JOptionPane.showMessageDialog(null,
                            "please enter a number in the number box", "error", JOptionPane.ERROR_MESSAGE);

                    ea = true;
                }

                if (!ea) {
                    proom.setVisible(true);
                    room.dispose();
                } else {
                    room.dispose();
                    rooms();
                }

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
        room.add(tfXroom);
        room.add(tfYroom);
        room.add(tfLroom);
        room.add(tfHroom);

        room.add(submit);

        return proom;

    }

}