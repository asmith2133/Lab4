import java.util.Map;
import java.util.HashMap;
public class Purse {


    public static class purse {

        protected final Map<Denomination, Integer> cash = new HashMap<>();

        public void add(Denomination d, int num){
            cash.put(d, cash.getOrDefault(d, 0) + num);

        }

        public void remove(Denomination d, int num){

            cash.put(d, cash.get(d) - num);
        }

        public double getValue(){
            double total = 0;
            for(Denomination d : cash.keySet()){
                total += cash.get(d) * d.amt();
            }
            return total;
        }

        @Override
        public String toString() {
            return "purse{" + "cash=" + cash + '}';
        }


    }
}