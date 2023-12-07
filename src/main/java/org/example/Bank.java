package org.example;



public interface Bank {

    enum LoanType {
        Home,
        Education,
        Personal,
        Car
    }

    float minBalance = 1000.0f;
    public void depositMoney(float amount);
    public void withdrawMoney(float amount);
    public void openFD(float amount, int years);
    public void applyLoan(LoanType loanType, float amount, int years);
    public void applyCreditCard();
    public float getBalance();
}


