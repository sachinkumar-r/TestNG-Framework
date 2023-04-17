package Collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Remove_Duplicate {
public static void main(String[] args) {
	ArrayList<String> names = new ArrayList<String>();
	names.add("Sachin");
	names.add("Reddy");
	names.add("QA");
	names.add("QA");
	names.add("India");
	
	System.out.println(names);
	
	LinkedHashSet<String>LHS = new LinkedHashSet(names);
	
	System.out.println(LHS);
	
}
}
