package practice.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(practice.test.MyListeners.class)
public class Car extends Base_Class_For_Practice{
	
	@Test
	public void drift() {
		System.out.println("Execute drift()");
	}
	
	@Test
	public void sleppy() {
		System.out.println("Execute sleppy()");
	}

}
