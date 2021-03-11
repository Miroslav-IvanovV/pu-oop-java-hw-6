package items;

import java.awt.*;

public abstract class Item {
    protected int row;
    protected int col;
    protected Color colour;

    public abstract void render(Graphics g);
}
