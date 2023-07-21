import java.util.*;

public class numGuessGame {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String play="yes";

        while(play.equals("yes")){
            Random rm=new Random();
            int rmNum=rm.nextInt(100);
            int guess= -1;
            int tries=0;
            while(guess!=rmNum){
                System.out.println("Guess a number between 1 to 100: ");
                guess=sc.nextInt();
                tries++;

                if(guess==rmNum){
                    System.out.println("Congratulations! You guessed the number....");
                    System.out.println("It only took you"+" "+tries+" "+ "guesses");
                    System.out.println("Would you like to play this game again? yes or no");
                } else if(guess > rmNum){
                    System.out.println("Your guessing number is too high! try again...");
                } else {
                    System.out.println("Your guessing number is too low! try again...");
                }
            }
        }
    }
}
