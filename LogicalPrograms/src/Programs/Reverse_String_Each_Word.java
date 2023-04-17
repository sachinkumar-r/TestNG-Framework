package Programs;

public class Reverse_String_Each_Word {
	public static void main(String[] args) {

		String str = "India is my country";
		String[] words = str.split(" ");
		String revStr = " ";
		
		for(String w:words) {
			String revw = " ";
			for(int i=w.length()-1;i>=0;i--) {
				revw = revw+w.charAt(i);
			}
			revStr = revStr + revw;	
			//System.out.println(revStr);
		}
		System.out.println(revStr);
}
}


