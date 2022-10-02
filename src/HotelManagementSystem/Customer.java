package HotelManagementSystem;

import HotelManagementSystem.Enums.CustomerPaymentStatus;

import static HotelManagementSystem.Enums.CustomerPaymentStatus.NOT_PAID;

public class Customer {
    
    private CustomerPaymentStatus paymentStatus = NOT_PAID;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String phoneNumber;
    private String email;
    private int customerId;

    public Customer(String firstName, String lastName, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPaymentStatus(CustomerPaymentStatus status) {
        paymentStatus = status;
    }

    public CustomerPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return String.format("""
                Customer No: %d
                Customer First Name: %s
                Customer Last Name: %s
                Customer Gender: %s
                Customer Phone Number: %s
                Customer Email: %s
                Customer Age: %d
                """, getCustomerId(), getFirstName(), getLastName(), getGender(),getPhoneNumber(), getEmail(), getAge());
    }
}
