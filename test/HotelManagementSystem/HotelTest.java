package HotelManagementSystem;

import HotelManagementSystem.Enums.RoomTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static HotelManagementSystem.Enums.CustomerPaymentStatus.EXPIRED;
import static HotelManagementSystem.Enums.CustomerPaymentStatus.PAID;
import static HotelManagementSystem.Enums.RoomStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    Hotel seryxme;

    Room room1;

    Customer customer1;


    @BeforeEach
    void setUp() {
        seryxme = new Hotel("Gaskiya Hotel", "Kaduna, Nigeria");
        room1 = new Room(1, RoomTypes.SUITE, 15000);
        customer1 = new Customer("Michael","Seriki","07062828140","dee@gmail.com");
    }

    @Test
    void testThatRoomsExistInHotel(){

        assertNotNull(seryxme.getListOfRooms());
    }
    @Test
    void testThatHotelCanHaveRooms(){
        seryxme.addRoom(room1);
        assertEquals(1, seryxme.getNumberOfRooms());

    }
    @Test
    void testThatHotelCanRegisterCustomers(){
        seryxme.addCustomer(customer1);
        assertEquals(1, seryxme.getNumberOfCustomers());


    }
    @Test
    void testThatRoomIsOccupied(){
        seryxme.addRoom(room1);
        seryxme.setRoomStatus(room1, AVAILABLE);

        assertEquals(AVAILABLE, seryxme.getRoomStatus(room1));

    }
    @Test
    void testThatHotelCanBookRoom(){
        seryxme.addRoom(room1);
        seryxme.addCustomer(customer1);
        seryxme.setCustomerPaymentStatus(customer1, PAID);

        seryxme.bookRoom(customer1, room1);

        assertEquals(BOOKED, seryxme.getRoomStatus(room1));
    }

    @Test
    void testThatCustomerCanCheckOutAndRoomBecomesAvailable(){
        seryxme.addRoom(room1);
        seryxme.addCustomer(customer1);
        seryxme.setCustomerPaymentStatus(customer1, PAID);

        seryxme.bookRoom(customer1, room1);

        seryxme.setCustomerPaymentStatus(customer1, EXPIRED);

        seryxme.checkOut(customer1,room1);

        assertEquals(EXPIRED, seryxme.getPaymentStatus(customer1));
        assertEquals(AVAILABLE, seryxme.getRoomStatus(room1));

    }
    @Test
    void testThatRoomCannotBeBookedIfNotYetAddedToHotel(){
        seryxme.bookRoom(customer1, room1);

        assertEquals(DOES_NOT_EXIST, seryxme.getRoomStatus(room1));
    }
    @Test
    void testThatCustomerCannotBookIfNotYetRegistered(){
        seryxme.addRoom(room1);
        seryxme.setCustomerPaymentStatus(customer1, PAID);

        seryxme.bookRoom(customer1, room1);

        assertEquals(AVAILABLE, seryxme.getRoomStatus(room1));
    }
}