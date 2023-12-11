package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {


    InputStreamReader isr;
    BufferedReader br;

    int selectedBank, selectedOperation;
    public static HashMap<String, Customer> customers;

    public Main() {
//        if (isr == null)
        isr = new InputStreamReader(System.in);
//        if (br == null)
        br = new BufferedReader(isr);
        customers = new HashMap<>();
    }

    public static void main(String[] args) {
        Main obj = new Main();

        outer: while (true) {



            String adhno = obj.takeStringInput("Welcome to IBS\n Please enter your aadhar number or type EXIT to exit");

            if (adhno.equals("EXIT")) break;

            if (!customers.containsKey(adhno)) {
                System.out.println("This aadhar is not registered with the IBS.");
                int opt = obj.takeIntInput("Do you want to register for it. \n1> Yes\n2> No");
                if (opt == 2) {
                    continue;
                }
                Customer c = obj.createNewCustomer(adhno);
                customers.put(adhno, c);
            }

            Bank bank = null;
            obj.selectedBank = obj.takeIntInput("Please select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
            System.out.println("Customer Selected " + obj.selectedBank);

            switch (obj.selectedBank) {
                case 1: {
//                    bank = new ICICI();
                    break;
                }
                case 2: {
                    bank = HDFC.getInstance();
                    break;
                }
                default: {
                    bank = HDFC.getInstance();
                }
            }

            if (!bank.isCustomer(customers.get(adhno))) {
                System.out.println("Your Aadhar is not registered with selected Bank.\nDo you want to create an account with the bank.");
                int opt = obj.takeIntInput("Type 1 for YES and 2 for NO");
                if (opt == 2) continue outer;
                System.out.println("The minimum balance for this bank account is " + bank.getMinBalance());
                int t = obj.takeIntInput("Do you wish to proceed?.\n1> YES\n2> NO");
                if (t == 2) continue outer;
                bank.createAccount(customers.get(adhno));
            }
            bank.setCurrent(customers.get(adhno));


            temp: while (true) {
                obj.selectedOperation = obj.takeIntInput("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6.CheckBalance\n7.Exit");
                System.out.println("Customer Selected " + obj.selectedOperation);

                operation: switch (obj.selectedOperation) {
                    case 1: {
                        float amt = obj.takeFloatInput("Enter the amount to deposit");
                        bank.depositMoney(amt);
                        break;
                    }
                    case 2: {
                        float amt = obj.takeFloatInput("Enter the amount to withdraw");
                        bank.withdrawMoney(amt);
                        break;
                    }

                    case 3: {
                        float amt = obj.takeFloatInput("Enter the amount");
                        int duration = obj.takeIntInput("Enter the duration in years");
                        bank.openFD(amt, duration);
                        break;
                    }

                    case 4: {
                        float amt = 0;
                        int years = 0;
                        Bank.LoanType lt;
                        int tt = obj.takeIntInput("Select the loan type\n1.Home\n2.Education\n3.Personal\n4.Car");
                        switch (tt) {
                            case 1: {
                                lt = Bank.LoanType.Home;
                                break;
                            }
                            case 2: {
                                lt = Bank.LoanType.Education;
                                break;
                            }
                            case 3: {
                                lt = Bank.LoanType.Personal;
                                break;
                            }
                            case 4: {
                                lt = Bank.LoanType.Car;
                                break;
                            }
                            default: {
                                System.out.println("Invalid loan type.");
                                lt = Bank.LoanType.Personal;
                                continue temp;
                            }
                        }

                        amt = obj.takeFloatInput("Enter the amount");
                        years = obj.takeIntInput("Enter duration in years");
                        bank.applyLoan(lt,amt, years);
                        break;
                    }

                    case 6: {
                        System.out.println("Your current balance is " + bank.getBalance());
                        break;
                    }

                    default: {
                        break temp;
                    }

                }
            }

        }

        System.out.println("The total number of customers in our IBS is " + customers.size());
        System.out.println("The number of customers with account is " + HDFC.getInstance().getTotalCustomers());
        System.out.println("The number of customers with account is " + ICICI.getInstance().getTotalCustomers());




    }

    public String takeStringInput(String msg) {
        System.out.println(msg);
        String ret = null;
        try {
           ret = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;

    }

    public int takeIntInput(String msg) {
        System.out.println(msg);
        int ret = 0;
        try {
            ret = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public float takeFloatInput(String msg) {
        System.out.println(msg);
        float ret = 0f;
        try {
            ret = Float.parseFloat(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Customer createNewCustomer(String aadhar) {
        String customerName, customerEmail, customerAddress, customerGender, customerPhone;
        customerName = takeStringInput("Enter full name.");
        customerEmail = takeStringInput("Enter email");
        customerAddress = takeStringInput("Enter Address");
        customerGender = takeStringInput("Enter Gender");
//        customerAadhar = takeStringInput("Enter Aadhar number");
        customerPhone = takeStringInput("Enter mobile number");
        return new Customer(customerName, customerEmail, customerAddress, customerGender, aadhar, customerPhone);
    }
}