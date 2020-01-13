package atm;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ATMMachineTest {

    @Test
    public void givenA100Amount_WhenWithdrawingSomeCash_ShouldReturn1Bill() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(100);

        assertThat(withdraw, is(new Withdraw(1, 100)));
    }

    @Test
    public void givenA1000Amount_WhenWithdrawingSomeCash_ShouldReturn10BillsOf100() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(1000);

        assertThat(withdraw, is(new Withdraw(10, 100)));
    }

    @Test
    public void givenA50Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf50() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(50);

        assertThat(withdraw, is(new Withdraw(1, 50)));
    }

    @Test
    public void givenA20Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf20() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(20);

        assertThat(withdraw, is(new Withdraw(1, 20)));
    }

    @Test
    public void givenA10Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf10() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(10);

        assertThat(withdraw, is(new Withdraw(1, 10)));
    }

    @Test
    public void givenA5Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf5() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(5);

        assertThat(withdraw, is(new Withdraw(1, 5)));
    }

    @Test
    public void givenA2Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf2() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(2);

        assertThat(withdraw, is(new Withdraw(1, 2)));
    }

    @Test
    public void givenAn1Amount_WhenWithdrawingSomeCash_ShouldReturn1BillOf1() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(1);

        assertThat(withdraw, is(new Withdraw(1, 1)));
    }

    @Test
    public void givenANegativeAmount_WhenWithdrawingSomeCash_ShouldThrownAnException() {
        InvalidAmountException invalidAmountException = assertThrows(InvalidAmountException.class, () -> {
            ATMMachine atmMachine = new ATMMachine();

            atmMachine.withDraw(-1);
        });

        assertEquals("Invalid amount provided: -1", invalidAmountException.getMessage());
    }

    @Test
    public void givenAZeroAmount_WhenWithdrawingSomeCash_ShouldThrownAnException() {
        InvalidAmountException invalidAmountException = assertThrows(InvalidAmountException.class, () -> {
            ATMMachine atmMachine = new ATMMachine();

            atmMachine.withDraw(0);
        });

        assertEquals("Invalid amount provided: 0", invalidAmountException.getMessage());
    }

    @Test
    public void givenAnAmount_WhenItsImpossibleToUseOnlyOneBill_ShouldReturnComposeBillsToFinishTheWithdraw() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(150);

        Withdraw expectedWithdraw = new Withdraw()
                .with(1, 100)
                .with(1, 50);
        assertThat(withdraw, is(expectedWithdraw));
    }

    @Test
    public void givenAnAmount_WhenItsImpossibleToUseOnlyOneBill_ShouldBeAbleToComposeWithdrawWithAllExistingBills() {
        ATMMachine atmMachine = new ATMMachine();

        Withdraw withdraw = atmMachine.withDraw(188);

        Withdraw expectedWithdraw = new Withdraw()
                .with(1, 100)
                .with(1, 50)
                .with(1, 20)
                .with(1, 10)
                .with(1, 5)
                .with(1, 2)
                .with(1, 1);
        assertThat(withdraw, is(expectedWithdraw));
    }
}