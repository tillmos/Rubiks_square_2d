package Rubiks_cube.view;

import Rubiks_cube.model.GameModel;
import Rubiks_cube.model.IranyokEnum;
import Rubiks_cube.model.NegyzetModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainWindow extends BaseWindow {

    private GameModel model;
    private int size;
    private int selectedRow;
    private int selectedCol;
    private Window window;
    private int stepsCount;

    public MainWindow(int size, Window window) {
        super();
        this.window = window;
        this.size = size;
        this.setSize(600, 600);
        GridLayout l = new GridLayout(size, size);

        this.setLayout(l);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.model = new GameModel(size);
        ArrayList<Color> colors = new ArrayList<>();
        model.generateRandomTable(size);
        selectedCol = 0;
        selectedRow = 0;

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyChar() == 'w') {
                    model.rotate(IranyokEnum.FEL, selectedCol);
                    selectedRow--;
                    if(selectedRow < 0) {
                        selectedRow = size - 1;
                    }
                    stepsCount++;
                    refresh();
                }
                if (e.getKeyChar() == 's') {
                    model.rotate(IranyokEnum.LE, selectedCol);
                    selectedRow++;
                    if(selectedRow > size - 1) {
                        selectedRow = 0;
                    }
                    stepsCount++;
                    refresh();
                }
                if (e.getKeyChar() == 'd') {
                    model.rotate(IranyokEnum.JOBBRA, selectedRow);
                    selectedCol++;
                    if(selectedCol > size - 1) {
                        selectedCol = 0;
                    }
                    stepsCount++;
                    refresh();
                }
                if (e.getKeyChar() == 'a') {
                    model.rotate(IranyokEnum.BALRA, selectedRow);
                    selectedCol--;
                    if(selectedCol < 0) {
                        selectedCol = size - 1;
                    }
                    stepsCount++;
                    refresh();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.drawModel();

    }
    public void refresh() {
        this.drawModel();
    }
    private void drawModel() {
        this.getContentPane().removeAll();
        boolean solved = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JPanel panel = new JPanel();
                NegyzetModel negyzet = model.getTabla().getSorok().get(i).getElemek().get(j);
                panel.setBorder(new LineBorder(new Color(0, 0, 0)));
                panel.setBackground(negyzet.getColor());
                panel.setVisible(true);
                final int row = i;
                final int col = j;
                if (i == selectedRow && j == selectedCol) {
                    panel.setBorder(new LineBorder(Color.black, 4));
                }
                if(j < size-1) {
                    if(model.getTabla().getSorok().get(i).getElemek().get(j).getColor() != model.getTabla().getSorok().get(i).getElemek().get(j + 1).getColor()){
                        solved = false;
                    }
                }
                panel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        selectedRow = row;
                        selectedCol = col;
                        panel.setBorder(new LineBorder(Color.black, 4));
                        refresh();
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                this.getContentPane().add(panel);
            }
        }
        this.setVisible(true);
        if (solved) {
            showGameOverMessage(stepsCount);
        }
    }
    private void showGameOverMessage(int stepsCount) {
        JOptionPane.showMessageDialog(this,
                "A játékot  " + stepsCount + " lépéssel oldottad meg.");
        newGame();
        this.setVisible(false);
        this.dispose();
    }
    private void newGame() {
        Window window = new Window();
        window.setVisible(true);

    }
    @Override
    protected void doUponExit() {
        super.doUponExit();
        window.getWindowList().remove(this);
    }





}
