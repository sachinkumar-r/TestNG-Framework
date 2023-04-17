package Collection;

// Compulsory Import this package.
import java.util.*;

public class Demo {
	public static void main(String[] args) {
		/* Create collection
		1) Type Safe - Same types of elements are added to collection.
		
		2) Un Type Safe - different types of elements can be added to collection.
		*/
		
		// Declare Type Safe collection
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sachin");
		names.add("Reddy");
		names.add("QA");
		names.add("Reddy");
		System.out.println(names);
		
		//Retrive data using index
		System.out.println(names.get(0));
		
		//Remove from list
		System.out.println(names.remove("Sachin"));
		
		// Size of list
		System.out.println(names.size());
		
		//check the object in the list
		System.out.println(names.contains("QA"));
		
		//check collection is empty or not
		System.out.println(names.isEmpty());
		
		//setting values in the list.
		System.out.println(names.set(2, "Testing"));
		System.out.println(names);
		// remove all element
		names.clear();
		
		// Declare Un Type Safe collection
		System.out.println("---------------------------------------------------------");
		LinkedList list = new LinkedList();
		
		list.add("Sachin");
		list.add(100);
		list.add(50.45);
		list.add(true);
		System.out.println(list);
		
		System.out.println("---------------------------------------------------------");
		
		//HashSet Declare
		HashSet<Double> num = new HashSet();
		num.add(14.15);
		num.add(1111.4365);
		num.add(34.12345);
		num.add(99.3);
		num.add(14.15);
		num.add(5.3);
		
		System.out.println(num);
		
		System.out.println("---------------------------------------------------------");
		
		//TreeSet declare ---  sorts in ascending order.
		TreeSet<Double> tset = new TreeSet();
		tset.addAll(num);
		System.out.println(tset);
		
		System.out.println("---------------------------------------------------------");
	}

}
