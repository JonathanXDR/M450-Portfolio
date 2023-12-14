package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteAccount extends Account {
    ConcreteAccount(String id) {
        super(id);
    }
}

/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {
    private Account account;

    /**
     * Test-Account initialisieren.
     */
    @BeforeEach
    public void setUp() {
        account = new ConcreteAccount("testAccount");
    }

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        assertEquals("testAccount", account.getId());
        assertEquals(0, account.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        assertTrue(account.deposit(20230101, 1000));
        assertEquals(1000, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        account.deposit(20230101, 2000);
        assertTrue(account.withdraw(20230102, 1000));
        assertEquals(1000, account.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    public void testReferences() {
        fail("toDo");
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        assertTrue(account.canTransact(20230101));
        account.deposit(20230101, 1000);
        assertFalse(account.canTransact(20221231));
        assertTrue(account.canTransact(20230102));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        account.deposit(20230101, 1000);
        account.withdraw(20230102, 500);
        account.print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        account.deposit(20230115, 1000);
        account.withdraw(20230116, 500);
        account.print(2023, 1);
    }
}
