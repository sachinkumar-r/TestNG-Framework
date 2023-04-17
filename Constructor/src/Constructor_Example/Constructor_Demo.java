package Constructor_Example;

public class Constructor_Demo {

	public static void main(String[] args) {
		
		Constructor_Demo obj = new Constructor_Demo();
		obj.display();
	}
		
		public Constructor_Demo(){
			System.out.println("I am in Constructor");
		}
		public void display() {
			System.out.println("Hi, Welcome to Java");
		}
	}

