package Demo;

public class HR extends IT {

	public static void main(String[] args) {
	
		HR hr = new HR();
		hr.bonous();
		hr.salary();
		hr.work();
		hr.goodies();
		
		IT it = new HR();
		it.goodies();
		it.salary();
		it.work();

	}
	
	@Override
	public void salary() {
		System.out.println("5 LPA");		
	}
	public void bonous() {
		System.out.println("1L");
	}

}
