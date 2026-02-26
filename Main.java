import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
         System.out.println("Welcome to the hangman game!");

        while (true) {
            
        System.out.println("Choose difficulty level \n 1-easy \n 2-medium \n 3-hard \n 4-exit");
        int num = input.nextInt();
        String choice = num == 1 ? "easy" : num == 2 ? "medium" : num == 3 ? "hard" : num == 4 ? "exit" : "invalid";

        if (choice.equals("exit")) {

            System.out.println("Goodbye");
            break;

        }

        int wrong_attempts = 0;
        String word = wordPicker(choice);
        boolean game_over = false;
        char guessed[] = new char[word.length()];

        for (int i = 0; i < guessed.length; i++) {
            
            guessed[i] = '_';

        }
        
       
        System.out.println("Guess the word: ");
        

        while (game_over == false) {

            System.out.print(hangman_art(wrong_attempts));
            

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
                System.out.print(hangman_art(wrong_attempts));
                break;
            }
            else if (new String(guessed).equals(word)) {
                System.out.println("Congratulations! You guessed the word: " + word);
                game_over = true;
                System.out.print(hangman_art(wrong_attempts));

                break;
            }

            

            System.out.println(); 



        }
            

        

    

    }
    input.close();
    }

    static String wordPicker(String difficulty)  { 
             String file_path = "words.txt";
             ArrayList<String> wordsList = new ArrayList<>();
             try(BufferedReader reader = new BufferedReader(new FileReader(file_path));){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(":");
                if (parts[0].equalsIgnoreCase(difficulty)) {
                     wordsList.add(parts[1]);
                    } 
                }  

             }
              catch(FileNotFoundException e){
            System.out.println("File not found: " + file_path);
        }
        catch(IOException e){
            System.out.println("Error reading file: " + file_path);
        }
        Random rand = new Random();
        String word = wordsList.get(rand.nextInt(wordsList.size())); // GET A RANDOM WORD FROM THE LIST
        return word;
    }

    static String hangman_art(int wrong_attempts) {
        switch(wrong_attempts) {
            case 0 -> {
                return """
                         ---
                        |   |
                            |
                            |
                            |
                            |
                        =========
                        """;
            }
            case 1 -> {
                return """
                         ---
                        |   |
                        O   |
                            |
                            |
                            |
                        =========
                        """;
            }
            case 2 -> {
                return """
                         ---
                        |   |
                        O   |
                        |   |
                            |
                            |
                        =========
                        """;
            }
            case 3 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|   |
                            |
                            |
                        =========
                        """;
            }
            case 4 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                            |
                            |
                        =========
                        """;
            }
            case 5 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                       /    |
                            |
                        =========
                        """;
            }
            case 6 -> {
                return """
                         ---
                        |   |
                        O   |
                       /|\\  |
                       / \\  |
                            |
                        =========
                        """;
            }            default -> {
                return "Invalid number of attempts.";
            }

        }
    }
    
    
    
}

