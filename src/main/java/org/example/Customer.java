package org.example;

public class Customer implements Comparable<Customer> {
    String customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;

    public Customer(String customerName, String customerEmail, String customerAddress, String customerGender, String customerAadhar, String customerPhone) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerAadhar = customerAadhar;
        this.customerPhone = customerPhone;
    }

    public int compareTo(Customer other) {
        return customerAadhar.compareTo(other.customerAadhar);
    }

    public int hashCode() {
        return customerAadhar.hashCode();
    }

    public boolean equals(Object other) {
        return (other instanceof Customer) && (customerAadhar.equals(((Customer) other).customerAadhar));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAadhar() {
        return customerAadhar;
    }

    public void setCustomerAadhar(String customerAadhar) {
        this.customerAadhar = customerAadhar;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void showBalance() {
        System.out.println("NOT IMPLEMENTED YET: Class Customer: method showBalance");
    }
}