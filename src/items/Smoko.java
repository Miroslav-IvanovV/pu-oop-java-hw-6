package items;

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
        this.bodyPartAty[0] = 199;
        this.bodyPartAtx[0] = 190;

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
        int r = 2;
        r++;
        g.setColor(this.colour);
        if(r % 2 == 0){
            g.setColor(this.colour);
            g.fillRect(200,299,25,25);
        }
        g.fillRect(col * 25,row * 25,25,25);
        for(int i = 0; i < bodyParts; i++){
                g.fillRect(bodyPartAtx[i] * 25, bodyPartAty[i] * 25, 25, 25);
        }
    }

    public void move(){
        for(int i = bodyParts;i > 0; i--){
            bodyPartAtx[i] = bodyPartAtx[i - 1];
            bodyPartAty[i] = bodyPartAty[i - 1];

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
    }

}
