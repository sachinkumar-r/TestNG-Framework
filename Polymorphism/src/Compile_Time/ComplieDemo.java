package Compile_Time;

public class ComplieDemo {
	public static void main(String[] args) {
		
	ComplieDemo obj = new ComplieDemo();
	obj.add(10,20);
	obj.add(10, 10,20);
	}
	
	public void add(int a, int b) {
		int c=a+b;
		System.out.println(c);
	}
	
	public void add(int a, int b, int c) {
		int d = a+b+c;
		System.out.println(d);
	}

}
