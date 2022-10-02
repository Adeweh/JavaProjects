package HotelManagementSystem;

import HotelManagementSystem.Enums.RoomStatus;
import HotelManagementSystem.Enums.RoomTypes;

import static HotelManagementSystem.Enums.RoomStatus.*;

public class Room {
    private RoomStatus roomStatus = DOES_NOT_EXIST;
    private int roomNumber;
    private RoomTypes roomType;

    private double roomPrice;

    public Room(int roomNumber, RoomTypes roomType, int roomPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypes getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypes roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomPrice(double roomPrice){
        this.roomPrice = roomPrice;
    }

    public double getRoomPrice(){
        return  roomPrice;
    }

    @Override
    public String toString() {
        return String.format("""
                Room No: %d
                Room Status: %s
                Room Type: %s
                Room Price: %f
                """, getRoomNumber(), getRoomStatus(), getRoomType(), getRoomPrice());
    }
}
