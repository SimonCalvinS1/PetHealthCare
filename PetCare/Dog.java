package PetCare;
public class Dog extends Pet implements PetHealth
{
    private String dogHealthIssue, dogMedicine;
    public Dog()
    {
        super();
        dogHealthIssue = "None";
        dogMedicine = "None";
    }
    public Dog(int price, int age, String petName, String petBreed, String healthissue, String med)
    {
        super(price, age, petName, "Dog", petBreed);
        dogHealthIssue = healthissue;
        dogMedicine = med;
    }
    public void foodforpet(String food)
    {
        System.out.println("\n\nDog Food Details");
        System.out.println("Feeding the dog: " + food);
    }
    public void treatment(String healthissue, String medicine)
    {
        System.out.println("\n\nDog Treatment Details");
        System.out.println("Treating dog for: " + healthissue + " using medicine: " + medicine);
    }
}