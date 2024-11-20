import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Array implements Serializable {
    ArrayList<roomsave> roomsave = new ArrayList<>();
    ArrayList<JPanel> panelroom = new ArrayList<>();
    ArrayList<furnituresave> furnituresave1 = new ArrayList<>();

    public ArrayList getdata() {
        return roomsave;
    }

    public void setroom(JPanel panel, String type) {
        roomsave.add(new roomsave(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight(),
                panel.getBackground(), panel.getName(), type, panel));
        System.out.println("proom is added to roomsave array");

    }

    public void loadroom() {

    }

    public String getroomtype(String roomname) {
        for (roomsave newpanel : roomsave) {
            if (newpanel.getname() == roomname) {
                return newpanel.gettype();
            }
        }
        return null;
    }

    public void setfurniture(JLabel label, String roomname, String roomtype) {
        furnituresave1.add(new furnituresave(roomname, roomtype, label.getText(), label.getX(), label.getY()));

        for (roomsave newpanel : roomsave) {
            if (newpanel.getname() == roomname) {
                // newpanel.add(label);
                newpanel.updatepanel(label);
            }
        }

    }

    public JPanel getRoomPanel(String roomname) {
        {
            for (roomsave newpanel : roomsave) {
                if (newpanel.getname() == roomname) {
                    return newpanel.getpanel();
                }
            }
            return null;
        }
    }

    public void panelUpdate(int x, int y, JPanel panel, String roomname) {
        for (roomsave newpanel : roomsave) {
            if (newpanel.getname() == roomname) {
                newpanel.setx(x);
                newpanel.sety(y);
                newpanel.setpanel(panel);
            }
        }
    }

    public JPanel getRoompanel(String roomname) {
        for (roomsave newpanel : roomsave) {
            if (newpanel.getname() == roomname) {
                return newpanel.getpanel();
            }
        }
        return null;
    }

    public ArrayList<roomsave> roomarray() {
        return roomsave;
    }

    public boolean checkOverlaps(JPanel newPanel) {
        // Get the bounds of the new panel
        Rectangle newBounds = new Rectangle(newPanel.getX(), newPanel.getY(), newPanel.getWidth(),
                newPanel.getHeight());

        // Check against each saved room
        for (roomsave savedRoom : roomsave) {
            // Get the bounds of the saved room
            Rectangle existingBounds = new Rectangle(
                    savedRoom.getx(),
                    savedRoom.gety(),
                    savedRoom.getlength(),
                    savedRoom.getheight());

            // Check if the bounds intersect
            if (newBounds.intersects(existingBounds)) {
                System.out.println("Overlap detected with room: " + savedRoom.getname());
                JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
                return true; // Overlap detected
            }
        }

        return false; // No overlaps
    }

    public String[] getroomnames() {
        String[] roomnames = new String[roomsave.size()];
        for (roomsave newpanel : roomsave) {
            roomnames[roomsave.indexOf(newpanel)] = newpanel.getname();
        }
        return roomnames;
    }

}