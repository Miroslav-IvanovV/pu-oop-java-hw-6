package gameRules;

import items.Apple;
import items.Item;
import loader.Default_level;

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

        if(itemsCollection[row][col] != null) {
            itemsCollection[row][col].render(g);
        }
    }
    /**
     deleting an apple and replacing it with new one
     */
    public void deleteApple(int x,int y){
        itemsCollection[x][y] = null;
        Default_level.Applex = Default_level.randomGenerator(30);
        Default_level.Appley = Default_level.randomGenerator(25);
        itemsCollection[Default_level.Applex][Default_level.Appley] = new Apple(Default_level.Applex,Default_level.Appley, Color.RED);
    }
    /**
     getter for the itemsCollection
     */
    public Item getItem(int x, int y){
        if((x > 0 && x < 30) && (y > 0 && y < 25)) return itemsCollection[x][y];
        else return itemsCollection[0][0];
    }
}
