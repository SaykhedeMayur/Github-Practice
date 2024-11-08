package practice.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(practice.test.MyListeners.class)
public class Bike extends Base_Class_For_Practice {
	
	@Test
	public void speed() {
		System.out.println("Execute speed()");
	}
	
	@Test
	public void stoppie() {
		System.out.println("Execute stoppie()");
	}

}
