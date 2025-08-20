import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame2 {
     public static void main(String[] args) {

        String filePath="Words.txt";
        ArrayList<String> fileWords=new ArrayList<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(filePath))){
            String Line;
            while((Line=reader.readLine())!=null){
                fileWords.add(Line.trim());
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e){
            System.out.println("something went wrong");
        }

        Random random=new Random();
        String wordString=fileWords.get(random.nextInt(fileWords.size()));

        Scanner sc= new Scanner(System.in);
        
        ArrayList<Character> word= new ArrayList<>();
        int wrongGuess=0;

        for(char i=0;i<wordString.length();i++){
            word.add('_');
        }

        System.out.println("***********");
        System.out.println("Welcome to Hangman Game");
        System.out.println("***********");

        while(wrongGuess<6){

            System.out.println(getHangmanArt(wrongGuess));

            System.out.print("word:");  

            for(char c:word){
                System.out.print(c+" ");
            }
    
            
            System.out.print("\nguess letter:");
            char guess=sc.next().toLowerCase().charAt(0);
    
            
            if(wordString.indexOf(guess)>=0){
               
                System.out.println("correct guess");
                for(int i=0;i<wordString.length();i++){
                    if(wordString.charAt(i)==guess)
                        word.set(i, guess);
                }
            }
            else{
                wrongGuess++;
                System.out.println("Incorrect");
            }
            if(!word.contains('_')){
                System.out.println(getHangmanArt(wrongGuess));
                System.out.println("YOU WON");
                System.out.println("correct word is:"+wordString);
                break;
            }
            
            
        }

        
        if(wrongGuess>=6){
            System.out.println(getHangmanArt(wrongGuess));
            System.out.println("YOU LOST");
            System.out.println("correct word is:"+wordString);
        }
       
        sc.close();
    }
    static String getHangmanArt(int wrongGuess){
        return switch(wrongGuess){
            case 0->"""
                    """;
            case 1->"""
                     o            


                    """;
            case 2->"""
                     o 
                     |           
    
                    """;
            case 3->"""
                     o 
                    /|           
       
                    """; 
            case 4->"""
                     o 
                    /|\\          
          
                    """; 
            case 5->"""
                     o 
                    /|\\
                    /           
                    """;  
            case 6->"""
                     o 
                    /|\\
                    / \\          
               """; 
            default->"Invalid input"    ;                 
        };
    }
}
