package UrlShortener;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final LinkShortener converter = new LinkShortener();
    private static  final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();




    }
    public static void mainMenu() {
        try {
            System.out.println("""
                                    
                                    
                    Java Url Shortener App
                                    
                    1. Shorten Link
                    2. Retrieve Link
                    0. Exit
                    """);

            int response = userInput.nextInt();
            userInput.nextLine();

            switch (response) {
                case 1 -> shortenURL();
                case 2 -> retrieveURL();
                case 0 -> exit(0);
                default -> {
                    System.out.println("Invalid Selection, Enter correct number: ");
                    mainMenu();
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Kindly enter correct number: ");
            userInput.nextLine();

            mainMenu();
        }
    }
    private static void shortenURL(){
        System.out.println("Please enter your link: ");
        String link= userInput.nextLine();

        SecureRandom random = new SecureRandom();
        int key = random.nextInt(22_000_000);

        converter.addURL(key, link);
        System.out.printf("Short link:%s%n ", converter.getShortURL(converter.getConvertedKey(key)));
        userInput.nextLine();

        mainMenu();
    }
    private static void retrieveURL(){
        System.out.println("Please enter your short link below: ");
        String shortURL = userInput.nextLine();
        String[] keyArray = shortURL.split("/");

       // int gottenKey = converter.getKey(shortURL);

        System.out.printf("Retrieved Link: %s%n", converter.getUrl(converter.getKey(keyArray[keyArray.length-1]))); //todo @Adeweh your link shortener object should be doing this internally, not on the main

        mainMenu();

    }


}