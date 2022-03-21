package Rubiks_cube.view;

import Rubiks_cube.view.BaseWindow;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Window extends BaseWindow {

    private List<Window> gameWindows = new ArrayList<>();

    public Window() {

        JButton small = new JButton();
        small.setText("2 x 2");

        small.addActionListener(getActionListener(2));

        JButton medium = new JButton();
        medium.setText("4 x 4");

        medium.addActionListener(getActionListener(4));

        JButton large = new JButton();
        large.setText("6 x 6");

        large.addActionListener(getActionListener(6));

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(small);
        getContentPane().add(medium);
        getContentPane().add(large);
    }


    private ActionListener getActionListener(final int size) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow window = new MainWindow(size,Window.this);
                window.setVisible(true);



            }

        };
    }

    public List<Window> getWindowList() {
        return gameWindows;
    }

    @Override
    protected void doUponExit() {
        System.exit(0);
    }

}
