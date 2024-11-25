import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RoomObjects {
    Array arr;

    RoomObjects(Array array) {
        arr = array;
    }

    JLabel selectedRoom;
    Point initialClick;
    Point PrevCoord;

    ImageIcon Bed = new ImageIcon(
            "/Users/aderlasatvik/Downloads/java/2d-floor-plan-oops-project/2d floor plan/lib/bed (1).png");
    ImageIcon Table = new ImageIcon(
            "/Users/aderlasatvik/Downloads/java/2d-floor-plan-oops-project/2d floor plan/lib/diningtable (1).png");
    ImageIcon Sofa = new ImageIcon(
            "/Users/aderlasatvik/Downloads/java/2d-floor-plan-oops-project/2d floor plan/lib/couch (1).png");
    ImageIcon Chair = new ImageIcon(
            "/Users/aderlasatvik/Downloads/java/2d-floor-plan-oops-project/2d floor plan/lib/chair (1).png");
    ImageIcon diningSet = new ImageIcon(
            "/Users/aderlasatvik/Downloads/java/2d-floor-plan-oops-project/2d floor plan/lib/diningtable (1).png");
    ImageIcon Commode = new ImageIcon();
    ImageIcon Sink = new ImageIcon();
    ImageIcon Shower = new ImageIcon();
    ImageIcon stove = new ImageIcon();
    ImageIcon Washbasin = new ImageIcon();
    ImageIcon Fridge = new ImageIcon();

    public JLabel Bed() {

        frame fbed = new frame();
        fbed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fbed.setBackground(Color.BLACK);
        fbed.setSize(100, 400);
        fbed.setLayout(new FlowLayout());

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfbed = new JTextField("Enter the name of the bed", 20);
        JTextField tfXbed = new JTextField("Enter the horizontal - position of the bed", 20);
        JTextField tfYbed = new JTextField("Enter the virtical - position of the bed", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        JLabel labelbed = new JLabel();
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelbed.setName(tfbed.getText());
                    labelbed.setText(tfbed.getText());
                    labelbed.setHorizontalTextPosition(JLabel.CENTER);
                    labelbed.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelbed.setBounds(Integer.parseInt(tfXbed.getText()), Integer.parseInt(tfYbed.getText()), 100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("bed has been printed");
                    labelbed.setIcon(Bed);
                    labelbed.setHorizontalAlignment(JLabel.CENTER);
                    labelbed.setVerticalAlignment(JLabel.CENTER);
                    labelbed.setOpaque(true);
                    labelbed.setVisible(true);

                    if (!arr.furnitureOverlaps(labelbed, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelbed, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelbed);
                            }
                        }
                        System.out.println("labelbed is passed to  array and added to panel");
                    } else {
                        System.out.println("labelbed overlaps with existing furniture");
                    }

                    labelbed.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelbed;
                            initialClick = e.getPoint();
                            PrevCoord = ((JLabel) e.getSource()).getLocation();
                        }
                    });
                    labelbed.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fbed.add(tfbed);
        fbed.add(cbroom);
        fbed.add(tfXbed);
        fbed.add(tfYbed);
        fbed.add(cbposition);
        fbed.add(submit);
        fbed.pack();

        fbed.setVisible(true);

        return labelbed;
    }

    public JLabel Table() {
        frame ftable = new frame();
        ftable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ftable.setSize(580, 400);
        ftable.setLayout(new FlowLayout());

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tftable = new JTextField("Enter the name of the table", 20);
        JTextField tfXtable = new JTextField("Enter the horizontal - position of the table", 20);
        JTextField tfYtable = new JTextField("Enter the virtical - position of the table", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        JLabel labeltable = new JLabel();
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labeltable.setName(tftable.getText());
                    labeltable.setText(tftable.getText());
                    labeltable.setHorizontalTextPosition(JLabel.CENTER);
                    labeltable.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labeltable.setBounds(Integer.parseInt(tfXtable.getText()), Integer.parseInt(tfYtable.getText()),
                                100,
                                62);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("table has been printed");
                    labeltable.setIcon(Table);
                    labeltable.setHorizontalAlignment(JLabel.CENTER);
                    labeltable.setVerticalAlignment(JLabel.CENTER);
                    labeltable.setOpaque(true);
                    labeltable.setVisible(true);

                    if (!arr.furnitureOverlaps(labeltable, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labeltable, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labeltable);
                            }
                        }
                        System.out.println("labeltable is passed to  array and added to panel");
                    } else {
                        System.out.println("labeltable overlaps with existing furniture");
                    }
                    labeltable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labeltable;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();
                        }
                    });
                    labeltable.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        ftable.add(tftable);
        ftable.add(cbroom);
        ftable.add(tfXtable);
        ftable.add(tfYtable);
        ftable.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfsofa = new JTextField("Enter the name of the sofa", 20);
        JTextField tfXsofa = new JTextField("Enter the horizontal - position of the sofa", 20);
        JTextField tfYsofa = new JTextField("Enter the virtical - position of the sofa", 20);
        String[] position = { "vertical - top facing", "vertical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);
        String name = (String) cbroom.getSelectedItem();

        JLabel labelsofa = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelsofa.setName(tfsofa.getText());
                    labelsofa.setText(tfsofa.getText());
                    labelsofa.setHorizontalTextPosition(JLabel.CENTER);
                    labelsofa.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelsofa.setBounds(Integer.parseInt(tfXsofa.getText()), Integer.parseInt(tfYsofa.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("sofa has been printed");
                    labelsofa.setIcon(Sofa);
                    labelsofa.setHorizontalAlignment(JLabel.CENTER);
                    labelsofa.setVerticalAlignment(JLabel.CENTER);
                    labelsofa.setOpaque(true);
                    labelsofa.setVisible(true);
                    if (!arr.furnitureOverlaps(labelsofa, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelsofa, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelsofa);
                            }
                        }
                        System.out.println("labelsofa is passed to  array and added to panel");
                    } else {
                        System.out.println("labelsofa overlaps with existing furniture");
                    }

                    labelsofa.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelsofa;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelsofa.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fsofa.add(tfsofa);
        fsofa.add(cbroom);
        fsofa.add(tfXsofa);
        fsofa.add(tfYsofa);
        fsofa.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfchair = new JTextField("Enter the name of the chair", 20);
        JTextField tfXchair = new JTextField("Enter the horizontal - position of the chair", 20);
        JTextField tfYchair = new JTextField("Enter the virtical - position of the chair", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelchair = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelchair.setName(tfXchair.getText());
                    labelchair.setText(tfXchair.getText());
                    labelchair.setHorizontalTextPosition(JLabel.CENTER);
                    labelchair.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelchair.setBounds(Integer.parseInt(tfXchair.getText()), Integer.parseInt(tfYchair.getText()),
                                100,
                                62);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("chair has been printed");
                    labelchair.setIcon(Chair);
                    labelchair.setHorizontalAlignment(JLabel.CENTER);
                    labelchair.setVerticalAlignment(JLabel.CENTER);
                    labelchair.setOpaque(true);
                    labelchair.setVisible(true);

                    if (!arr.furnitureOverlaps(labelchair, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelchair, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelchair);
                            }
                        }
                        System.out.println("labeltable is passed to  array and added to panel");
                    } else {
                        System.out.println("labeltable overlaps with existing furniture");
                    }
                    labelchair.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelchair;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelchair.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fchair.add(tfchair);
        fchair.add(cbroom);
        fchair.add(tfXchair);
        fchair.add(tfYchair);
        fchair.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfdiningSet = new JTextField("Enter the name of the dining set", 20);
        JTextField tfXdiningset = new JTextField("Enter the horizontal - position of the diningset", 20);
        JTextField tfYdiningset = new JTextField("Enter the virtical - position of the diningset", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labeldiningSet = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labeldiningSet.setName(name);
                    labeldiningSet.setText(name);
                    labeldiningSet.setHorizontalTextPosition(JLabel.CENTER);
                    labeldiningSet.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labeldiningSet.setBounds(Integer.parseInt(tfXdiningset.getText()),
                                Integer.parseInt(tfYdiningset.getText()),
                                100,
                                62);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("diningset has been printed");
                    labeldiningSet.setIcon(diningSet);
                    labeldiningSet.setHorizontalAlignment(JLabel.CENTER);
                    labeldiningSet.setVerticalAlignment(JLabel.CENTER);
                    labeldiningSet.setOpaque(true);
                    labeldiningSet.setVisible(true);

                    if (!arr.furnitureOverlaps(labeldiningSet, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labeldiningSet, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labeldiningSet);
                            }
                        }
                        System.out.println("labeldiningset is passed to  array and added to panel");
                    } else {
                        System.out.println("labeldiningset overlaps with existing furniture");
                    }

                    labeldiningSet.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labeldiningSet;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labeldiningSet.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fdiningSet.add(tfdiningSet);
        fdiningSet.add(cbroom);
        fdiningSet.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfcommode = new JTextField("Enter the name of the commode", 20);
        JTextField tfXcommode = new JTextField("Enter the horizontal - position of the commode", 20);
        JTextField tfYcommode = new JTextField("Enter the virtical - position of the commode", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelcommode = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelcommode.setName(name);
                    labelcommode.setText(name);
                    labelcommode.setHorizontalTextPosition(JLabel.CENTER);
                    labelcommode.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelcommode.setBounds(Integer.parseInt(tfXcommode.getText()),
                                Integer.parseInt(tfYcommode.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("commode has been printed");
                    labelcommode.setIcon(Commode);
                    labelcommode.setHorizontalAlignment(JLabel.CENTER);
                    labelcommode.setVerticalAlignment(JLabel.CENTER);
                    labelcommode.setOpaque(true);
                    labelcommode.setVisible(true);
                    if (!arr.furnitureOverlaps(labelcommode, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelcommode, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelcommode);
                            }
                        }
                        System.out.println("labelcommode is passed to  array and added to panel");
                    } else {
                        System.out.println("labelcommode overlaps with existing furniture");
                    }

                    labelcommode.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelcommode;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelcommode.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fcommode.add(tfcommode);
        fcommode.add(cbroom);
        fcommode.add(tfXcommode);
        fcommode.add(tfYcommode);
        fcommode.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfsink = new JTextField("Enter the name of the sink", 20);
        JTextField tfXsink = new JTextField("Enter the horizontal - position of the sink", 20);
        JTextField tfYsink = new JTextField("Enter the virtical - position of the sink", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelsink = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelsink.setName(name);
                    labelsink.setText(name);
                    labelsink.setHorizontalTextPosition(JLabel.CENTER);
                    labelsink.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelsink.setBounds(Integer.parseInt(tfXsink.getText()), Integer.parseInt(tfYsink.getText()),
                                100,
                                62);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("sink has been printed");
                    labelsink.setIcon(Sink);
                    labelsink.setHorizontalAlignment(JLabel.CENTER);
                    labelsink.setVerticalAlignment(JLabel.CENTER);
                    labelsink.setOpaque(true);
                    labelsink.setVisible(true);

                    if (!arr.furnitureOverlaps(labelsink, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelsink, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelsink);
                            }
                        }
                        System.out.println("labelsink is passed to  array and added to panel");
                    } else {
                        System.out.println("labelsink overlaps with existing furniture");
                    }

                    labelsink.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelsink;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelsink.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fsink.add(tfsink);
        fsink.add(cbroom);
        fsink.add(tfXsink);
        fsink.add(tfYsink);
        fsink.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfshower = new JTextField("Enter the name of the shower", 20);
        JTextField tfXshower = new JTextField("Enter the horizontal - position of the shower", 20);
        JTextField tfYshower = new JTextField("Enter the virtical - position of the shower", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelshower = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == submit) {

                    labelshower.setName(name);
                    labelshower.setText(name);
                    labelshower.setHorizontalTextPosition(JLabel.CENTER);
                    labelshower.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelshower.setBounds(Integer.parseInt(tfXshower.getText()),
                                Integer.parseInt(tfYshower.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("shower has been printed");
                    labelshower.setIcon(Shower);
                    labelshower.setHorizontalAlignment(JLabel.CENTER);
                    labelshower.setVerticalAlignment(JLabel.CENTER);
                    labelshower.setOpaque(true);
                    labelshower.setVisible(true);
                    if (!arr.furnitureOverlaps(labelshower, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelshower, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelshower);
                            }
                        }
                        System.out.println("labelshower is passed to  array and added to panel");
                    } else {
                        System.out.println("labelshower overlaps with existing furniture");
                    }

                    labelshower.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelshower;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelshower.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fshower.add(tfshower);
        fshower.add(cbroom);
        fshower.add(tfXshower);
        fshower.add(tfYshower);
        fshower.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfstove = new JTextField("Enter the name of the stove", 20);
        JTextField tfXstove = new JTextField("Enter the horizontal - position of the stove", 20);
        JTextField tfYstove = new JTextField("Enter the virtical - position of the stove", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelstove = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelstove.setName(name);
                    labelstove.setText(name);
                    labelstove.setHorizontalTextPosition(JLabel.CENTER);
                    labelstove.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelstove.setBounds(Integer.parseInt(tfXstove.getText()), Integer.parseInt(tfYstove.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("stove has been printed");
                    labelstove.setIcon(stove);
                    labelstove.setHorizontalAlignment(JLabel.CENTER);
                    labelstove.setVerticalAlignment(JLabel.CENTER);
                    labelstove.setOpaque(true);
                    labelstove.setVisible(true);
                    if (!arr.furnitureOverlaps(labelstove, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelstove, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelstove);
                            }
                        }
                        System.out.println("labelstove is passed to  array and added to panel");
                    } else {
                        System.out.println("labelstove overlaps with existing furniture");
                    }

                    labelstove.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelstove;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelstove.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fstove.add(tfstove);
        fstove.add(cbroom);
        fstove.add(tfXstove);
        fstove.add(tfYstove);
        fstove.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfwashbasin = new JTextField("Enter the name of the washbasin", 20);
        JTextField tfXwashbasin = new JTextField("Enter the horizontal - position of the washbasin", 20);
        JTextField tfYwashbasin = new JTextField("Enter the virtical - position of the washbasin", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelwashbasin = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == submit) {

                    labelwashbasin.setName(name);
                    labelwashbasin.setText(name);
                    labelwashbasin.setHorizontalTextPosition(JLabel.CENTER);
                    labelwashbasin.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelwashbasin.setBounds(Integer.parseInt(tfXwashbasin.getText()),
                                Integer.parseInt(tfYwashbasin.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("washbasin has been printed");
                    labelwashbasin.setIcon(Washbasin);
                    labelwashbasin.setHorizontalAlignment(JLabel.CENTER);
                    labelwashbasin.setVerticalAlignment(JLabel.CENTER);
                    labelwashbasin.setOpaque(true);
                    labelwashbasin.setVisible(true);
                    if (!arr.furnitureOverlaps(labelwashbasin, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelwashbasin, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelwashbasin);
                            }
                        }
                        System.out.println("labelwashbasin is passed to  array and added to panel");
                    } else {
                        System.out.println("labelwashbasin overlaps with existing furniture");
                    }

                    labelwashbasin.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelwashbasin;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelwashbasin.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        fwashbasin.add(tfwashbasin);
        fwashbasin.add(cbroom);
        fwashbasin.add(tfXwashbasin);
        fwashbasin.add(tfYwashbasin);
        fwashbasin.add(cbposition);
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

        int i = arr.roomsave.size();
        String[] roomnames = new String[i];
        roomnames = arr.getroomnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tffridge = new JTextField("Enter the name of the fridge", 20);
        JTextField tfXfridge = new JTextField("Enter the horizontal - position of the fridge", 20);
        JTextField tfYfridge = new JTextField("Enter the virtical - position of the fridge", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelfridge = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {

                    labelfridge.setName(name);
                    labelfridge.setText(name);
                    labelfridge.setHorizontalTextPosition(JLabel.CENTER);
                    labelfridge.setVerticalTextPosition(JLabel.CENTER);
                    try {
                        labelfridge.setBounds(Integer.parseInt(tfXfridge.getText()),
                                Integer.parseInt(tfYfridge.getText()),
                                100,
                                123);
                    } catch (NumberFormatException ex) {
                        int input = JOptionPane.showOptionDialog(null,
                                "please enter a number in the number box", "error", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (input == JOptionPane.OK_OPTION) {
                            // fbed.dispose();
                        }
                    }
                    System.out.println("fridge has been printed");
                    labelfridge.setIcon(Fridge);
                    labelfridge.setHorizontalAlignment(JLabel.CENTER);
                    labelfridge.setVerticalAlignment(JLabel.CENTER);
                    labelfridge.setOpaque(true);
                    labelfridge.setVisible(true);
                    if (!arr.furnitureOverlaps(labelfridge, (String) cbroom.getSelectedItem())) {

                        arr.setfurniture(labelfridge, (String) cbroom.getSelectedItem(),
                                arr.getroomtype((String) cbroom.getSelectedItem()));
                        for (roomsave newpanel : arr.roomsave) {
                            if (newpanel.getname() == (String) cbroom.getSelectedItem()) {
                                // newpanel.add(label);
                                newpanel.updatepanel(labelfridge);
                            }
                        }
                        System.out.println("labelfridge is passed to  array and added to panel");
                    } else {
                        System.out.println("labelfridge overlaps with existing furniture");
                    }

                    labelfridge.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelfridge;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelfridge.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e, (String) cbroom.getSelectedItem());
                        }
                    });
                }
            }
        });

        ffridge.add(tffridge);
        ffridge.add(cbroom);
        ffridge.add(tfXfridge);
        ffridge.add(tfYfridge);
        ffridge.add(cbposition);
        ffridge.add(submit);
        ffridge.pack();
        ffridge.setVisible(true);

        // Return the panel
        return labelfridge;

    }

    private void moveRoom(MouseEvent e, String roomname) {
        if (selectedRoom != null) {
            // Temporarily set floor layout to null for free dragging

            // Calculate the new location
            int thisX = selectedRoom.getX();
            int thisY = selectedRoom.getY();

            // Get the offset based on initial click
            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            // Move the room to the new location
            int newX = thisX + xMoved;
            int newY = thisY + yMoved;
            if (!arr.furnitureOverlapsml(selectedRoom, newX, newY, roomname)) {
                // selectedRoom.setLocation(newX, newY);
            }
            ;

            // Refresh the container to show the updated location

        }
    }

}