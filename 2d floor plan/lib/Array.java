import java.awt.Label;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;
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
                panel.getBackground(), panel.getName(), type));

    }

    public void setfurniture(JLabel label){
        furnituresave.add(new furnituresave(String roomname,String roomtype,label.getText(),label.getX(),label.getY()));

    }
    // public int setlength() {
    // return length;
    // }

    // public Color setcolor() {
    // return c;
    // }

    // public int setx() {
    // return x;
    // }

    // public int sety() {
    // return y;
    // }

    // public int setheight() {
    // return height;
    // }

    // public String setname() {
    // return name;
    // }

    // public String settype() {
    // return type;
    // }

}