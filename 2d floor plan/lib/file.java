import java.awt.*;
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

public class file {

    ArrayList<rooms> rooms = new ArrayList<>();

    ArrayList<JPanel> panelroom = new ArrayList<>();

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

    public void addpanel(JPanel proom) {
        panelroom.add(proom);
    }

    public void addroom(rooms room) {
        rooms.add(room);
    }
    // public void savefile() throws IOException {
    // try (ObjectOutputStream oos = new ObjectOutputStream(new
    // FileOutputStream("rooms.ser"))) {
    // oos.writeObject(rooms);
    // }
    // catch (IOException e) {
    // JOptionPane.showMessageDialog(null, "Error saving file");
    // }
    // }
    // public void loadfile() throws IOException, ClassNotFoundException {
    // try (ObjectInputStream ois = new ObjectInputStream(new
    // FileInputStream("rooms.ser"))) {
    // rooms = (ArrayList<rooms>) ois.readObject();

    // }
    // catch (IOException | ClassNotFoundException e) {
    // JOptionPane.showMessageDialog(null, "Error loading file");
    // }
    // }

    // saving file in the save button
    public int length() {
        return rooms.size();
    }

    JFrame frame = new JFrame();

    // private static void savePanelsAndLabels(File file, ArrayList<JPanel>
    // panels,ArrayList<JLabel> labels) {
    // try (FileWriter fileWriter = new FileWriter(file)) {
    // JSONArray jsonArray = new JSONArray();

    // // Iterate through panels and labels
    // for (int i = 0; i < panels.size(); i++) {
    // JSONObject jsonObject = new JSONObject();

    // // Save panel background color
    // Color bgColor = panels.get(i).getBackground();
    // jsonObject.put("panelBackground", bgColor.getRGB());

    // // Save label text and foreground color
    // JLabel label = labels.get(i);
    // jsonObject.put("labelText", label.getText());
    // jsonObject.put("labelColor", label.getForeground().getRGB());

    // jsonArray.put(jsonObject);
    // }

    // fileWriter.write(jsonArray.toString(4)); // Save JSON with indentation
    // System.out.println("Panels and labels saved to: " + file.getAbsolutePath());
    // } catch (IOException e) {
    // System.out.println("Error saving panels and labels: " + e.getMessage());
    // }
    // }
    public void SafeFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(panelroom);
                JOptionPane.showMessageDialog(frame, "panels saved succesfully");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving this plan");
                // ex.printStackTrace();
            }
        }

    }

    private static File chooseFile(boolean save) {
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

    // Save ArrayList of panels to a file using serialization
    private static void savePanels(File file, ArrayList<PanelData> panels) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(panels);
            System.out.println("Panels saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving panels: " + e.getMessage());
        }
    }

    // Load ArrayList of panels from a file using serialization
    private static ArrayList<PanelData> loadPanels(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<PanelData> panels = (ArrayList<PanelData>) ois.readObject();
            System.out.println("Panels loaded from: " + file.getAbsolutePath());
            return panels;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading panels: " + e.getMessage());
            return null;
        }
    }

    public void loadp() {
        File loadFile = chooseFile(false); // File chooser for loading
        if (loadFile != null) {
            ArrayList<PanelData> loadedPanels = loadPanels(loadFile);

            // Display loaded panels in a new JFrame
            if (loadedPanels != null) {
                JFrame loadedFrame = new JFrame("Loaded Panels");
                loadedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loadedFrame.setLayout(new GridLayout(loadedPanels.size(), 1));

                for (PanelData panelData : loadedPanels) {
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(panelData.getBackgroundColor()));

                    JLabel label = new JLabel(panelData.getLabelText());
                    label.setForeground(new Color(panelData.getLabelColor()));

                    panel.add(label);
                    loadedFrame.add(panel);
                }

                loadedFrame.setSize(400, 300);
                loadedFrame.setVisible(true);
            }
        }
    }

    class PanelData implements Serializable {
        private static final long serialVersionUID = 1L;

        private int backgroundColor;
        private String labelText;
        private int labelColor;

        public PanelData(int backgroundColor, String labelText, int labelColor) {
            this.backgroundColor = backgroundColor;
            this.labelText = labelText;
            this.labelColor = labelColor;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public String getLabelText() {
            return labelText;
        }

        public int getLabelColor() {
            return labelColor;
        }
    }

}