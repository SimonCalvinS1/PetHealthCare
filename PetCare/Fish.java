package PetCare;
public class Fish extends Pet implements PetHealth
{
    private int tankLength, tankBreadth;
    private String waterType, fishHealthIssue, fishMedicine, fishFood;
    public Fish()
    {
        super();
        tankLength = 0;
        tankBreadth = 0;
        waterType = "Unknown";
        fishHealthIssue = "Unknown";
        fishMedicine = "Unknown";
        fishFood = "Unknown";
    }
    public Fish(int price, int age, String petName, String petBreed, int len, int b, String water, String health, String med, String food)
    {
        super(price, age, petName, "Fish", petBreed);
        tankLength = len;
        tankBreadth = b;
        waterType = water;
        fishHealthIssue = health;
        fishMedicine = med;
        fishFood = food;
    }
    public void foodforpet(String food)
    {
        System.out.println("\n\nFish Food Details");
        System.out.println("Feeding the fish: " + food);
    }
    public void treatment(String healthissue, String medicine)
    {
        System.out.println("\n\nFish Treatment Details");
        System.out.println("Treating fish for: " + healthissue + " using medicine: " + medicine);
    }
}