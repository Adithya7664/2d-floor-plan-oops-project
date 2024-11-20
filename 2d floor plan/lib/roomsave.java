import java.awt.Color;
import java.io.Serializable;

public class roomsave implements Serializable {
    int x;
    int y;
    int length;
    int height;
    Color c;// color of the room
    String name;
    String type;

    public roomsave(int x, int y, int length, int height, Color c, String name, String type) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.c = c;
        this.name = name;
        // this.type = type;
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

    // public String gettype() {
    // return type;
    // }

}
