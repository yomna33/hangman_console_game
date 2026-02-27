import java.util.Scanner;

public class Main {
    public static boolean end = false;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        while (end == false) {

        Game game = new Game(input);
        game.run();
        
        }

    }
}