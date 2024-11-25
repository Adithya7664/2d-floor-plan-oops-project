import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class filesave {
    Array arr;

    private JPanel selectedRoom;
    private JLabel selectedroom;
    private Point initialClick;
    private Point PrevCoord;

    filesave(Array array) {
        arr = array;
    }

    public void SafeFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);

        // public File selectedFile;

        // String filename = null;
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            JFrame frame = new JFrame();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(arr.roomsave);
                oos.writeObject(arr.furnituresave1);
                // savePanels(file, arr);
                JOptionPane.showMessageDialog(frame, "panels saved succesfully");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving this plan");
                ex.printStackTrace();
            }

        }
        // return filename;
    }

    public static File chooseFile(boolean save) {
        JFileChooser fileChooser = new JFileChooser();
        int result;
        if (save) {
            fileChooser.setDialogTitle("Save Panels");
            result = fileChooser.showSaveDialog(null);
        } else {
            fileChooser.setDialogTitle("Load Panels");
            result = fileChooser.showOpenDialog(null);
        }

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null; // User canceled
    }

    // public void callsavePanels(File file){
    // savePanels(file, panelroom);
    // }
    // Save ArrayList of panels to a file using serialization
    // public static void savePanels(File file, Array ar) {
    // try (ObjectOutputStream oos = new ObjectOutputStream(new
    // FileOutputStream(file))) {
    // oos.writeObject(ar.roomsave);
    // oos.writeObject(ar.furnituresave1);
    // System.out.println("Panels saved to: " + file.getAbsolutePath());
    // } catch (IOException e) {
    // System.out.println("Error saving panels: " + e.getMessage());
    // }
    // }

    // Load ArrayList of panels from a file using serialization
    public static ArrayList<roomsave> loadPanels(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<roomsave> panelroomo = (ArrayList<roomsave>) ois.readObject();
            System.out.println("Panels loaded from: " + file.getAbsolutePath());

            return panelroomo;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading panels: " + e.getMessage());
            return null;
        }
    }

    public static ArrayList<furnituresave> loadlabels(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<furnituresave> panelroomf = (ArrayList<furnituresave>) ois.readObject();
            System.out.println("Panels loaded from: " + file.getAbsolutePath());

            return panelroomf;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading panels: " + e.getMessage());
            return null;
        }
    }

    public void loadp(JPanel panelDB) {
        File loadFile = chooseFile(false); // File chooser for loading
        if (loadFile != null) {
            arr.roomsave.clear();
            panelDB.removeAll();
            panelDB.revalidate();
            panelDB.repaint();
            arr.roomsave = loadPanels(loadFile); // loded roomsave array added to roomsave arraylist
            arr.furnituresave1.clear();
            if (arr.roomsave != null) {
                for (roomsave panelData : arr.roomsave) {

                    panelData.getpanel().setVisible(true);
                    panelDB.add(panelData.getpanel()); // loded roomsave panel added to panelDB
                    panelDB.setVisible(true);
                    panelDB.revalidate();
                    panelDB.repaint();
                    panelData.getpanel().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = panelData.getpanel();
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    panelData.getpanel().addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e);
                        }
                    });
                }
            }
            arr.furnituresave1 = loadlabels(loadFile);
            if (arr.furnituresave1 != null) {
                for (furnituresave panelData : arr.furnituresave1) {
                    arr.addfurniture(panelData);
                    panelData.getlabel().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedroom = panelData.getlabel();
                            initialClick = e.getPoint();
                            PrevCoord = ((JLabel) e.getSource()).getLocation();
                        }
                    });
                    panelData.getlabel().addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) panelData.getnameroom());
                        }
                    });
                }
            }

        }
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

    private void moveRoom(MouseEvent e, String roomname) {
        if (selectedRoom != null) {
            // Temporarily set floor layout to null for free dragging

            // Calculate the new location
            int thisX = selectedroom.getX();
            int thisY = selectedroom.getY();

            // Get the offset based on initial click
            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            // Move the room to the new location
            int newX = thisX + xMoved;
            int newY = thisY + yMoved;
            if (!arr.furnitureOverlapsml(selectedroom, newX, newY, roomname)) {
                // selectedRoom.setLocation(newX, newY);
            }
            ;

            // Refresh the container to show the updated location

        }
    }
}