package UrlShortener;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private static final LinkShortener converter = new LinkShortener();
    private static  final Scanner userInput = new Scanner(System.in);

    private static  final SecureRandom random = new SecureRandom();
    public static void main(String[] args) {
        mainMenu();




    }
    public static void mainMenu(){
        System.out.println("""
                Java Url Shortener App
                
                1. Shorten Link
                2. Retrieve Link
                0. Exit
                """);
        int response = userInput.nextInt();
        userInput.nextLine();
    }
    private static void shortenURL(){
        System.out.println("Please enter your link: ");
        String link= userInput.nextLine();
        int requestKey = random.nextInt();








    }


}
