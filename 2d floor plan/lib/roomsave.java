import java.awt.Color;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class roomsave implements Serializable {
    int x;
    int y;
    int length;
    int height;
    Color c;// color of the room
    String name;
    String type;
    JPanel panel;

    public roomsave(int x, int y, int length, int height, Color c, String name, String type, JPanel panel) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.c = c;
        this.name = name;
        this.panel = panel;
        this.type = type;
    }

    public String gettype() {
        return type;
    }

    public int getlength() {
        return length;
    }

    public Color getcolor() {
        return c;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getheight() {
        return height;
    }

    public String getname() {
        return name;
    }

    public JPanel getpanel() {
        return panel;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public void setpanel(JPanel panel) {
        this.panel = panel;
    }

    public void updatepanel(JLabel label) {
        this.panel.add(label);
    }

    // public String gettype() {
    // return type;
    // }

}
