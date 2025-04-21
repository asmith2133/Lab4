import java.util.Map;
import java.util.HashMap;

public class PurseCount implements PurseDisplay {
        private final Purse purse;

        public PurseCount(Purse purse) {
            this.purse = purse;
        }

        @Override
        public String display() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
                sb.append(entry.getValue())
                        .append(" x ")
                        .append(entry.getKey().name())
                        .append("\n");
            }
            return sb.toString();
        }

}
