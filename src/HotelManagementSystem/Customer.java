package HotelManagementSystem;

import HotelManagementSystem.Enums.CustomerPaymentStatus;

import static HotelManagementSystem.Enums.CustomerPaymentStatus.NOT_PAID;

public class Customer {
    
    private CustomerPaymentStatus paymentStatus = NOT_PAID;
    private String firstName;
    private String lastName;
    private String gender;
    private String age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

}
