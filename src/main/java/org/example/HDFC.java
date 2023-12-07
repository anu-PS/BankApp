package org.example;

public class HDFC implements Bank{
    float balance;
    int count;
    float roi;
    float CCroi;

    public HDFC() {
        balance = minBalance;
        count = 0;
        roi = 6;
    }

    public void depositMoney(float amt) {
        this.balance += amt;
    }
    public void withdrawMoney(float amt){
        float toWithdraw = amt;
        float mul = count > 2 ? 0.01f: 0f;
        toWithdraw += amt * mul;
        if (this.balance - toWithdraw > 1000) {
            this.balance -= toWithdraw;
            this.count ++;
            System.out.println("Amount of " + toWithdraw + " withdrew current balance is " + this.balance);
        } else {
            System.out.println("Cannot withdraw. Not enough balance.");
        }
    }
    public void openFD(float amount, int years) {
        double intrest = amount * Math.pow((1 + (roi / 100.0)), years);
        System.out.println("The interest accumulated over years is " +  (intrest - amount));
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
                rate = roi;
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
        return 0.0f;
    }
}
