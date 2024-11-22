
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rooms {
    Array arr;

    public rooms(Array array) {
        this.arr = array;
    }
    // static file f;

    // public file getFile() {
    // return f;
    // }

    private JPanel selectedRoom;
    private Point initialClick;
    private Point PrevCoord;

    Boolean ea = false;

    public JPanel rooms(JPanel panelDB) {

        // f = new file();

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
        String name = (String) type.getSelectedItem();

        JPanel proom = new JPanel();
        proom.setSize(100, 100);
        proom.setLayout(null);
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
                    // proom.setBackground(Color.decode("#" + type.getSelectedItem()));
                    // f.addPanel(proom);

                    if (!arr.checkOverlaps(proom)) {

                        arr.setroom(proom, name);
                        panelDB.add(proom);
                        System.out.println("proom is passed to setroom in array");
                    } else {
                        proom.setBounds(0, 0, 0, 0);

                        System.out.println("proom i set not visible");
                    }

                    // f.addPanel(proom, type.getActionCommand());
                    // f.getpanelname(tfroom.getText());
                    // System.out.println("/");
                    // System.out.println(tfroom.getText());
                    // System.out.println("/");

                    // System.out.println(f.length());
                    // System.out.println(f.getnames());

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
        if (!arr.checkOverlaps(proom)) {
            return proom;
        }

        return null;
        // return proom;

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
            if (!arr.checkOverlapsml(selectedRoom, newX, newY)) {
                // selectedRoom.setLocation(newX, newY);
            }

            // Refresh the container to show the updated location

        }
    }

}