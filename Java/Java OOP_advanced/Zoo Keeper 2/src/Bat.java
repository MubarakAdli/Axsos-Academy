
public class Bat {
	
protected int energyLevel =300;

public void fly() {
	energyLevel-=50;
	System.out.println("Sound taking off");
}

public void eatHumans() {
	energyLevel+=25;
	System.out.println("So-well");
}

public void attackDown() {
	energyLevel-=100;
	System.out.println("burning town on fire");
}

}
