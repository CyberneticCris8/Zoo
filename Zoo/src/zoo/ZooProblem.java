package zoo;

abstract class Animal {
	private String name;
	private double weight;
	private int age;
	
	public Animal() {
		
	}
	public Animal(String name, double weight, int age) {
		this.name = name;
		this.weight = weight;
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public abstract String makeNoise();
	public String toString() {
		return "Animal [name =" + name + ", weight =" + weight + ", age = " + age + "]";
	}
}
class Cow extends Animal {
	private int numOfSpots;
	public Cow() {
		
	}
	public Cow(String name, double weight, int age, int numOfSpots) {
		super(name, weight, age);
		this.numOfSpots = numOfSpots;
	}
	public String makeNoise() {
		return "Moooooo!";
	}
	@Override
	public String toString() {
		return "Cow [toString()=" + super.toString() + ", numOfSpots=" + numOfSpots + "]";
	}
}
class Horse extends Animal {
	private double topSpeed;
	public Horse() {}
	public Horse(String name, double weight, int age, double topSpeed) {
		super(name, weight, age);
		this.topSpeed = topSpeed;
	}
	public String makeNoise() {
		return "Whinny";
	}
	@Override
	public String toString() {
		return "Horse [toString() =" + super.toString() + ", topSpeed = " + topSpeed + "]";
		
	}
}
class Snake extends Animal{
	private int numOfFangs;
	public Snake() {}
	public Snake(String name, double weight, int age, int numOfFangs) {
		super(name, weight, age);
		this.numOfFangs = numOfFangs;
	}
	public String makeNoise() {
	return "Hisssss";
	}
	@Override
	public String toString() {
		return "Snake [toString() =" + super.toString() + ", numOfFangs = " + numOfFangs + "]";
	}
}
class Zoo {
	Animal [] animals;
	int numOfCages;
	int numOfAnimals;
	
	public Zoo() {
		numOfCages = 3;
		animals = new Animal [numOfCages];
	}
	public Zoo(int numOfCages) {
		this.numOfCages = numOfCages;
		animals = new Animal [numOfCages];
	}
	public void addAnimal (Animal animal) {
		if (numOfCages == numOfAnimals) {
			System.out.println("Zoo is full. Cannot add.");
		} else {
			animals[numOfAnimals ++] = animal;
			
		}
	}
	public double totalWeight() {
		double totalWeight = 0;
		for (int i = 0; i < numOfAnimals; i ++) {
			totalWeight += animals[i].getWeight();
		} 
		return totalWeight;
	}
	public void makeAllNoises() {
		for (int i = 0; i < numOfAnimals; i ++) {
			System.out.println(animals[i].makeNoise());
		}
	}
	public void printAllAnimals() {
		for (int i = 0; i < numOfAnimals; i ++) {
			System.out.println(animals[i]);
		}
	}
}

public class ZooProblem {

	public static void main(String[] args) {
		Zoo z = new Zoo(); 
		Snake sly = new Snake("Sly", 5.0 , 2, 2); 
		Snake sly2 = new Snake("Slyme", 10.0 , 1, 2); 
		Cow blossy = new Cow("Blossy", 900., 5,  10); 
		Horse prince = new Horse("Prince", 1000., 5, 23.2); 
		// Following not allowed because Animal is abstract 
		//Animal spot = new Animal("Spot", 10., 4); 
		z.addAnimal(sly);
		z.addAnimal(sly2);

		z.addAnimal(blossy);
		z.addAnimal(prince);
		z.makeAllNoises();
		System.out.println("Total weight = " + z.totalWeight());

		System.out.println("**************************");
		System.out.println("Animal Printout:");
		z.printAllAnimals();
		System.out.println("********* Now we will make the Second Zoo"); 
		Zoo z2 = new Zoo(5); 
		z2.addAnimal(sly); 

		z2.addAnimal(sly2); 
		z2.addAnimal(blossy); 
		z2.addAnimal(prince); 
		z2.addAnimal( new Horse("Warrior", 1200, 6, 25.3)); 
		z2.addAnimal( new Horse("Harry", 1100, 4, 21.3)); 
		System.out.println("Total weight of z2= "+z2.totalWeight()); 
		z2.makeAllNoises(); 
		z2.printAllAnimals();

	}

}
