package Programs;

public class Sum_of_Array {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		int sum = 0;
		for(int i = 0; i<=arr.length-1;i++) {
			sum = sum+arr[i];
		}
		System.out.println(sum);
	}
}
