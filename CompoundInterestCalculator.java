import java.util.Scanner;

public class CompoundInterestCalculator {
   public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the interst rate in %:");
        double rate=sc.nextDouble()/100;

        System.out.println("enter the years:");
        int years=sc.nextInt();

        System.out.println("enter the times componded per years:");
        double timeCompounded=sc.nextDouble();

        System.out.println("enter the amount to deposit:");
        double principle=sc.nextDouble();

        double amount;
        

       // double base=1+rate/timeCompounded;
        //double power=years*timeCompounded;

         amount=principle+Math.pow(1+rate/timeCompounded,years*timeCompounded);                  
         System.out.println("amount:"+amount);

         System.out.println("the amount after "+years+" is : rup "+amount);
         sc.close();
   } 
}
