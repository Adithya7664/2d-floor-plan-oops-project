
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

    private JPanel selectedRoom;
    private Point initialClick;
    private Point PrevCoord;

    public boolean overlaps(rooms other) {
        return !(this.x + this.width <= other.x || // this room is to the left of

        // other
                this.x >= other.x + other.width || // this room is to the right of other
                this.y + this.height <= other.y || // this room is above other
                this.y >= other.y + other.height); // this room is below other
    }

    ArrayList<rooms> rooms = new ArrayList<>();

    public boolean addRoom(int x, int y, int width, int height, String name) {
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
        proom.setLayout(null);
        proom.setVisible(false);
        JButton submit = new JButton("SUBMIT");

        JButton color = new JButton("chose a color");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                file f = new file();
                System.out.println("Submit button clicked");
                proom.setName(tfroom.getText());
                try {
                    proom.setBounds(Integer.parseInt(tfXroom.getText()), Integer.parseInt(tfYroom.getText()),
                            Integer.parseInt(tfLroom.getText()), Integer.parseInt(tfHroom.getText()));
                    // proom.setBackground(Color.decode("#" + type.getSelectedItem()));
                    f.addpanel(proom);

                    int panelHeight = Integer.parseInt(tfLroom.getText());
                    int panelWidth = Integer.parseInt(tfHroom.getText());

                    proom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = proom;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    proom.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e);
                        }
                    });
                    ////////

                    proom.setBounds(proom.getLocation().x, proom.getLocation().y,
                            panelWidth, panelHeight);

                    room.dispose();
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

    private void moveRoom(MouseEvent e) {
        if (selectedRoom != null) {
            // Temporarily set floor layout to null for free dragging

            // Calculate the new location
            int thisX = selectedRoom.getX();
            int thisY = selectedRoom.getY();

            // Get the offset based on initial click
            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            // Move the room to the new location
            int newX = thisX + xMoved;
            int newY = thisY + yMoved;
            selectedRoom.setLocation(newX, newY);

            // Refresh the container to show the updated location

        }
    }

}