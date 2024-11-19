import java.awt.BorderLayout;
import javax.swing.JPanel;

public class test {
    public static void main(String[] args) {
        file f = new file();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setName("name of panel");
        f.addPanel(panel);
        String[] s = new String[f.length()];
        s = f.getnames();

        System.out.println("2121");
        for (int i = 0; i < f.length(); i++) {
            System.out.println(s[i]);
        }
        System.out.println("daddf");
        System.out.println(f.length());
        // panel.setLayout(new BorderLayout());
        // panel.add(new JButton("Button"), BorderLayout.CENTER);
        // panel.add(new JButton("Button"), BorderLayout.NORTH);
        // panel.add(new JButton("Button"), BorderLayout.SOUTH);
        // panel.add(new JButton("Button"), BorderLayout.EAST);
        // panel.add(new JButton("Button"), BorderLayout.WEST);
        // JFrame frame = new JFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.add(panel);
        // frame.setSize(300, 300);
        // frame.setVisible(true);

    }
}