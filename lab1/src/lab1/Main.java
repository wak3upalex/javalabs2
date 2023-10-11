package lab1;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //scanner object to read input from user
        Hero hero = new Hero();
        hero.move();                                //show of default strategy
        String userAnswer;                     //String for choosing strategy
        String userChoice = "y";                    //String for choice to continue work of program or not
        while (userChoice.equals("y")) {
            System.out.println("Choose a strategy to use\n(1 - Walk, 2 - Ride, 3 - Fly):");
            userAnswer = scanner.nextLine();
            switch (userAnswer){
                case "1":
                    hero.setStrategy(new Walk());
                    hero.move();
                    break;
                case "2":
                    hero.setStrategy(new Ride());
                    hero.move();
                    break;
                case "3":
                    hero.setStrategy(new Fly());
                    hero.move();
                    break;
                default:
                    System.out.println("Invalid answer! Try again");
            }
            System.out.println("Do you want to continue or stop program?\ny - to continue\nn or anything else to exit");
            userChoice = scanner.nextLine();
        }

    }
}