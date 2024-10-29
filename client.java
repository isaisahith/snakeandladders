import Models.Board;
import Models.Game;
import Models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class client {
    public static void main(String[] args) {

        Player p1 = new Player("John");
        Player p2 = new Player("Kiran");
        Player p3 = new Player("Susan");
        Queue<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        Game game = new Game(10, players);

        game.start();



    }
}
