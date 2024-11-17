
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;import javax.swing.JTextField;
import javax.swing.JTextField;

public class rooms {
    String name;
    int x, y, width, height;

    public rooms(int x, int y, int width, int height, String name) {
        this.name = name;
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

    List<rooms> rooms = new ArrayList<>();
    public boolean addRoom(int x, int y, int width, int height) {
        rooms newRoom = new rooms(x, y, width, height, name);

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

    public void getData(int x,int y,int length,int height){
       

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
                room.dispose();
                try {
                    proom.setBounds(Integer.parseInt(tfXroom.getText()), Integer.parseInt(tfYroom.getText()),
                            Integer.parseInt(tfLroom.getText()), Integer.parseInt(tfHroom.getText()));

                    Boolean a ;
                    int x=0,y=0,l=0,h=0;
                    x = Integer.parseInt(tfXroom.getText());
                    y = Integer.parseInt(tfYroom.getText());
                    l = Integer.parseInt(tfLroom.getText());
                    h = Integer.parseInt(tfHroom.getText());
                    addRoom(x,y,l,h);
                    
                    proom.setVisible(true);
                } catch (NumberFormatException ex) {

                    ea = true;
                    System.out.println("Invalid input");
                    int input = JOptionPane.showOptionDialog(null,
                            "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);

                    if (input == JOptionPane.OK_OPTION) {
                        room.dispose();
                    }

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