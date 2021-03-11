package jpanel;

import gameRules.GameRules;
import loader.Default_level;
import rendering.Renderer;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

    public GameFrame(){

        Default_level loader     = new Default_level();
        GameRules gameRules     = new GameRules(loader.load());
        Renderer renderer       = new Renderer(gameRules);
        this.add(renderer);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
