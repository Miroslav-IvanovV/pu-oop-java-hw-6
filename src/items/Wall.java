package items;

import java.awt.*;

public class Wall  extends Item{

    public Wall(int row , int col, Color colour) {
        this.row = row;
        this.col = col;
        this.colour = colour;

    }

    @Override
    public void render(Graphics g) {

    }
}
