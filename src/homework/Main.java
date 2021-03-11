package homework;

import gameRules.GameRules;
import loader.Default_level;
import rendering.Renderer;

public class Main {

    public static void main(String[] args) {
        Default_level loader     = new Default_level();
        GameRules gameRules     = new GameRules(loader.load());
        Renderer renderer       = new Renderer(gameRules);
    }
}
