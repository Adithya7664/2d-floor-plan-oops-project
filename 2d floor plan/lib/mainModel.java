
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

class mainModel {

    frame f;

    public static void main(String[] args) {
        mainModel m = new mainModel();
        m.f = new frame();
        m.f.setLayout(new BorderLayout());

        // SIDE PANNEL / SIDEBAR
        JPanel panelSIDE = new JPanel();
        panelSIDE.setBackground(Color.YELLOW);
        panelSIDE.setPreferredSize(new Dimension(150, 980));
        panelSIDE.setLayout(new GridLayout(10, 1, 0, 0));
        m.f.add(panelSIDE, BorderLayout.WEST);

        // INSTRUMENT PANNEL / TOPBAR /
        JPanel paneltop = new JPanel();
        paneltop.setBackground(Color.BLACK);
        paneltop.setPreferredSize(new Dimension(100, 70));
        m.f.add(paneltop, BorderLayout.NORTH);
        // layout = = grid layout
        paneltop.setLayout(new GridLayout(1, 10, 3, 3));
        // for horizontal buttons

        // top. pannel buttons and checkbox
        JButton door = new JButton("ADD A DOOR");
        JButton window = new JButton("ADD A WINDOW");

        String[] s1 = { "ADD A ROOM", "DragAndDrop", "FromPrevoiusROOM" };
        JComboBox room = new JComboBox(s1);

        String[] s2 = { "ADD A FURNITURE", "Bed", "Table", "Sofa", "Chair", "Wardrobe", "Desk", "TV", "Shelf" };
        JComboBox furniture = new JComboBox(s2);

        String[] s3 = { "ADD A FIXTURES", "Commode", "Sink", "Shower", "Cupboard", "Bathtub", "Fridge", };
        JComboBox fixtures = new JComboBox(s3);

        paneltop.add(room);
        paneltop.add(door);
        paneltop.add(window);
        paneltop.add(furniture);
        paneltop.add(fixtures);
        paneltop.setVisible(true);

        // DRAWING BORD /
        JPanel panelDB = new JPanel();
        panelDB.setBackground(Color.BLUE);
        panelDB.setPreferredSize(new Dimension(100, 100));
        m.f.add(panelDB, BorderLayout.CENTER);

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
        panelSIDE.add(panelSIDE4, BorderLayout.SOUTH);
        //
        paneltop.setVisible(true);
        panelSIDE.setVisible(true);
        m.f.setVisible(true);

    }

}
