package utils;

public class Dice {

    public static int rollDice(){
        int max = 6;
        int min = 1;

        int result = (int)(Math.floor(Math.random()*(max-min-1)+min));

        return result;
    }
}
