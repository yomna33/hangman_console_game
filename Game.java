import java.util.Scanner;



public class Game {
    private Scanner input;
    private int wrong_attempts = 0;
    private String word ;
    private boolean game_over = false;
    private char guessed[];

     
    public Game(Scanner input){

        this.input = input;
    }
    public void run() {
        while (game_over == false) {
            String difficulty = Menu.chooseDifficulty(input);
            if (difficulty.equals("exit")) {

                System.out.println("Goodbye");
                Main.end = true;

                break;

            }
            else if (difficulty.equals("clear_scores")) {

                ScoreManager.clearScores();
                System.out.println("Score board cleared!");
                continue;

            }

                word = WordPicker.wordPicker(difficulty);
                guessed = new char[word.length()];

                setupGame();
                playround();

            int score = ScoreManager.calculate(word, wrong_attempts);
            System.out.println("Your score: " + score);
            System.out.println("Enter your name to save score: ");
            String name = input.next();
            ScoreManager.save(name, score);
            ScoreManager.displayScores();

        }
    }

        

        private void setupGame() {

            wrong_attempts = 0;
            for (int i = 0; i < guessed.length; i++) {

                guessed[i] = '_';

            }

            System.out.println("Welcome to Hangman!");
            System.out.println("Guess the word: ");

        }

        private void playround() {

            while (true) {
                 System.out.print(HangmanArt.hangman_art(wrong_attempts));
            

             for (char c : guessed) System.out.print(c + " ");
             System.out.println();

             boolean correct_guess = false;
             char guess = input.next().toLowerCase().charAt(0);

            for (int j = 0; j < word.length(); j++) {

                if (guess == word.charAt(j)) {

                    guessed[j] = guess;
                    correct_guess = true;
                }
            }
            if (!correct_guess) {

                System.out.println("Wrong guess!");
                wrong_attempts++;
               
            }
            else{

                System.out.println("Correct guess!");
                
            }
            
            if (wrong_attempts == 6) {

                System.out.println("Game over! The word was: " + word);
                game_over = true;
                System.out.print(HangmanArt.hangman_art(wrong_attempts));
                break;

            }
            else if (new String(guessed).equals(word)) {

                System.out.println("Congratulations! You guessed the word: " + word);
                game_over = true;
                System.out.print(HangmanArt.hangman_art(wrong_attempts));
                break;
            }

            System.out.println(); 



            }
        
           
    }

   
}
