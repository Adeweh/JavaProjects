package HotelManagementSystem;

import HotelManagementSystem.Enums.RoomStatus;
import HotelManagementSystem.Enums.RoomTypes;

import java.util.Objects;
import java.util.Scanner;

import static HotelManagementSystem.Enums.RoomTypes.*;

public class Main {

    private static Hotel hotel = new Hotel("Gaskiya hotel","Kaduna, Nigeria");

    private static int customerId;
    private static Scanner userInput = new Scanner(System.in);



    public static void main(String[] args) {
        Admin admin = new Admin("Dorcas", "Password");
        hotel.addAdmin(admin);

        mainMenu();
    }

    private static void adminMenu(){

        System.out.println("WELCOME TO GASKIYA HOTELS");

        System.out.println("Enter username: ");
        String username = userInput.nextLine();

        System.out.println("Enter password: ");
        String password = userInput.nextLine();

        for (Admin admin: hotel.getAllAdmins() ) {
            if(Objects.equals(admin.getUserName(), username)){
                if(Objects.equals(admin.getPassword(), password)){
                    adminOptions();
                }
                else System.out.println("Login failed. Try again");
                mainMenu();
            }

        }
        System.out.println("Admin not found");
        mainMenu();


   }

    private static void mainMenu() {

        System.out.println("""
                 WELCOME TO GASKIYA HOTELS
                 
                 Please login:
                 1.Admin
                 2.Customer
                 0.Exit 
                """);
        int option = userInput.nextInt();
        userInput.nextLine();

        if (option == 1) adminMenu();
        else if (option == 2) customerLogin();
        else if (option == 0) {
            System.out.println("Hope you enjoyed using our services. Thank you");
        } else {
            System.out.println("Invalid Selection. Try again Please");
            mainMenu();
        }
    }
        private static void adminOptions() {
            System.out.println("""
                                    
                              
                    1.REGISTER CUSTOMER
                    2.ADD ROOM
                    3.CHECK ROOM STATUS
                    4.VIEW ALL ROOMS
                    5.CHECK CUSTOMER DETAILS
                    6.CHECKOUT CUSTOMER
                    7.EXIT           
                    """);

            int prompt = userInput.nextInt();
            switch (prompt) {
                case 1 -> register();
                case 2 -> addRoom();
                case 3 -> roomStatus();
                case 4 -> viewAllRooms();
                case 5 -> customerDetails();
                case 6-> checkOut();
                case 7-> mainMenu();
            }
        }

    private static void checkOut() {
    }
    private static void customerDetails() {
    }

    private static void viewAllRooms() {
    }

    private static void roomStatus() {
    }

    private static void addRoom() {
        System.out.println("Enter Room Number: ");
        int roomNumber = userInput.nextInt();

        System.out.println("""
                SELECT ROOM TYPE
                1. SUITE
                2. PRESIDENTIAL SUITE
                3. STUDIO ROOM
                4. QUEEN ROOM
                5. KING ROOM
                6. EXECUTIVE SUITE
                7. FAMILY ROOM
                """);
        int response = userInput.nextInt();
        switch (response) {
            case 1 -> createRoom(roomNumber,SUITE,15000);
            case 2 -> createRoom(roomNumber, PRESIDENTIAL_SUITE, 80000);
            case 3 -> createRoom(roomNumber, STUDIO,25000);
            case 4 -> createRoom(roomNumber, QUEEN,37000);
            case 5 -> createRoom(roomNumber, KING,53000);
            case 6 -> createRoom(roomNumber, EXECUTIVE_SUITE, 72000);
            case 7 -> createRoom(roomNumber, FAMILY_ROOM, 89000);
        }
        mainMenu();
    }
    private static void createRoom(int roomNumber, RoomTypes roomType, int roomPrice){

        Room newRoom = new Room(roomNumber, roomType, roomPrice );
        hotel.addRoom(newRoom);
    }
    private static void register() {
        System.out.println("Enter first name: ");
        String firstName = userInput.next();

        System.out.println("Enter last name: ");
        String lastName = userInput.next();

        System.out.println("Enter phone Number: ");
        String phoneNumber = userInput.next();

        System.out.println("Enter email: ");
        String email = userInput.next();

        Customer newCustomer = new Customer(firstName,lastName,phoneNumber,email);
        hotel.addCustomer(newCustomer);

        System.out.println("Successfully Registered");

        mainMenu();

    }

    private static void customerOptions() {
        System.out.println("""
                1.BOOK ROOM
                2.CHECK AVAILABLE ROOMS
                3.CHECK ROOM DETAILS
                4.EXIT
                                
                """);

        int prompt = userInput.nextInt();
        userInput.nextLine();
        switch (prompt) {
            case 1 -> bookRoom();
            case 4->mainMenu();
        }
    }

    private static void customerLogin() {
        System.out.println("Enter your email: ");
        String email = userInput.nextLine();
        for (Customer customer:hotel.getAllCustomers()) {
            if(Objects.equals(customer.getEmail(), email)){
                customerOptions();
            }
        }System.out.println("User not registered. Try again");
        register();
    }


    private static void availableRooms() {

    }

    private static void bookRoom() {
        System.out.println("Enter customer id: ");
        customerId = userInput.nextInt();
        Customer newCustomer = hotel.getCustomer(customerId);
        if ( newCustomer == null){
            System.out.println("Invalid Id. Customer does not exist");
            bookRoom();
        }
        System.out.println("""
                SELECT ROOM TYPE
                1. SUITE
                2. PRESIDENTIAL SUITE
                3. STUDIO ROOM
                4. QUEEN ROOM
                5. KING ROOM
                6. EXECUTIVE SUITE
                7. FAMILY ROOM
                """);
        int response = userInput.nextInt();
        switch (response){
            case 1-> roomBooking(newCustomer, SUITE);
            case 2-> roomBooking(newCustomer, PRESIDENTIAL_SUITE);
            case 3-> roomBooking(newCustomer, STUDIO);
            case 4-> roomBooking(newCustomer, QUEEN);
            case 5-> roomBooking(newCustomer, KING);
            case 6-> roomBooking(newCustomer, EXECUTIVE_SUITE);
            case 7-> roomBooking(newCustomer, FAMILY_ROOM);
        }
        mainMenu();


    }

    private static void roomBooking(Customer newCustomer, RoomTypes roomType){
        for (Room newRoom: hotel.getListOfRooms()) {
            if(newRoom.getRoomType() == roomType){
                System.out.printf("Please make payment of N%,f: ", newRoom.getRoomPrice());
                double amount = userInput.nextDouble();

                hotel.makePayment(newCustomer,newRoom, amount);
                hotel.bookRoom(newCustomer, newRoom);
                mainMenu();
            }


        }
        System.out.println("Room is unavailable");
    }



}
