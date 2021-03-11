package items;

import loader.Default_level;

import java.awt.*;

import static loader.Default_level.UNIT_SIZE;

public class Smoko extends Item {

    private char direction;
    private int bodyParts;
    private int[] bodyPartAtx = new int[975];
    private int[] bodyPartAty = new int[975];

    public Smoko(int row , int col, Color colour, char direction, int bodyParts) {
        this.row = row;
        this.col = col;
        this.colour = colour;
        this.direction = 'R';
        this.bodyParts = bodyParts;

    }

    public int getSmokosHeadx() {
        return bodyPartAtx[0];
    }
    public int getSmokosHeady() {
        return bodyPartAty[0];
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(this.colour);
        for(int i = 0; i < bodyParts; i++){
                g.fillRect(bodyPartAtx[i], bodyPartAty[i], 25, 25);
        }
    }

    /**
     moving method for the snake
     */
    public void move(){
        for(int i = bodyParts;i > 0; i--) {
            bodyPartAtx[i] = bodyPartAtx[i - 1];
            bodyPartAty[i] = bodyPartAty[i - 1];
        }

        switch(direction) {
                case 'U':
                    bodyPartAty[0] = bodyPartAty[0] - UNIT_SIZE;
                    break;
                case 'D':
                    bodyPartAty[0] = bodyPartAty[0] + UNIT_SIZE;
                    break;
                case 'L':
                    bodyPartAtx[0] = bodyPartAtx[0] - UNIT_SIZE;
                    break;
                case 'R':
                    bodyPartAtx[0] = bodyPartAtx[0] + UNIT_SIZE;
                    break;
        }
    }
    /**
     check if the head collapse with the body
     */
    public boolean checkForBody() {
        boolean r = true;
        for(int i = bodyParts; i > 0; i--) {
            if ((bodyPartAtx[0] == bodyPartAtx[i]) && (bodyPartAty[0] == bodyPartAty[i])) r = true;
            else r = false;
        }

        return r;
    }
    /**
    checking if the snake is on the game board
     */
    public void checkingTheBoarder(){
        if(bodyPartAtx[0] < 0) bodyPartAtx[0] = Default_level.SCREEN_WIDTH;
        if(bodyPartAtx[0] > Default_level.SCREEN_WIDTH) bodyPartAtx[0] = 0;
        if(bodyPartAty[0] < 0) bodyPartAty[0] = Default_level.SCREEN_HEIGHT;
        if(bodyPartAty[0] > Default_level.SCREEN_HEIGHT) bodyPartAty[0] = 0;
    }

}
