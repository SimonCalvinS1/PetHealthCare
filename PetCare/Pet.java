package PetCare;

public class Pet 
	implements Comparable<Pet>	{

    int petid, price, age;
    String petname, animal, petbreed;
    static int idCounter = 1;

    public Pet()
    {
        this.petid = idCounter++;
        this.price = 0;
        this.age = 0;
        this.petname = "Unknown";
        this.animal = "Unknown";
        this.petbreed = "Unknown";
    }

    public Pet(int price, int age, String petname, String animal, String petbreed)
    {
        this.petid = idCounter++;
        setPrice(price);
        setAge(age);
        this.petname = petname;
        this.animal = animal;
        this.petbreed = petbreed;
    }


    //getters and setters
    public int getPetId() { return petid; }
    public int getpetprice() { return price; }
    public int getAge() { return age; }


    public void setPrice(int price) {
        if (price < 0) { throw new IllegalArgumentException("Price cannot be negative"); }
        this.price = price;
    }
    public void setAge(int age) {
        if (age < 0) { throw new IllegalArgumentException("Age cannot be negative"); }
        this.age = age;
    }


    public String getPetName() { return petname; }
    public String getAnimal() { return animal; }
    public String getPetBreed() { return petbreed; }

    
    @Override
    public String toString() {
        return petname + " (" + animal + ") - " + petbreed + ", Age: " + age + ", Price: ₹" + price;
    }


    //sorting by price
    @Override
    public int compareTo(Pet other) {
        return Integer.compare(this.price, other.price);
    }
}
