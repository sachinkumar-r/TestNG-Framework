package Run_Time;

public class Child extends Parent{
	public static void main(String[] args) {
		
		Child obj = new Child();
		obj.demo();
		
		Parent obj1 = new Parent();
		obj1.demo();
		
		Parent obj2 = new Child();
		obj2.demo();
		
		Parent.demo();
		
	}
	public static void demo() {
		System.out.println("I am in Child Class");
	}

}
