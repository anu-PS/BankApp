package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    InputStreamReader isr;
    BufferedReader br;

    int selectedBank, selectedOperation;

    public Main() {
//        if (isr == null)
        isr = new InputStreamReader(System.in);
//        if (br == null)
        br = new BufferedReader(isr);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);


//        switch (obj.selectedBank) {
//            default:
         // create object of Bank.
//        }
        RBI bank = new RBI();

        temp: while (true) {
            System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6.Exit");

            try {
                obj.selectedOperation = Integer.parseInt(obj.br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedOperation);

            switch (obj.selectedOperation) {
                case 1: {
                    System.out.println("Enter the amount to deposit");
                    float amt = 0;
                    try {
                        amt = Float.parseFloat(obj.br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    bank.depositMoney(amt);
                    break;
                }
                case 2: {
                    System.out.println("Enter the amount to withdraw");
                    float amt=0;
                    try {
                        amt = Float.parseFloat(obj.br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bank.withdrawMoney(amt);
                    break;
                }

                case 3: {
                    float amt = 0;
                    int duration = 0;
                    System.out.println("Enter the amount");
                    try {
                        amt = Float.parseFloat(obj.br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter the duration in years");
                    try {
                        duration = Integer.parseInt(obj.br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    bank.openFD(amt, duration);
                    break;
                }

                case 4: {
                    float amt = 0;
                    int years = 0;
                    try {
                        System.out.println("Enter the amount");
                        amt = Float.parseFloat(obj.br.readLine());
                        System.out.println("Enter the duration in years");
                        years = Integer.parseInt(obj.br.readLine());

                        bank.applyLoan(amt, years);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                default: {
                    break temp;
                }

            }
        }



//        switch (obj.selectedOperation) {
//            default:
//                // Run operation on created bank object.
//        }




    }
}