import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		String[] arr = str.split("");

//		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].equals("A") || arr[i].equals("B") || arr[i].equals("C")) {

				arr[i] = "2";
			}

			else if (arr[i].equals("D") || arr[i].equals("E") || arr[i].equals("F")) {

				arr[i] = "3";
			}

			else if (arr[i].equals("G") || arr[i].equals("H") || arr[i].equals("I")) {

				arr[i] = "4";
			}

			else if (arr[i].equals("J") || arr[i].equals("K") || arr[i].equals("L")) {

				arr[i] = "5";
			}

			else if (arr[i].equals("M") || arr[i].equals("N") || arr[i].equals("O")) {

				arr[i] = "6";
			}

			else if (arr[i].equals("P") || arr[i].equals("Q") || arr[i].equals("R") || arr[i].equals("S")) {

				arr[i] = "7";
			}

			else if (arr[i].equals("T") || arr[i].equals("U") || arr[i].equals("V")) {

				arr[i] = "8";
			}

			else if (arr[i].equals("W") || arr[i].equals("X") || arr[i].equals("Y") || arr[i].equals("Z")) {

				arr[i] = "9";
			}
			
//			System.out.println(Arrays.toString(arr));

		
		}
		
		int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
		
//		System.out.println(Arrays.toString(intArr));
		
		int sum = 0; 
		
		for(int i = 0 ; i<intArr.length; i++) {
			
			sum += intArr[i];
		}
		
		System.out.println(sum+intArr.length);
	}
}
