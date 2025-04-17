import java.util.List;
import java.util.Scanner;

public class Register {
    private final List<Denomination> denominations = Denomination.PREDEFINED_DENOMINATIONS;

    public Purse.purse makeChange(double amt){
        Purse.purse purse = new Purse.purse();

        if (amt <= 0) {
            return purse;
        }


        for(Denomination d : denominations){
            int num = (int) (amt / d.amt());

            if(num>0){
                purse.add(d, num);
                amt -= num * d.amt();
            }

        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount: ");
        double amt = scanner.nextDouble();
        Purse.purse purse = register.makeChange(amt);
        System.out.println(purse);
        scanner.close();


    }
}
