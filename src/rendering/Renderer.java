package rendering;

import gameRules.GameRules;
import items.Smoko;
import loader.Default_level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Renderer extends JPanel implements ActionListener {

    static final int DELAY = 400;
    GameRules gameBoardLogic;
    Smoko smoko = new Smoko(1,1,Color.GREEN,'R',3);
    boolean running = true;

    public Renderer(GameRules gameBoardLogic) {

        this.gameBoardLogic = gameBoardLogic;
        this.setPreferredSize(new Dimension(Default_level.SCREEN_WIDTH,Default_level.SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
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
            checkApple();
            System.out.println(smoko.getSmokosHeadx());
            System.out.println(Default_level.Applex);
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     render the game
     */
    public void draw(Graphics g) {
        for(int row = 0; row < Default_level.NUMBER_OF_ROWS; row++) {
            for(int col = 0; col < Default_level.NUMBER_OF_COLS; col++) {

                gameBoardLogic.renderGameTile(g,row,col);
            }
        }
        smoko.render(g);
    }
    public void checkApple(){
        if((smoko.getSmokosHeady() / 25 == Default_level.Applex) && ((smoko.getSmokosHeadx() / 25 == Default_level.Appley))){
            smoko.setBodyParts(smoko.getBodyParts() + 1);

        }
    }
}
