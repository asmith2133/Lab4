public class PurseBasics {
    private final Purse purse;

    public PurseBasics(Purse purse) {
        this.purse = purse;
    }

    public String display() {
        return purse.toString();
    }


}
