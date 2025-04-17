import java.util.List;

public record Denomination(String name, double amt, String form, String img)
{
    public static final List<Denomination> PREDEFINED_DENOMINATIONS = List.of(
            new Denomination("Fifty-Dollar Note", 50.0, "bill", "Images/fifty-dollar-note.jpg"),
            new Denomination("Twenty-Dollar Note", 20.0, "bill", "Images/twenty-dollar-note.jpg"),
            new Denomination("Ten-Dollar Note", 10.0, "bill", "Images/ten-dollar-note.jpg"),
            new Denomination("Five-Dollar Note", 5.0, "bill", "Images/five-dollar-note.jpg"),
            new Denomination("One-Dollar Note", 1.0, "bill", "Images/one-dollar-note.jpg"),
            new Denomination("Quarter", 0.25, "coin", "Images/quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "Images/dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "Images/nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "Images/penny.jpg")
    );

}


