package Models;

import utils.Dice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Queue<Player> winners;

    public Game(int dimention, Queue<Player> players) {
        Board board = new Board(dimention);
        this.board = board;
        this.players = players;
        this.winners = new LinkedList<>();
    }

    public void start(){
        while (players.size() > 1){
            Player player = players.poll();

            board.printBoard();

            System.out.println("It is " + player.getName()+" turn");
            System.out.println("Your current position is "+player.getCurrentPosition());
            System.out.println("Press any key to roll the dice");

            Scanner scanner = new Scanner(System.in);

            char roll = scanner.next().charAt(0);

            int result = Dice.rollDice();
            System.out.println("You rolled " + result);
            if(result+player.getCurrentPosition()>board.getCellCount()){
                System.out.println("You cannot make this move");
                players.add(player);
                continue;
            }else{
                int newPosition = result+player.getCurrentPosition();

                HashMap map = board.getBoardEntityHashMap();
                if(map.containsKey(newPosition)){
                    board.getBoardEntityHashMap().get(newPosition).printMessage();
                    newPosition = board.getBoardEntityHashMap().get(newPosition).getEnd();

                }

                player.setCurrentPosition(newPosition);
                System.out.println("Your new position is "+player.getCurrentPosition());
                if(player.getCurrentPosition()!=board.getCellCount()){
                    players.add(player);
                }else{
                    winners.add(player);
                }
            }






        }
        System.out.println("Game is ended");

        System.out.println("Winners are: ");

        for(Player p : winners){
            System.out.println(p.getName());
        }
    }

    public Board getBoard() {
        return board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Queue<Player> getWinners() {
        return winners;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public void setWinners(Queue<Player> winners) {
        this.winners = winners;
    }
}
