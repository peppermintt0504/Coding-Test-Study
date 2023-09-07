import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 1; i <= n; i++) {

			if (n % i == 0) {

				arr[i - 1] = i;

			}

		}

//		System.out.println(Arrays.toString(arr));

		// 약수들 중 k번째로 작은 수
		
		int sum = 0; 

		for (int i = 0; i < n; i++) {

			if (arr[i] != 0) {

				sum++; 
				
				if(sum==k) {
					
					System.out.println(arr[i]);
					
					return; 
					
				}
				
			}

		}
		
		System.out.println(0);

	}
}
