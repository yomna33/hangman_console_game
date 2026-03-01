import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class ScoreManager {
    

public static String file_path = "scores.txt";

// ensure the score file exists before any other static methods run
static {
    File file = new File(file_path);
    if (!file.exists()) { //creates the file if it doesn't exist
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating score file: " + file_path);
        }
    }
}

public static int calculate(String word, int wrong_attempts ,boolean iswin) { //calculate scores
    if (iswin) {
        
        int penality = wrong_attempts * 5;
        int score = Math.max(0, (word.length() * 10) - penality);
        return score;

    }
    else{
        int score =0;
        return score;
    }

    }

    public static void save(String name , int score) {
        Map<String, Integer> scoreBoard = new HashMap<>();

        try(BufferedReader reader = new BufferedReader (new FileReader(file_path))) { //read existing scores from the file
            String line;
            
            while((line = reader.readLine()) != null) {
                String [] parts = line.split(":"); //splits the line into name and score
                scoreBoard.put(parts[0] , Integer.parseInt(parts[1])); 

            }
            if (scoreBoard.containsKey(name)) { //check if the player already has a score in the board
                int currentScore = scoreBoard.get(name);
                currentScore += score;
                scoreBoard.put(name, currentScore);

            }
            else {

                scoreBoard.put(name, score);
            }
        }
        
        catch(IOException e){

            System.out.println("Error reading score file : " + file_path);

        }



        try(BufferedWriter writer = new BufferedWriter (new FileWriter(file_path))){

            for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue()); //writes the scores to the file
                writer.newLine();
            }
        }
         catch(IOException e){

            System.out.println("Error writing to score file : " + file_path);
         }

    }
    
    public static void displayScores() {
        try(BufferedReader reader = new BufferedReader (new FileReader (file_path))){

            String line;
            System.out.println("Score board : ");
            while((line = reader.readLine()) != null) {

                String[] ScoreBoard = line.split(":");
                System.out.println(ScoreBoard[0] + " : " + ScoreBoard[1]); //prints the name and score of each player in the score board

            }
            
        }
        
        catch(IOException e){

            System.out.println("Error reading score file : " + file_path);

        }
        

    }

    public static void clearScores() {
            try(BufferedWriter writer = new BufferedWriter (new FileWriter(file_path))){ //clears the score file
                
            }

            catch(IOException e){

                System.out.println("Error clearing score file : " + file_path);
            }
        }


        

    
    
}
