import java.util.Scanner;


public class Menu {
    public static String chooseDifficulty(Scanner input) {

        System.out.println("Choose difficulty level \n 1-easy \n 2-medium \n 3-hard \n 4-clear score board \n 5-exit");
        int choice = input.nextInt();
        String difficulty = choice == 1 ? "easy" : choice == 2 ? "medium" : choice == 3 ? "hard" : choice == 4 ? "clear_scores" : choice == 5 ? "exit" : "invalid";
        return difficulty;
    }


    
}
