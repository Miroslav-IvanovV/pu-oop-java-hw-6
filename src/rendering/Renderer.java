package rendering;

import gameRules.GameRules;
import loader.Default_level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Renderer extends JFrame implements ActionListener {

    GameRules gameBoardLogic;

    public Renderer(GameRules gameBoardLogic) {

        // Reference to game logic
        this.gameBoardLogic = gameBoardLogic;

        // Reference to UI logic
        this.setSize(Default_level.SCREEN_WIDTH, Default_level.SCREEN_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new MyKeyAdapter());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }

    /**
     render the board
     */
    public void paint(Graphics g) {
        for(int row = 0; row < Default_level.NUMBER_OF_ROWS; row++) {
            for(int col = 0; col < Default_level.NUMBER_OF_COLS; col++) {

                gameBoardLogic.renderGameTile(g,row,col);
            }
        }
    }
}
