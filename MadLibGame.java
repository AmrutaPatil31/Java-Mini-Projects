import java.util.Scanner;

public class MadLibGame{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String adjective1;
        String adjective2;
        String Noun1;
        String Noun2;
        String Verbing;
        String Verb3;
       
        System.out.println("Enter the adjective:");
        adjective1=sc.nextLine();
        System.out.println("Enter any adjective:");
        adjective2=sc.nextLine();

        System.out.println("Enter the noun:");
        Noun1=sc.nextLine();
        System.out.println("Enter the noun:");
        Noun2=sc.nextLine();
        System.out.println("Enter the verb ending with ing:");

        Verbing=sc.nextLine();
        System.out.println("Enter the past participle verb:");
        Verb3=sc.nextLine();

        System.out.println("Lets start the game:");

        System.out.println(Noun1+ " is Very  " + adjective1 + "  and  " + adjective2+".");
        System.out.println("She is "+ Verbing+ " Cricket.");
        System.out.println(Noun2 +" was "+Verb3+" by "+ Noun1+" while playing Chess." );
        sc.close();
    }
}