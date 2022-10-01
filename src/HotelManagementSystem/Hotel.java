package HotelManagementSystem;

import HotelManagementSystem.Enums.CustomerPaymentStatus;
import HotelManagementSystem.Enums.RoomStatus;
import HotelManagementSystem.Enums.RoomTypes;

import java.util.ArrayList;
import java.util.List;

import static HotelManagementSystem.Enums.CustomerPaymentStatus.*;
import static HotelManagementSystem.Enums.RoomStatus.*;

public class Hotel {
    private String name;
    private String location;

    List<Customer> customers = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    List<Admin> admins = new ArrayList<>();

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public List<Room> getListOfRooms() {

        return rooms;
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
        newRoom.setRoomStatus(AVAILABLE);
    }

    public int getNumberOfRooms() {
        return rooms.size();
    }

    public void addCustomer(Customer newCustomer) {
        newCustomer.setCustomerId(customers.size() + 1);
         customers.add(newCustomer);
    }

    public int getNumberOfCustomers() {

        return  customers.size();
    }
    public List<Customer> getAllCustomers() {

        return  customers;
    }

    public RoomStatus getRoomStatus(Room room) {
        return room.getRoomStatus();
    }

    public void setRoomStatus(Room room, RoomStatus roomStatus) {
         room.setRoomStatus(roomStatus);
    }

    public void bookRoom(Customer customer, Room bookRoom) {
        if(customer.getPaymentStatus() == PAID) {
           if( bookRoom.getRoomStatus() == AVAILABLE) {
               bookRoom.setRoomStatus(BOOKED);

            }
        }else System.out.println("Does not Exist");
    }

    public void setCustomerPaymentStatus(Customer newCustomer, CustomerPaymentStatus status) {
        for (Customer customer: customers) {
            if (newCustomer == customer) {
                newCustomer.setPaymentStatus(status);
            }
        }

    }

    public void checkOut(Customer customer, Room room) {
        if(getPaymentStatus(customer) == EXPIRED){
            setRoomStatus(room, AVAILABLE);
        }
    }

    public CustomerPaymentStatus getPaymentStatus(Customer customer) {
       return customer.getPaymentStatus();
    }

    public Customer getCustomer(int customerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customerId == customers.get(i).getCustomerId()){
                return customers.get(i);
            }

        }

        return null;
    }

    public Room getRoomByRoomType(RoomTypes roomType){
        for (Room newRoom:rooms) {
            if(newRoom.getRoomType() == roomType){
                if(getRoomStatus(newRoom) == AVAILABLE){
                    return newRoom;
                }
            }
        }
        System.out.println("Room no dey");

        return null;
    }

    public void makePayment(Customer customer, Room room, double amountPaid){
        if(room.getRoomPrice () <= amountPaid){
            customer.setPaymentStatus(PAID);
        }

    }
    public void addAdmin(Admin newAdmin) {
        newAdmin.setAdminId(admins.size() + 1);
        admins.add(newAdmin);
    }
    public List<Admin>getAllAdmins() {

        return admins;
    }
    public void deleteAdmin(Admin admin){
        admins.remove(admin);
    }

    public Admin getAdmin(int adminId) {
        for (Admin admin : admins) {
            if (adminId == admin.getAdminId()) {
                return admin;
            }

        }

        return null;
    }


}
