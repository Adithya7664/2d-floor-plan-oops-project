import java.io.Serializable;
import javax.swing.JLabel;

public class furnituresave implements Serializable {
    // JPanel panel;
    String nameroom;
    String roomtype;
    String furniturename;
    int xpos;
    int ypos;
    JLabel label;
    int lengthfur;
    int heightfur;

    furnituresave(String nameroom, String roomtype, String furniturename, int xpos, int ypos, JLabel label) {

        // this.panel = panel;
        this.nameroom = nameroom;
        this.roomtype = roomtype;
        this.furniturename = furniturename;
        this.xpos = xpos;
        this.ypos = ypos;
        this.label = label;
    }

    public void setnameroom(String nameroom1) {
        this.nameroom = nameroom1;
    }

    public void setroomtype(String roomtype1) {
        this.roomtype = roomtype1;
    }

    public void setfurniturename(String furniturename1) {
        this.furniturename = furniturename1;
    }

    public void setxpos(int xpos1) {
        this.xpos = xpos1;
    }

    public void setypos(int ypos1) {
        this.ypos = ypos1;
    }

    public String getnameroom() {
        return nameroom;
    }

    public String getroomtype() {
        return roomtype;
    }

    public String getfurniturename() {
        return furniturename;
    }

    public int getxpos() {
        return xpos;
    }

    public int getypos() {
        return ypos;
    }

    public JLabel getlabel() {
        return label;
    }

    public int getlengthfur() {
        return lengthfur;
    }

    public int getheightfur() {
        return heightfur;
    }
}