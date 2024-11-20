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
    public static void savePanels(File file, Array ar) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ar.roomsave);
            oos.writeObject(ar.furnituresave1);
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
            // ArrayList<furnituresave1>

            // Display loaded panels in a new JFrame
            if (loadedPanels != null) {
                JFrame loadedFrame = new JFrame("Loaded Panels");
                loadedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loadedFrame.setLayout(null);

                // roomsave panelData1;

                for (roomsave panelData : loadedPanels) {
                    JPanel panel = new JPanel();
                    JLabel label = new JLabel();

                    // arr.setroom(panel, type);
                    // System.out.println("color: " + panelData.setcolor());
                    panel.add(label);
                    panel.setVisible(true);
                    loadedFrame.add(panel);
                }

                loadedFrame.setSize(900, 900);
                loadedFrame.setVisible(true);
            }
        }
    }
}