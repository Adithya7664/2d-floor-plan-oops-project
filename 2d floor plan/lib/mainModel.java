import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class mainModel {

    frame f;
    RoomObjects o;
    rooms room;
    DragPanel dp;

    // JPanel panelDB;

    public static void main(String[] args) {

        // file saving
        /*
         * public void SaveFile(){
         * JFileChooser fileChooser = new JFileChooser();
         * int option = fileChooser.showSaveDialog(frame);
         * 
         * }
         */

        int X = 0;
        int Y = 0;
        int length = 0;
        int height = 0;

        mainModel m = new mainModel();
        m.f = new frame();
        m.f.setLayout(new BorderLayout());

        m.o = new RoomObjects();
        m.room = new rooms(0, 0, 0, 0, "name");

        // SIDE PANNEL / SIDEBAR
        JPanel panelSIDE = new JPanel();
        panelSIDE.setBackground(Color.YELLOW);
        panelSIDE.setPreferredSize(new Dimension(150, 980));
        panelSIDE.setLayout(new GridLayout(10, 1, 0, 0));
        m.f.add(panelSIDE, BorderLayout.WEST);

        // INSTRUMENT PANNEL / TOPBAR /
        JPanel paneltop = new JPanel();
        paneltop.setBackground(Color.BLACK);
        paneltop.setPreferredSize(new Dimension(100, 30));
        m.f.add(paneltop, BorderLayout.NORTH);
        // layout = = grid layout
        paneltop.setLayout(new GridLayout(1, 10, 0, 3));
        // for horizontal buttons

        // top. pannel buttons and checkbox
        JButton door = new JButton("ADD A DOOR");
        JButton window = new JButton("ADD A WINDOW");

        // Define ComboBox options
        String[] s1 = { "ADD A ROOM", "DragAndDrop", "FromPreviousROOM" };
        JComboBox<String> room = new JComboBox<>(s1);

        String[] s2 = { "ADD A FURNITURE", "Bed", "Table", "Sofa", "Chair", "diningSet" };
        JComboBox<String> furniture = new JComboBox<>(s2);

        String[] s3 = { "ADD A FIXTURES", "Commode", "Sink", "Shower", "stove", "Washbasin", "Fridge" };
        JComboBox<String> fixtures = new JComboBox<>(s3);

        paneltop.add(room);
        paneltop.add(door);
        paneltop.add(window);
        paneltop.add(furniture);
        paneltop.add(fixtures);

        // DRAWING BORD /
        JPanel panelDB = new JPanel();
        panelDB.setBackground(Color.BLUE);
        panelDB.setPreferredSize(new Dimension(100, 100));
        m.f.add(panelDB, BorderLayout.CENTER);
        panelDB.setLayout(null);

        //
        JPanel panelSIDE1 = new JPanel();
        panelSIDE1.setBackground(Color.RED);
        panelSIDE1.setPreferredSize(new Dimension(150, 100));
        panelSIDE.add(panelSIDE1);
        //

        //
        JPanel panelSIDE4 = new JPanel();
        panelSIDE4.setBackground(Color.BLACK);
        panelSIDE4.setPreferredSize(new Dimension(150, 100));
        panelSIDE.add(panelSIDE4);
        //

        // Add action listener for the room combo box
        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRoom = (String) room.getSelectedItem();
                System.out.println("Selected room: " + selectedRoom);

                if ("DragAndDrop".equals(selectedRoom)) {
                    System.out.println("DragAndDrop option selected for Room");
                    // Add specific action here for "DragAndDrop"
                    JPanel proom = new JPanel();
                    proom = m.room.rooms();

                    proom.setBounds(X, Y, length, height);

                    panelDB.add(proom);
                    panelDB.revalidate();
                    panelDB.repaint();
                    panelDB.setVisible(true);

                } else if ("FromPreviousROOM".equals(selectedRoom)) {
                    System.out.println("FromPreviousROOM option selected for Room");
                    // Add specific action here for "FromPreviousROOM"
                }
            }
        });

        door.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("Selected door: ");
            }
        });

        // action listeners for funiture combobox
        furniture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFurniture = (String) furniture.getSelectedItem();
                switch (selectedFurniture) {
                    case "Bed":
                        System.out.println("Bed selected");
                        // Add specific action for Bed

                        System.out.println("1");

                        JLabel lbed = new JLabel();
                        lbed = m.o.Bed();
                        System.out.println("2");
                        m.dp.DragPanel();
                        System.out.println("3");
                        // lbed.setVisible(true);
                        JPanel lroom = new JPanel();
                        lroom = m.room.rooms();
                        lroom.add(lbed);
                        panelDB.add(lroom);
                        

                        break;
                    case "Table":
                        System.out.println("Table selected");
                        // Add specific action for Table
                        JLabel ptable = new JLabel();
                        ptable = m.o.Table();
                        panelDB.add(ptable);

                        break;
                    case "Sofa":
                        System.out.println("Sofa selected");
                        // Add specific action for Sofa
                        JLabel psofa = new JLabel();
                        psofa = m.o.Sofa();
                        panelDB.add(psofa);
                        break;
                    case "diningSet":
                        System.out.println("diningSet selected");
                        // Add specific action for diningSet
                        JLabel pDiningset = new JLabel();
                        pDiningset = m.o.diningSet();
                        panelDB.add(pDiningset);
                        break;
                    case "Chair":
                        System.out.println("Chair selected");
                        // Add specific action for Chair
                        JLabel pchair = new JLabel();
                        pchair = m.o.Chair();
                        panelDB.add(pchair);
                        break;
                    // Add more cases as needed for other furniture items
                    default:
                        System.out.println("No specific furniture selected");
                        break;

                }
            }
        });

        // Add action listener for the fixtures combo box
        fixtures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFixture = (String) fixtures.getSelectedItem();
                switch (selectedFixture) {
                    case "Commode":
                        System.out.println("Commode selected");
                        // Add specific action for Commode
                        break;
                    case "Sink":
                        System.out.println("Sink selected");
                        // Add specific action for Sink
                        break;
                    case "Shower":
                        System.out.println("Shower selected");
                        // Add specific action for Shower
                        break;
                    case "stove":
                        System.out.println("stove selected");
                        // Add specific action for stove
                        break;
                    case "Washbasin":
                        System.out.println("Washbasin selected");
                        // Add specific action for Washbasin
                        break;
                    case "Fridge":
                        System.out.println("Fridge selected");
                        // Add specific action for Fridge
                        break;

                    // Add more cases as needed for other fixtures
                    default:
                        System.out.println("No specific fixture selected");
                        break;
                }
            }
        });

        paneltop.setVisible(true);
        panelDB.setVisible(true);

        paneltop.setVisible(true);
        panelSIDE.setVisible(true);
        m.f.setVisible(true);

    }
}