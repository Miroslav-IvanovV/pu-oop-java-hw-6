package rendering;

import gameRules.GameRules;
import items.Smoko;
import items.Wall;
import loader.Default_level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Renderer extends JPanel implements ActionListener {

    Timer timer;

    static final int DELAY = 200;
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

    /**
     starts the game
     */
    public void startGame(){
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            smoko.move();
            checkApple();
            checkForWallOrBody();
            smoko.checkingTheBoarder();
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
        if (running) {
            for (int row = 0; row < Default_level.NUMBER_OF_ROWS; row++) {
                for (int col = 0; col < Default_level.NUMBER_OF_COLS; col++) {

                    gameBoardLogic.renderGameTile(g, row, col);
                }
            }
            smoko.render(g);
            g.setColor(Color.red);
            g.setFont( new Font("Ink Free",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + (smoko.getBodyParts()-3), (Default_level.SCREEN_WIDTH - metrics.stringWidth("Score: " + smoko.getBodyParts()))/2, g.getFont().getSize());
            if(smoko.getBodyParts() > 10){
                youAreAWinner(g);
                timer.stop();

            }
        }
        else gameOver(g);
    }

    /**
        checking if the apple is on the board and if not makes a new one
     */
    public void checkApple(){
        if((smoko.getSmokosHeady() / 25 == Default_level.Applex) && ((smoko.getSmokosHeadx() / 25 == Default_level.Appley))){
            smoko.setBodyParts(smoko.getBodyParts() + 1);
            gameBoardLogic.deleteApple(Default_level.Applex,Default_level.Appley);

        }
    }

    /**
     check for walls
     */
    public void checkForWallOrBody(){
        if(gameBoardLogic.getItem(smoko.getSmokosHeady() / 25, smoko.getSmokosHeadx() / 25) instanceof Wall){
            running = false;
        }
        if(smoko.checkForBody() == true) running = false;
    }

    /**
        the game over sign
     */
    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        //Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (Default_level.SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, Default_level.SCREEN_HEIGHT / 2);
    }

    public void youAreAWinner(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + (smoko.getBodyParts() - 3), (Default_level.SCREEN_WIDTH - metrics1.stringWidth("Score: " + (smoko.getBodyParts() - 3)))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("You Are A Winner", (Default_level.SCREEN_WIDTH - metrics2.stringWidth("You Are A Winner")) / 2, Default_level.SCREEN_HEIGHT / 2);
    }
}
