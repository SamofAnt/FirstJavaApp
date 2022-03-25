package org.itstep.msk;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private ArrayList<Integer> list = new ArrayList<>();
    public SimpleGUI() {
        super("Simple Grid");
        this.setBounds(100,100,500 ,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,4, 4, 4));

        for (int i = 0; i < 16; i++)
            list.add(i+1);
        Collections.shuffle(list);
        for (int i = 0; i < 16; i++)
        {
            JButton button = new JButton(String.valueOf(list.get(i)));
            container.add(button);
            button.addActionListener(new ButtonEventListener());
        }
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = e.getActionCommand();
            JOptionPane.showMessageDialog(null,
                    message,
                    "Button " + e.getActionCommand(),
                    JOptionPane.PLAIN_MESSAGE);
            JButton buttonThatWasClicked = (JButton) e.getSource();
            Container parent = buttonThatWasClicked.getParent();
            parent.remove(buttonThatWasClicked);
            parent.revalidate();
            parent.repaint();
        }
    }


}
