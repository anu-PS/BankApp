package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BankTest {

    static Bank bank1;
    static Bank bank2;

    @BeforeAll()
    public static void Init() {
        bank1 = HDFC.getInstance();
        bank2 = ICICI.getInstance();

        Customer c = new Customer("asfd", "dsaf", "dfds", "dsf", "dfds", "dfds");


    }

   @Test()
    public void depositTest() {
        float amt = 1000.0f;
   }
}
