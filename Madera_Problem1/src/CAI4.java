/*

 */

import java.util.Random;
import java.util.Scanner;

public class CAI4 {
    static int var1 = 0, var2 = 0, correctNum = 0, studentNum = -1;
    static int message, numRight = 0, numWrong = 0, again = 1, choice = 0;
    static String correctChoices[];
    static String wrongChoices[];
    public static void quiz(){        
        correctChoices = new String[4];
        correctChoices[0] = "Very good!";
        correctChoices[1] = "Excellent!";
        correctChoices[2] = "Nice work!";
        correctChoices[3] = "Keep up the good work!";
        
        wrongChoices = new String[4];
        wrongChoices[0] = "No. Please try again.";
        wrongChoices[1] = "Wrong. Try once more.";
        wrongChoices[2] = "Don't give up!";
        wrongChoices[3] = "No. keep trying.";
        
        while (again == 1){
            generateQuestionArgument();
            displayCompletionMessage();
            System.out.println("Would you like to go again?");
            System.out.println("1- Yes  2- No");
            Scanner num = new Scanner(System.in);
            again = num.nextInt();
        }
    }
    public static void generateQuestionArgument(){
        System.out.println("Enter the difficulty:");
        System.out.println("\t1- Numbers 0 - 9");
        System.out.println("\t2- Numbers 0 - 99");
        System.out.println("\t3- Numbers 0 - 999");
        System.out.println("\t4- Numbers 0 - 9999");
        
        Scanner num = new Scanner(System.in);
        choice = num.nextInt();
        
        for (int i = 0; i < 10; i++){
            Random rand = new Random();
            // finds two nums in range chosen
            if (choice == 1){
                var1 = rand.nextInt(10);
                var2 = rand.nextInt(10);
            }
            else if (choice == 2){
                var1 = rand.nextInt(100);
                var2 = rand.nextInt(100);
            }
            else if (choice == 3){
                var1 = rand.nextInt(1000);
                var2 = rand.nextInt(1000);
            }
            else if (choice == 4){
                var1 = rand.nextInt(10000);
                var2 = rand.nextInt(10000);
            }
            askQuestion();
        }
    }
    public static void askQuestion(){
        System.out.println("What is " + var1 + " times " + var2 + "?");
        readResponse();
    }
    public static void readResponse(){
        Scanner num = new Scanner(System.in);
        studentNum = num.nextInt();
        isAnswerCorrect();
    }
    public static void isAnswerCorrect(){
        correctNum = var1 * var2;
        if (studentNum != correctNum){
            displayIncorrectResponse();
        }
        if(studentNum == correctNum)
            displayCorrectResponse();
    }
    public static void displayCorrectResponse(){
        Random rand = new Random();
        message = rand.nextInt(4);
        System.out.println("" + correctChoices[message]);
        numRight += 1;
    }
    public static void displayIncorrectResponse(){
        Random rand = new Random();
        message = rand.nextInt(4);
        
        System.out.println("" + wrongChoices[message]);
        numWrong += 1;      
    }
    public static void displayCompletionMessage(){
        System.out.println("score: " + numRight + "/10");
        if (numRight < 8)
            System.out.println("Please ask your teacher for extra help.");
        else 
            System.out.println("Congratulations, you are ready to go to the next level!");
    }
    public static void main(String[] args) {
        // only calls quiz method        
        quiz();
    }   
}
