import java.util.Scanner;

public class Main {	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt(); 
			
			int k = n; 
			int d = 0; 
			
			int sum = 0; 
			
		if(n==0) {
			
			System.out.println(1);
			
			
		}
			
		else {
		while(k!=d) {
			int a = n/10;
			int b = n%10;

			
			d = b*10+((a+b)%10);
			
			n = d; 
			
//			System.out.println(d);
//			
			sum++;
			
		}
		
		System.out.println(sum);
			
		}
		
		}

}
