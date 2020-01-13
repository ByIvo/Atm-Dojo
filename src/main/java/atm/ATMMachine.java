package atm;

public class ATMMachine {

    private static final int[] EXISTING_NOTES = {100, 50, 20, 10, 5, 2, 1};

    public Withdraw withDraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }

        return withdrawValidAmountOf(amount);
    }

    private Withdraw withdrawValidAmountOf(int amount) {
        Withdraw withdraw = new Withdraw();
        int leftAmount = amount;

        for(int banknoteType : EXISTING_NOTES) {
            if (leftAmount >= banknoteType) {
                int numberOfNotes = leftAmount / banknoteType;
                leftAmount = leftAmount % banknoteType;

                withdraw.with(numberOfNotes, banknoteType);
            }
        }

        return withdraw;
    }
}
