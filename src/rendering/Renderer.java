package rendering;

import gameRules.GameRules;
import items.Smoko;
import loader.Default_level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class Renderer extends JFrame implements ActionListener {

    static final int DELAY = 1000;
    GameRules gameBoardLogic;
    Smoko smoko = new Smoko(1,2,Color.GREEN,'R',3);
    boolean running = true;
    Timer timer;

    public Renderer(GameRules gameBoardLogic) {

        // Reference to game logic
        this.gameBoardLogic = gameBoardLogic;

        // Reference to UI logic
        this.setSize(Default_level.SCREEN_WIDTH, Default_level.SCREEN_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new MyKeyAdapter());
        this.setLocationRelativeTo(null);

        startGame();

    }

    public void startGame(){
        running = true;
        Timer timer = new Timer(DELAY,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            smoko.move();
            System.out.println("asad");
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(smoko.getDirection() != 'R') {
                        smoko.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(smoko.getDirection() != 'L') {
                        smoko.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(smoko.getDirection() != 'D') {
                        smoko.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(smoko.getDirection() != 'U') {
                        smoko.setDirection('D');
                    }
                    break;
            }
        }
    }


    /**
     render the game
     */
    public void paint(Graphics g) {
        super.paint(g);
        for(int row = 0; row < Default_level.NUMBER_OF_ROWS; row++) {
            for(int col = 0; col < Default_level.NUMBER_OF_COLS; col++) {

                gameBoardLogic.renderGameTile(g,row,col);
            }
        }
        smoko.render(g);
        System.out.println("s");
    }
}
