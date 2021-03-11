package items;

import java.awt.*;

public class Apple extends Item{

    public Apple(int row , int col, Color colour) {
        this.row = row;
        this.col = col;
        this.colour = colour;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(col * 25,row * 25,25,25);
    }
}
