import java.util.Arrays;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		String[] arr = str.split("");
		
//		System.out.println(Arrays.toString(arr));
		// 알파벳 배열 만들기

		String str2 = "abcdefghijklmnopqrstuvwxyz";
		String[] arr2 = str2.split("");

		
//		System.out.println(Arrays.toString(arr2));
		
		
		int[] arr3 = new int[26];
		
		for(int i = 0; i<26; i++) {
			
			arr3[i] = 120; 
		}
		

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr3));
//		
		
//		System.out.println(arr.length);
		
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				if (arr[i].equals(arr2[j])&&arr3[j]==120) {

					arr3[j] = i;
				}

			}

		}
		
		for(int i = 0; i < arr3.length; i++) {
			
			if(arr3[i]==120) {
				
				arr3[i] = -1; 
				
			}
		}
		
		
		for(int i = 0; i < arr3.length; i++) {
			
			System.out.print(arr3[i]+" ");
		}


	}
}
