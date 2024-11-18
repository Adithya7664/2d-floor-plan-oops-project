
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class data implements Serializable{
    private String name;
    private int x, y, width, height;
    public data(int x, int y, int width, int height, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public String getName() {
        return name;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    @Override
    public String toString() {
        return "Room{name='" + name + "', height=" + height + ", width=" + width +
               ", x=" + x + ", y=" + y + "}";
    }
    List<rooms> rooms = new ArrayList<>();
    public class FloorPlanner{
        public void file(){
        // List to hold room objects
        
        
        // Add sample rooms
        

        // File to store serialized data
        String filename = "floor_plan.ser";

        // Serialize the list of rooms
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(rooms);
            System.out.println("Floor plan has been serialized and saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the list of rooms
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Room> deserializedRooms = (List<Room>) ois.readObject();
            System.out.println("Deserialized floor plan:");
            for (Room room : deserializedRooms) {
                System.out.println(room);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
    }

    
}
