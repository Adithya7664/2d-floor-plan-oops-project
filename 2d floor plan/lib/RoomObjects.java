import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

<<<<<<< Updated upstream
public class RoomObjects {
    ImageIcon Bed = new ImageIcon("bed.png");
    ImageIcon Table = new ImageIcon("table.png");
=======
public class RoomObjects implements ActionListener {

    ImageIcon Bed = new ImageIcon();
    ImageIcon Table = new ImageIcon();
>>>>>>> Stashed changes
    ImageIcon Sofa = new ImageIcon();
    ImageIcon Chair = new ImageIcon();
    ImageIcon diningSet = new ImageIcon();
    ImageIcon Commode = new ImageIcon();
    ImageIcon Sink = new ImageIcon();
    ImageIcon Shower = new ImageIcon();
    ImageIcon stove = new ImageIcon();
    ImageIcon Washbasin = new ImageIcon();
    ImageIcon Fridge = new ImageIcon();

    JButton submit;

    public JLabel Bed() {
        JFrame fbed = new JFrame();
        fbed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fbed.setBackground(Color.BLACK);
        fbed.setSize(580, 400);
        fbed.setLayout(new FlowLayout());

        JFrame fimg = new JFrame();
        fimg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fimg.setSize(780, 600);
        fbed.setLayout(new FlowLayout());

        ImageIcon bedicon = new ImageIcon("bed.png");
        /*
         * JButton submitButton = new JButton("Click Me");
         * 
         * submitButton.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(fbed, "OK YOU CLICLED ME");
         * }
         * });
         */

        submit = new JButton("SUBMIT", bedicon);
        JTextField tfbed = new JTextField("Enter the name of the bed", 20);
        JTextField tfXbed = new JTextField("Enter the horizontal - position of the bed", 20);
        JTextField tfYbed = new JTextField("Enter the virtical - position of the bed", 20);

        JLabel labelbed = new JLabel();
        // labelbed.setIcon(new ImageIcon("bed.png")); // Set your image here
        // ImageIcon bedicon = new ImageIcon("bed.png");

        submit.addActionListener(new ActionListener() {
<<<<<<< Updated upstream

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {
                    String name = tfbed.getText();
                    labelbed.setName(name);
                    labelbed.setText(name);
                    labelbed.setBackground(Color.black);
                    labelbed.setBounds(100, 100, 100, 200);
                    System.out.println("bed has been printed");
                    labelbed.setIcon(Bed);
                    labelbed.setVisible(true);
                }

=======
            // System.out.println("I am here");
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(fbed, "OK YOU CLICKED ME");
                ImageIcon bedicon = new ImageIcon("bed.png");
                JLabel labelbed1 = new JLabel(bedicon);
                // labelbed.(new ImageIcon("bed.png"));
                fbed.add(labelbed1);
                // JOptionPane.showMessageDialog(fbed, "OK YOU CLICKED ME111");
                // String name = tfbed.getText();
                // labelbed.setName(name);
                // labelbed.setText(name);
>>>>>>> Stashed changes
            }
        });

        // Add mouse listeners for dragging
        MouseAdapter mouseAdapter = new MouseAdapter() {
            Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                labelbed.getComponentAt(initialClick);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Get the location of the window
                int thisX = labelbed.getLocation().x;
                int thisY = labelbed.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move the label to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                labelbed.setLocation(X, Y);
            }
        };

        labelbed.addMouseListener(mouseAdapter);
        labelbed.addMouseMotionListener(mouseAdapter);

        fbed.add(tfbed);
        fbed.add(tfXbed);
        fbed.add(tfYbed);

        fbed.add(submit);
        // fbed.add(submitButton);
        // submit.addActionListener(this);
        // fbed.add(labelbed);
        fbed.pack();

        fbed.setVisible(true);

        return labelbed;
    }

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(() -> new DraggableImage().Bed());
    // }

    /*
     * public JLabel Bed() {
     * frame fbed = new frame();
     * fbed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     * fbed.setSize(580, 400);
     * fbed.setLayout(new FlowLayout());
     * 
     * JButton submit = new JButton("SUBMIT");
     * JTextField tfbed = new JTextField("Enter the name of the bed", 20);
     * 
     * JLabel labelbed = new JLabel();
     * 
     * submit.addActionListener(new ActionListener() {
     * public void actionPerformed(ActionEvent e) {
     * String name = tfbed.getText();
     * labelbed.setName(name);
     * labelbed.setText(name);
     * }
     * });
     * 
     * fbed.add(tfbed);
     * fbed.add(submit);
     * fbed.pack();
     * fbed.setVisible(true);
     * 
     * // Return the panel
     * 
     * return labelbed;
     * }
     * 
     */

    public JLabel Table() {
        frame ftable = new frame();
        ftable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ftable.setSize(580, 400);
        ftable.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tftable = new JTextField("Enter the name of the table", 20);

        JLabel labeltable = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tftable.getText();
                labeltable.setName(name);
                labeltable.setText(name);
            }
        });

        ftable.add(tftable);
        ftable.add(submit);
        ftable.pack();
        ftable.setVisible(true);

        // Return the panel
        return labeltable;
    }

    public JLabel Sofa() {
        frame fsofa = new frame();
        fsofa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fsofa.setSize(580, 400);
        fsofa.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfsofa = new JTextField("Enter the name of the sofa", 20);

        JLabel labelsofa = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfsofa.getText();
                labelsofa.setName(name);
                labelsofa.setText(name);
            }
        });

        fsofa.add(tfsofa);
        fsofa.add(submit);
        fsofa.pack();
        fsofa.setVisible(true);

        // Return the panel
        return labelsofa;

    }

    public JLabel Chair() {
        frame fchair = new frame();
        fchair.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fchair.setSize(580, 400);
        fchair.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfchair = new JTextField("Enter the name of the chair", 20);

        JLabel labelchair = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfchair.getText();
                labelchair.setName(name);
                labelchair.setText(name);
            }
        });

        fchair.add(tfchair);
        fchair.add(submit);
        fchair.pack();
        fchair.setVisible(true);

        // Return the panel
        return labelchair;

    }

    public JLabel diningSet() {
        frame fdiningSet = new frame();
        fdiningSet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fdiningSet.setSize(580, 400);
        fdiningSet.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfdiningSet = new JTextField("Enter the name of the dining set", 20);

        JLabel labeldiningSet = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfdiningSet.getText();
                labeldiningSet.setName(name);
                labeldiningSet.setText(name);
            }
        });

        fdiningSet.add(tfdiningSet);
        fdiningSet.add(submit);
        fdiningSet.pack();
        fdiningSet.setVisible(true);

        // Return the panel
        return labeldiningSet;

    }

    public JLabel Commode() {
        frame fcommode = new frame();
        fcommode.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fcommode.setSize(580, 400);
        fcommode.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfcommode = new JTextField("Enter the name of the commode", 20);

        JLabel labelcommode = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfcommode.getText();
                labelcommode.setName(name);
                labelcommode.setText(name);
            }
        });

        fcommode.add(tfcommode);
        fcommode.add(submit);
        fcommode.pack();
        fcommode.setVisible(true);

        // Return the panel
        return labelcommode;

    }

    public JLabel Sink() {
        frame fsink = new frame();
        fsink.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fsink.setSize(580, 400);
        fsink.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfsink = new JTextField("Enter the name of the sink", 20);

        JLabel labelsink = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfsink.getText();
                labelsink.setName(name);
                labelsink.setText(name);
            }
        });

        fsink.add(tfsink);
        fsink.add(submit);
        fsink.pack();
        fsink.setVisible(true);

        // Return the panel
        return labelsink;

    }

    public JLabel Shower() {
        frame fshower = new frame();
        fshower.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fshower.setSize(580, 400);
        fshower.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfshower = new JTextField("Enter the name of the shower", 20);

        JLabel labelshower = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfshower.getText();
                labelshower.setName(name);
                labelshower.setText(name);
            }
        });

        fshower.add(tfshower);
        fshower.add(submit);
        fshower.pack();
        fshower.setVisible(true);

        // Return the panel
        return labelshower;

    }

    public JLabel stove() {
        frame fstove = new frame();
        fstove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fstove.setSize(580, 400);
        fstove.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfstove = new JTextField("Enter the name of the stove", 20);

        JLabel labelstove = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfstove.getText();
                labelstove.setName(name);
                labelstove.setText(name);
            }
        });

        fstove.add(tfstove);
        fstove.add(submit);
        fstove.pack();
        fstove.setVisible(true);

        // Return the panel
        return labelstove;

    }

    public JLabel Washbasin() {
        frame fwashbasin = new frame();
        fwashbasin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fwashbasin.setSize(580, 400);
        fwashbasin.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tfwashbasin = new JTextField("Enter the name of the washbasin", 20);

        JLabel labelwashbasin = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfwashbasin.getText();
                labelwashbasin.setName(name);
                labelwashbasin.setText(name);
            }
        });

        fwashbasin.add(tfwashbasin);
        fwashbasin.add(submit);
        fwashbasin.pack();
        fwashbasin.setVisible(true);

        // Return the panel
        return labelwashbasin;

    }

    public JLabel Fridge() {
        frame ffridge = new frame();
        ffridge.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ffridge.setSize(580, 400);
        ffridge.setLayout(new FlowLayout());

        JButton submit = new JButton("SUBMIT");
        JTextField tffridge = new JTextField("Enter the name of the fridge", 20);

        JLabel labelfridge = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tffridge.getText();
                labelfridge.setName(name);
                labelfridge.setText(name);
            }
        });

        ffridge.add(tffridge);
        ffridge.add(submit);
        ffridge.pack();
        ffridge.setVisible(true);

        // Return the panel
        return labelfridge;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

class DragPanel { // extends Jpanel{
    ImageIcon image = new ImageIcon("bed.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;

    public void DragPanel() {
        imageCorner = new Point(0, 0);
        ClickListener clicklistener = new ClickListener();
        DragListener draglistener = new DragListener();
        this.addMouseListener(clicklistener);
        this.addMouseListener(draglistener);
    }
    // public void paintComponent(Graphics g){

    private void addMouseListener(ClickListener clicklistener) {
        // TODO Auto-generated method stub
        prevPt = e.getPoint();
        throw new UnsupportedOperationException("Unimplemented method 'addMouseListener'");
    }

    private void addMouseListener(DragListener draglistener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMouseListener'");
    }

    // }

    class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
        }

    }

    class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint();
            imageCorner.translate(
                    (int) (currentPt.getX() - prevPt.getX()),
                    (int) (currentPt.getY() - prevPt.getY()));
            prevPt = currentPt;
            // repaint();
        }
    }

}