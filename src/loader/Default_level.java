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
    public static int Applex;
    public static int Appley;


    Item[][] itemsCollector = new Item[30][25];

    public Item[][] load(){

        wallsSetter();
        settingTheApple();

        return itemsCollector;
    }
    /**
    a random generator
     */
    public static int randomGenerator(int bound){
        Random rand = new Random();
        int random = rand.nextInt(bound);
        return random;
    }

    /**
     setting the first apple
     */
    private void settingTheApple(){
        Applex = randomGenerator(30);
        Appley = randomGenerator(25);
        itemsCollector[Applex][Appley] = new Apple(Applex, Appley, Color.RED);
    }

    /**
        setting the walls
     */
    private void wallsSetter() {
        for (int i = 0; i < 10; i++) {
            int x = randomGenerator(30);
            int y = randomGenerator(25);
            itemsCollector[x][y] = new Wall(x,y, Color.GRAY);
        }
    }
}
