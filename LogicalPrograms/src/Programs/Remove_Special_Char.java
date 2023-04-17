package Programs;

public class Remove_Special_Char {

	public static void main(String[] args) {
		
		String str = "sa@#$%chin";
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);
	}
}
