package loader;

import items.Apple;
import items.Item;
import items.Wall;

import java.awt.*;
import java.util.Random;

public class Default_level {

    public static final int NUMBER_OF_ROWS = 30;
    public static final int NUMBER_OF_COLS = 25;
    public static final int UNIT_SIZE = 25;
    public  static final int SCREEN_WIDTH =  NUMBER_OF_COLS * UNIT_SIZE;
    public static final int SCREEN_HEIGHT =  NUMBER_OF_ROWS * UNIT_SIZE;


    Item[][] itemsCollector = new Item[30][25];

    public Item[][] load(){

        wallsSetter();
        settingTheApple();

        return itemsCollector;
    }

    public static int randomGenerator(int bound){
        Random rand = new Random();
        int random = rand.nextInt(bound);
        return random;
    }

    private void settingTheApple(){
        int x = randomGenerator(30);
        int y = randomGenerator(25);
        itemsCollector[x][y] = new Apple(x, y, Color.RED);
    }

    private void wallsSetter() {
        for (int i = 0; i < 10; i++) {
            int x = randomGenerator(30);
            int y = randomGenerator(25);
            itemsCollector[x][y] = new Wall(x,y, Color.GRAY);
        }
    }
}
