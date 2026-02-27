import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class WordPicker {
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


    
}
