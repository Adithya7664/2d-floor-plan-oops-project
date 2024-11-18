import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class Room {
    int x, y, width, height;

    public Room(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(Room other) {
        return !(this.x + this.width <= other.x || // this room is to the left of other
                this.x >= other.x + other.width || // this room is to the right of other
                this.y + this.height <= other.y || // this room is above other
                this.y >= other.y + other.height); // this room is below other
    }

    @Override
    public String toString() {
        return String.format("Room[x=%d, y=%d, width=%d, height=%d]", x, y, width, height);
    }
}

class FloorPlanner {
    private List<Room> rooms;

    public FloorPlanner() {
        rooms = new ArrayList<>();
    }

    public boolean addRoom(int x, int y, int width, int height) {
        Room newRoom = new Room(x, y, width, height);

        // Check for overlaps with existing rooms
        for (Room room : rooms) {
            if (room.overlaps(newRoom)) {
                return false; // Room overlaps, can't add it
            }
        }

        // No overlap, add room to the roster
        rooms.add(newRoom);
        return true;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

public class FloorPlannerGUI extends JFrame {
    private FloorPlanner floorPlanner;
    private int roomWidth = 50, roomHeight = 50; // Default room size
    private boolean addingRoom = false;
    private int startX, startY; // Initial position for a new room

    public FloorPlannerGUI() {
        floorPlanner = new FloorPlanner();
        setTitle("2D Floor Planner");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to draw the rooms
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRooms(g); // Call to draw rooms
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        add(drawingPanel);

        // Button to start adding rooms
        JButton addButton = new JButton("Add Room");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addingRoom = true;
                JOptionPane.showMessageDialog(null, "Click to place the top-left corner of the room.");
            }
        });

        drawingPanel.add(addButton, BorderLayout.SOUTH);

        // Mouse listener to detect where to place a room
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (addingRoom) {
                    // Get the starting position for the room
                    startX = e.getX();
                    startY = e.getY();
                    // Try to add a room at that position
                    if (floorPlanner.addRoom(startX, startY, roomWidth, roomHeight)) {
                        JOptionPane.showMessageDialog(null, "Room added at (" + startX + ", " + startY + ")");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot add room here, overlap detected!");
                    }
                    // Redraw the panel
                    drawingPanel.repaint();
                    addingRoom = false;
                }
            }
        });

        // Set layout and show window
        setLayout(new BorderLayout());
        setVisible(true);
    }

    // Method to draw all rooms on the panel
    private void drawRooms(Graphics g) {
        List<Room> rooms = floorPlanner.getRooms();
        g.setColor(Color.BLUE);

        // Draw each room as a filled rectangle
        for (Room room : rooms) {
            g.fillRect(room.x, room.y, room.width, room.height);
        }
    }

    public static void main(String[] args) {
        new FloorPlannerGUI();
    }
}