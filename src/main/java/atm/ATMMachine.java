package atm;

public class ATMMachine {

    private static final int[] EXISTING_BILLS = {100, 50, 20, 10, 5, 2, 1};

    public Withdraw withDraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }

        return withdrawValidAmountOf(amount);
    }

    private Withdraw withdrawValidAmountOf(int amount) {
        Withdraw withdraw = new Withdraw();
        int leftAmount = amount;

        for(int billValue : EXISTING_BILLS) {
            if (leftAmount >= billValue) {
                int numberOfBills = leftAmount / billValue;
                leftAmount = leftAmount % billValue;

                withdraw.with(numberOfBills, billValue);
            }
        }

        return withdraw;
    }
}
