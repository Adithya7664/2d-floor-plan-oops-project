import java.awt.Color;
import javax.swing.JFrame;

public class frame extends JFrame {
    public frame() {
        // TODO Auto-generated constructor stub
        this.setVisible(true); // sets visibulity
        this.setSize(1580, 980);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Swing"); // application / this tittle
        this.setBackground(new Color(0xFFDFdd));
        this.getContentPane().setBackground(new Color(255, 200, 210));
        this.setLayout(null);

    }
}
