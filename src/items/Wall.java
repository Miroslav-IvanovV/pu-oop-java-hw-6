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
        g.setColor(this.colour);
        g.fill3DRect(col * 25,row * 25,25,25,true);
    }
}
