package Constructor_Overloading;

public class Test {
	
	public static void main(String[] args) {
		Test obj = new Test();
		Test obj1 = new Test("DPS");
	}
	
	public Test() {
		System.out.println("Welcome to School");
	}
	
	public Test(String schoolName) {
		System.out.println("Welcome to "+schoolName+" School");
	}

}
