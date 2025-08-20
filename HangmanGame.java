import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String wordString="pizza";
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
