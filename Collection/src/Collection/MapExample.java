package Collection;

import java.util.HashMap;

public class MapExample {
public static void main(String[] args) {
	
	HashMap<String,Integer> courses = new HashMap();
	
	courses.put("Java", 1000);
	courses.put("Python", 2000);
	courses.put("Ruby", 1500);
	courses.put("Android", 1800);
	courses.put("Android", 1900);
	courses.put("PHP", 2100);
	
	System.out.println(courses);
	
	courses.forEach((e1,e2)->{
		System.out.println(e1+ "=>"+e2);
	});
	System.out.println(courses.get("Java"));
}
}
