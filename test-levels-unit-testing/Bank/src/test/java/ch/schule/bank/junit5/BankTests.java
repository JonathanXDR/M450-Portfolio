package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        assertNotNull(bank.createSavingsAccount());
        assertNotNull(bank.createPromoYouthSavingsAccount());
        assertNotNull(bank.createSalaryAccount(-5000));
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        String id = bank.createSavingsAccount();
        assertTrue(bank.deposit(id, 20230101, 1000));
        assertEquals(1000, bank.getBalance(id));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20230101, 2000);
        assertTrue(bank.withdraw(id, 20230102, 1000));
        assertEquals(1000, bank.getBalance(id));
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testPrint() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20230101, 1000);
        bank.print(id);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        fail("toDo");
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        fail("toDo");
    }

}
