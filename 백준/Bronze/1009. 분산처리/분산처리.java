import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// tc
		for (int tc = 1; tc <= T; tc++) {

			long a = sc.nextInt();
			long b = sc.nextInt();

			long k = 1;

			for (int i = 1; i <= b; i++) {

				k = (k * a) % 10;

			}

			if(k==0) {
				
				System.out.println(10);
			}
			
			else {
			System.out.println(k);
			}
		} // tc

	}
}
