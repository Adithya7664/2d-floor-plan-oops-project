import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class file implements Serializable {
    roomsave rs;
    mainModel m = new mainModel();
    String type = new String();

    ArrayList<rooms> rooms = new ArrayList<>();
    ArrayList<roomsave> roomsave = new ArrayList<>();

    ArrayList<JPanel> panelroom = new ArrayList<>();
    ArrayList<String> roomname = new ArrayList<>();
    ArrayList<String> roomtype = new ArrayList<>();

    public void getpanelname(String name) {
        roomname.add(name);
        System.out.println("//////");
        System.out.println(name);
        System.out.println("//////");
    }

    public void getpaneltypes(String type1) {
        type = type1;
        System.out.println("//////");
        System.out.println(type1);
        System.out.println("//////");

    }

    public String[] getnames() {
        String[] names = new String[panelroom.size()];
        int i = 0;
        for (JPanel panelroom : panelroom) {
            names[i] = panelroom.getName();

        }
        return names;

    }

    public void getpanel(String name, JLabel label) {
        for (JPanel panelroom : panelroom) {
            if (panelroom.getName().equals(name)) {
                panelroom.add(label);
            }
        }

    }

    public boolean isOverlapping(JPanel panel1) {
        boolean b = false;
        int i = 0;
        for (JPanel existingPanel : panelroom) {
            java.awt.Rectangle bounds1 = panel1.getBounds();

            // Get the bounds of the second panel
            java.awt.Rectangle bounds2 = existingPanel.getBounds();

            if (bounds1.intersects(bounds2)) {
                i++;
            }
            // Get the bounds of the first panel

            // Use the intersects method to check if the rectangles overlap

        }
        if (i > 0) {
            return false;
        } else {
            return true;
        }
    }

    static {
        if (true) {
            System.out.println("static block executed");

        }
    }

    public boolean addPanel(JPanel newPanel, String type) {
        if (length() == 0) {
            returnpanel(newPanel);
            panelroom.add(newPanel); // Add the new panel if no overlap
            //
            rs = new roomsave(newPanel.getX(), newPanel.getY(), newPanel.getWidth(), newPanel.getHeight(),
                    newPanel.getBackground(), newPanel.getName(), type);
            roomsave.add(rs);
            //
            System.out.println("Panel added successfully.");
            return true;

        } else {

            for (JPanel existingPanel : panelroom) {
                if (isOverlapping(newPanel)) {
                    returnpanel(newPanel);
                    panelroom.add(newPanel); // Add the new panel if no overlap
                    System.out.println("Panel added successfully.");
                    return true;
                }
            }
        }
        return false;

    }

    public void returnpanel(JPanel panel) {
        mainModel m = new mainModel();
        m.getroom(panel);

    }
    // public void addpanel(JPanel proom) {
    // panelroom.add(proom);
    // }

    // public void addroom(rooms room) {
    // rooms.add(room);
    // }

    // saving file in the save button
    public int length() {
        return panelroom.size();
    }

    JFrame frame = new JFrame();

    // public ArrayList<JPanel> getPanelsf() {
    // ArrayList<JPanel> panelfd = new ArrayList<>(); // To store the background
    // colors
    // for (JPanel panel : panelroom) {
    // panelfd.add(panel); // Add each panel's background color
    // }
    // return panelfd;
    // }

    // public ArrayList<String> getLabelText() {
    // ArrayList<String> strings = new ArrayList<>(); // To store the background
    // colors
    // for (JPanel panel : panelroom) {
    // colors.add(panel.getBackground()); // Add each panel's background color
    // }
    // return labelText;
    // }

    // public int getLabelColor() {
    // return labelColor;
    // }

    public String getfilepath(String path) {
        return path;
    }

    public void SafeFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);

        // public File selectedFile;

        // String filename = null;
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // if (option == JFileChooser.APPROVE_OPTION) {
            // selectedFile = fileChooser.getSelectedFile();
            // System.out.println("File chosen for saving: " + selectedFile.getName());
            // } else {
            // System.out.println("Save operation cancelled.");
            // }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(roomsave);
                savePanels(file, roomsave);
                JOptionPane.showMessageDialog(frame, "panels saved succesfully");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving this plan");
                // ex.printStackTrace();
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
    public static void savePanels(File file, ArrayList<roomsave> panelroomw) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(panelroomw);
            System.out.println("Panels saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving panels: " + e.getMessage());
        }
    }

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

    public void loadp() {
        File loadFile = chooseFile(false); // File chooser for loading
        if (loadFile != null) {
            ArrayList<roomsave> loadedPanels = loadPanels(loadFile);

            // Display loaded panels in a new JFrame
            if (loadedPanels != null) {
                JFrame loadedFrame = new JFrame("Loaded Panels");
                loadedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loadedFrame.setLayout(new FlowLayout());
                // file fff = new file();

                for (roomsave panelData : loadedPanels) {
                    JPanel panel = new JPanel();

                    panel.setBounds(panelData.setx(), panelData.sety(), panelData.setlength(), panelData.setheight());
                    panel.setBackground(panelData.setcolor());
                    panel.setName(panelData.setname());

                    // panel.add(label);
                    loadedFrame.add(panel);
                }

                loadedFrame.setSize(400, 300);
                loadedFrame.setVisible(true);
            }
        }
    }

    // class PanelData implements Serializable {
    // private static final long serialVersionUID = 1L;

    // private int backgroundColor;
    // private String labelText;
    // private int labelColor;

    // public PanelData(int backgroundColor, String labelText, int labelColor) {
    // this.backgroundColor = backgroundColor;
    // this.labelText = labelText;
    // this.labelColor = labelColor;
    // }

    // public int getBackgroundColor() {
    // return backgroundColor;
    // }

    // public String getLabelText() {
    // return labelText;
    // }

    // public int getLabelColor() {
    // return labelColor;
    // }
    // }

}