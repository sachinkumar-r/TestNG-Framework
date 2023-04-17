package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

public class TraverseExample {
public static void main(String[] args) {
	
	ArrayList<String> names = new ArrayList<String>();
	names.add("Sachin");
	names.add("Reddy");
	names.add("QA");
	names.add("QT");
	names.add("India");
	
	// 1. Iterable- for each loop - forward traversing.
	for(String str:names) {
		System.out.print(str + "\t"+str.length()+"\t");
		// to reverse each string
		StringBuffer br = new StringBuffer(str);
		System.out.println(br.reverse());
	}
	
	System.out.println("----------------------------------------------------------");
	
	// 2. Using Iterator  -- forward traversing
	
	Iterator<String> itr = names.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	System.out.println("----------------------------------------------------------");
	
	// 3. Using ListIterator --- for backword transverse
	
	ListIterator<String> litr = names.listIterator(names.size());
	while(litr.hasPrevious()) {
		String previous = litr.previous();
		System.out.println(previous);
	}
	
	System.out.println("--------------------------For Each Method--------------------------------");
	
	// 4. for each method
	names.forEach(e->{
		System.out.println(e);
	});
	
	System.out.println("----------------------TreeSet------------------------------------");
	
	TreeSet<String> tset = new TreeSet();
	tset.addAll(names);
	//System.out.println(tset);
	tset.forEach(e->{
		System.out.println(e);
	});
}
}
