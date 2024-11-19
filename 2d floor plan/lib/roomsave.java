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
        this.type = type;
    }

    public int setlength() {
        return length;
    }

    public Color setcolor() {
        return c;
    }

    public int setx() {
        return x;
    }

    public int sety() {
        return y;
    }

    public int setheight() {
        return height;
    }

    public String setname() {
        return name;
    }

    public String settype() {
        return type;
    }

}
