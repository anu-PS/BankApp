package org.example;

import java.util.HashMap;
import java.util.Map;

public class HDFC implements Bank{
    Map<Customer, Account> customerMap;
    private float roi;
    private float CCroi;
    private float loanRoi;
    private Customer curr;
    private Account currAcc;

    static HDFC instance = null;

    private HDFC() {
        roi = 6;
        CCroi = 2;
        loanRoi = 1;
        customerMap = new HashMap<Customer, Account>();
    }

    public static HDFC getInstance() {
        if (instance == null) {
            instance = new HDFC();
        }
        return instance;
    }

    public float getMinBalance() {
        return minBalance;
    }

    public void setCurrent(Customer c) {
        curr = c;
        currAcc = customerMap.get(c);
    }

    public void createAccount(Customer c) {
        customerMap.put(c, new Account(minBalance));
    }

    public boolean isCustomer(Customer c) {
        return customerMap.containsKey(c);
    }


    public void depositMoney(float amt) {
//        customerMap.get(curr).balance += amt;
        currAcc.balance += amt;
    }
    public void withdrawMoney(float amt){
        float toWithdraw = amt;
        float mul = currAcc.count > 2 ? 0.01f: 0f;
        toWithdraw += amt * mul;
        float bal = currAcc.balance;
        if (bal - toWithdraw > 1000) {
            currAcc.balance -= toWithdraw;
            currAcc.count ++;
            System.out.println("Amount of " + amt + " withdrawn." + (toWithdraw - amt) + " is charged extra. Current balance is " + currAcc.balance);
        } else {
            System.out.println("Cannot withdraw. Not enough balance.");
        }
    }
    public void openFD(float amount, int years) {
        double interest = amount * Math.pow((1 + (roi / 100.0)), years);
        System.out.println("The interest accumulated over years is " +  (interest - amount));
    }
    public void applyLoan(LoanType loanType, float amount, int years) {
        float rate;
        switch (loanType) {
            case Home: {
                rate = 5;
                break;
            }
            case Education: {
                rate = 3;
                break;
            }
            case Personal: {
                rate = 6;
                break;
            }
            case Car: {
                rate = 8;
                break;
            }
            default: {
                rate = loanRoi;
            }
        }
        float prinDeduction = amount / years;
        System.out.println("Interest per year will be as following");
        for (int i = 0; i < years; i++) {
            System.out.println(amount * rate * 0.01);
            amount -= prinDeduction;
        }
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return currAcc.balance;
    }
    public int getTotalCustomers() {
        return customerMap.size();
    }
}
