package items;

import java.awt.*;

public class Smoko extends Item {

    private final char direction;

    public Smoko(int row , int col, Color colour, char direction) {
        this.row = row;
        this.col = col;
        this.colour = colour;
        this.direction = 'R';

    }

    @Override
    public void render(Graphics g) {

    }

    public void moving(){

    }
}
