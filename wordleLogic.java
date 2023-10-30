import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;


public class Wordle {
    String target;
    ArrayList<String> alphabet = new ArrayList<String>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
    ArrayList<String> used = new ArrayList<String>();
    int guessCount = 0;

    public Wordle(String target1){
        target = target1;        
    }

    public Wordle(){
        try{
            target = this.getRandomWord();
        }
        catch(Exception IOException) {
            
        }
    }

    public void guess(String guessWord) throws IOException{
        ArrayList<String> word = new ArrayList<String>(Arrays.asList(guessWord.split("")));
        ArrayList<String> targetWord = new ArrayList<String>(Arrays.asList(target.split("")));
        int count = 0;
        if(validWord(guessWord)){
            for(int i = 0; i < 5; i++){
                if(targetWord.get(i).equals(word.get(i))){
                    targetWord.set(i, "*");
                    word.set(i, "[" + word.get(i) + "]");
                }
            }
            for(int i = 0; i < 5; i++){
                if(targetWord.indexOf(word.get(i)) >= 0){
                    targetWord.set(targetWord.indexOf(word.get(i)), "*");
                    word.set(i, "(" + word.get(i) + ")");
                }
            }
            System.out.println(String.join("", word));
            guessCount++;
            for (String str : word) {
                if (str.substring(0, 1).equals("[")){
                    count++;
                }
            }
            if (guessCount == 6 && count != 5) {
                System.out.println("YOU LOSE! THE WORD WAS " + target);
            }
            else if(guessCount <= 6 && count == 5){
                System.out.println("YOU WIN!");
            }
        }
        else{
            System.out.println("NOT IN WORD LIST");
        }
    }
    
    public String getWord() {
        return target;
    }

    public String getRandomWord() throws IOException{
        int line = (int)((Math.random()*5756));
        String specific_line_text = Files.readAllLines(Paths.get("words.txt")).get(line);
        return specific_line_text;
    }
    
    public static boolean validWord(String wordGuess) throws IOException{
        if (Files.readAllLines(Paths.get("words.txt")).contains(wordGuess)){
            return true;
        }
        return false;
    }
}
