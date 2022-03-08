
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("Gorilla thrown something");
		energyLevel -=5;
		
	}
	public void eatBananas() {
		System.out.println("Gorilla satisfied");
		energyLevel +=10;
		
	}
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		energyLevel -=10;
		
	}

}
