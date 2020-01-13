package atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Withdraw {
    private Map<Integer, Integer> bills;

    protected Withdraw() {
        bills = new HashMap<>();
    }

    protected Withdraw(int numberOfBills, int billType) {
        this();
        with(numberOfBills, billType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdraw withdraw = (Withdraw) o;

        return this.bills.equals(withdraw.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bills);
    }

    @Override
    public String toString() {
        return "atm.Withdraw{" +
                "bills=" + bills +
                '}';
    }

    protected Withdraw with(int numberOfBills, int billType) {
        bills.put(billType, numberOfBills);
        return this;
    }
}
