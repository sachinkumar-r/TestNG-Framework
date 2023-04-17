package Programs;

public class Reverse_String {

	public static void main(String[] args) {
		
		String name = "Sachin";
		String revName = "";
		
		for(int i=name.length()-1;i>=0;i--) {
			revName = revName+name.charAt(i);
		}
		System.out.println(revName);
	}
}
