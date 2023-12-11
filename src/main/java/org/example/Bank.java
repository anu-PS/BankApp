package org.example;



public interface Bank {

    enum LoanType {
        Home,
        Education,
        Personal,
        Car
    }

    public void depositMoney(float amount);
    public void withdrawMoney(float amount);
    public void openFD(float amount, int years);
    public void applyLoan(LoanType loanType, float amount, int years);
    public void applyCreditCard();
    public float getBalance();
    public boolean isCustomer(Customer c);
    public float getMinBalance();
    public void createAccount(Customer c);
    public void setCurrent(Customer c);
    float minBalance = 1000.0f;
}


