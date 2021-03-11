package gameRules;

import items.Item;

import java.awt.*;

public class GameRules {
    private Item[][] itemsCollection;

    public GameRules(Item[][] itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    /**
     help rendering the game board
     */
    public void renderGameTile(Graphics g, int row, int col) {

        itemsCollection[row][col].render(g);
    }
}
