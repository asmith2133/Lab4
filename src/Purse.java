import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination d, int num) {
        cash.put(d, cash.getOrDefault(d, 0) + num);
    }

    public void remove(Denomination d, int num) {
        cash.put(d, cash.getOrDefault(d, 0) - num);
    }

    public double getValue() {
        double total = 0;
        for (Denomination d : cash.keySet()) {
            total += cash.get(d) * d.amt();
        }
        return total;
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Purse{" + "cash=" + cash + '}';
    }
}
