import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i=1; i<=5; i++) {
			
			int a = sc.nextInt(); 
			
			sum += a*a; 
			
//			System.out.println(sum);
		}
		
		System.out.println(sum%10);

	}
 }
