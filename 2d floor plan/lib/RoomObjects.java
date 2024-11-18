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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RoomObjects {
    JLabel selectedRoom;
    Point initialClick;
    Point PrevCoord;

    ImageIcon Bed = new ImageIcon("bed.png");
    ImageIcon Table = new ImageIcon("table.png");
    ImageIcon Sofa = new ImageIcon();
    ImageIcon Chair = new ImageIcon();
    ImageIcon diningSet = new ImageIcon();
    ImageIcon Commode = new ImageIcon();
    ImageIcon Sink = new ImageIcon();
    ImageIcon Shower = new ImageIcon();
    ImageIcon stove = new ImageIcon();
    ImageIcon Washbasin = new ImageIcon();
    ImageIcon Fridge = new ImageIcon();

    // this is a comment
    public JLabel Bed() {
        file f = new file();
        frame fbed = new frame();
        fbed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fbed.setBackground(Color.BLACK);
        fbed.setSize(580, 400);
        fbed.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfbed = new JTextField("Enter the name of the bed", 20);
        JTextField tfXbed = new JTextField("Enter the horizontal - position of the bed", 20);
        JTextField tfYbed = new JTextField("Enter the virtical - position of the bed", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelbed = new JLabel();

        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfbed.getText();
                    labelbed.setName(name);
                    labelbed.setText(name);
                    labelbed.setHorizontalTextPosition(JLabel.CENTER);
                    labelbed.setVerticalTextPosition(JLabel.CENTER);
                    labelbed.setBounds(0, 0, 382, 468);
                    System.out.println("bed has been printed");
                    labelbed.setIcon(Bed);
                    labelbed.setHorizontalAlignment(JLabel.CENTER);
                    labelbed.setVerticalAlignment(JLabel.CENTER);
                    labelbed.setOpaque(true);
                    labelbed.setVisible(true);
                    labelbed.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            selectedRoom = labelbed;
                            initialClick = e.getPoint();
                            PrevCoord = ((JPanel) e.getSource()).getLocation();

                        }

                    });
                    labelbed.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            moveRoom(e);
                        }
                    });
                }

            }
        });

        fbed.add(tfbed);
        fbed.add(tfXbed);
        fbed.add(tfYbed);
        fbed.add(cbroom);
        fbed.add(cbposition);

        fbed.add(submit);
        fbed.pack();

        fbed.setVisible(true);

        // Return the panel

        return labelbed;
    }

    public JLabel Table() {
        file f = new file();
        frame ftable = new frame();
        ftable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ftable.setSize(580, 400);
        ftable.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tftable = new JTextField("Enter the name of the table", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labeltable = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

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
                            moveRoom(e);
                        }
                    });
                }
                String name = tftable.getText();
                labeltable.setName(name);
                labeltable.setText(name);
            }
        });

        ftable.add(tftable);
        ftable.add(cbroom);
        ftable.add(cbposition);
        ftable.add(submit);
        ftable.pack();
        ftable.setVisible(true);

        // Return the panel
        return labeltable;
    }

    public JLabel Sofa() {
        file f = new file();
        frame fsofa = new frame();
        fsofa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fsofa.setSize(580, 400);
        fsofa.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfsofa = new JTextField("Enter the name of the sofa", 20);
        String[] position = { "vertical - top facing", "vertical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelsofa = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();
                    String name = tfsofa.getText();
                    labelsofa.setName(name);
                    labelsofa.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fsofa.add(tfsofa);
        fsofa.add(cbroom);
        fsofa.add(cbposition);
        fsofa.add(submit);
        fsofa.pack();
        fsofa.setVisible(true);

        // Return the panel
        return labelsofa;

    }

    public JLabel Chair() {
        file f = new file();
        frame fchair = new frame();
        fchair.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fchair.setSize(580, 400);
        fchair.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfchair = new JTextField("Enter the name of the chair", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelchair = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();
                    String name = tfchair.getText();
                    labelchair.setName(name);
                    labelchair.setText(name);
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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fchair.add(tfchair);
        fchair.add(cbroom);
        fchair.add(cbposition);
        fchair.add(submit);
        fchair.pack();
        fchair.setVisible(true);

        // Return the panel
        return labelchair;

    }

    public JLabel diningSet() {
        file f = new file();
        frame fdiningSet = new frame();
        fdiningSet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fdiningSet.setSize(580, 400);
        fdiningSet.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfdiningSet = new JTextField("Enter the name of the dining set", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labeldiningSet = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfdiningSet.getText();
                    labeldiningSet.setName(name);
                    labeldiningSet.setText(name);

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
                            moveRoom(e);
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
        file f = new file();
        frame fcommode = new frame();
        fcommode.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fcommode.setSize(580, 400);
        fcommode.setLayout(new FlowLayout());
        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfcommode = new JTextField("Enter the name of the commode", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelcommode = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfcommode.getText();
                    labelcommode.setName(name);
                    labelcommode.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fcommode.add(tfcommode);
        fcommode.add(cbroom);
        fcommode.add(cbposition);
        fcommode.add(submit);
        fcommode.pack();
        fcommode.setVisible(true);

        // Return the panel
        return labelcommode;

    }

    public JLabel Sink() {
        file f = new file();

        frame fsink = new frame();
        fsink.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fsink.setSize(580, 400);
        fsink.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfsink = new JTextField("Enter the name of the sink", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelsink = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfsink.getText();
                    labelsink.setName(name);
                    labelsink.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fsink.add(tfsink);
        fsink.add(cbroom);
        fsink.add(cbposition);
        fsink.add(submit);
        fsink.pack();
        fsink.setVisible(true);

        // Return the panel
        return labelsink;

    }

    public JLabel Shower() {
        file f = new file();

        frame fshower = new frame();
        fshower.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fshower.setSize(580, 400);
        fshower.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfshower = new JTextField("Enter the name of the shower", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelshower = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfshower.getText();
                    labelshower.setName(name);
                    labelshower.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fshower.add(tfshower);
        fshower.add(cbroom);
        fshower.add(cbposition);
        fshower.add(submit);
        fshower.pack();
        fshower.setVisible(true);

        // Return the panel
        return labelshower;

    }

    public JLabel stove() {
        file f = new file();
        frame fstove = new frame();
        fstove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fstove.setSize(580, 400);
        fstove.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfstove = new JTextField("Enter the name of the stove", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelstove = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfstove.getText();
                    labelstove.setName(name);
                    labelstove.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fstove.add(tfstove);
        fstove.add(cbroom);
        fstove.add(cbposition);
        fstove.add(submit);
        fstove.pack();
        fstove.setVisible(true);

        // Return the panel
        return labelstove;

    }

    public JLabel Washbasin() {
        file f = new file();
        frame fwashbasin = new frame();
        fwashbasin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fwashbasin.setSize(580, 400);
        fwashbasin.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tfwashbasin = new JTextField("Enter the name of the washbasin", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelwashbasin = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tfwashbasin.getText();
                    labelwashbasin.setName(name);
                    labelwashbasin.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        fwashbasin.add(tfwashbasin);
        fwashbasin.add(cbroom);
        fwashbasin.add(cbposition);
        fwashbasin.add(submit);
        fwashbasin.pack();
        fwashbasin.setVisible(true);

        // Return the panel
        return labelwashbasin;

    }

    public JLabel Fridge() {
        file f = new file();
        frame ffridge = new frame();
        ffridge.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ffridge.setSize(580, 400);
        ffridge.setLayout(new FlowLayout());

        int i = 0;
        i = f.length();
        String[] roomnames = new String[i];
        roomnames = f.getnames();
        JComboBox<String> cbroom;
        cbroom = new JComboBox<>(roomnames);

        JButton submit = new JButton("SUBMIT");
        JTextField tffridge = new JTextField("Enter the name of the fridge", 20);
        String[] position = { "virtical - top facing", "virtical - down facing", "horizontal east", "horizontal west" };
        JComboBox<String> cbposition = new JComboBox<>(position);

        String name = (String) cbroom.getSelectedItem();

        JLabel labelfridge = new JLabel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                file f = new file();

                if (e.getSource() == submit) {

                    int i = 0;
                    i = f.length();
                    String[] roomnames = new String[i];
                    roomnames = f.getnames();
                    JComboBox<String> cbroom;
                    cbroom = new JComboBox<>();

                    String name = tffridge.getText();
                    labelfridge.setName(name);
                    labelfridge.setText(name);

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
                            moveRoom(e);
                        }
                    });
                }
            }
        });

        ffridge.add(tffridge);
        ffridge.add(cbroom);
        ffridge.add(cbposition);
        ffridge.add(submit);
        ffridge.pack();
        ffridge.setVisible(true);

        // Return the panel
        return labelfridge;

    }

    private void moveRoom(MouseEvent e) {
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
            selectedRoom.setLocation(newX, newY);

            // Refresh the container to show the updated location

        }
    }

}

// class DragPanel { // extends Jpanel{
// ImageIcon image = new ImageIcon("bed.png");
// final int WIDTH = image.getIconWidth();
// final int HEIGHT = image.getIconHeight();
// Point imageCorner;
// Point prevPt;

// public void DragPanel() {
// imageCorner = new Point(0, 0);
// ClickListener clicklistener = new ClickListener();
// DragListener draglistener = new DragListener();
// this.addMouseListener(clicklistener);
// this.addMouseListener(draglistener);
// }
// // public void paintComponent(Graphics g){

// private void addMouseListener(ClickListener clicklistener) {
// // TODO Auto-generated method stub
// prevPt = e.getPoint();
// throw new UnsupportedOperationException("Unimplemented method
// 'addMouseListener'");
// }

// private void addMouseListener(DragListener draglistener) {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'addMouseListener'");
// }

// // }

// class ClickListener extends MouseAdapter {
// public void mousePressed(MouseEvent e) {
// prevPt = e.getPoint();
// }

// }

// class DragListener extends MouseMotionAdapter {
// public void mouseDragged(MouseEvent e) {
// Point currentPt = e.getPoint();
// imageCorner.translate(
// (int) (currentPt.getX() - prevPt.getX()),
// (int) (currentPt.getY() - prevPt.getY()));
// prevPt = currentPt;
// // repaint();
// }
// }

// }