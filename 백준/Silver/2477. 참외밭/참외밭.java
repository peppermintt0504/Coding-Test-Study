import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Long> num = new ArrayList<>();
		List<Long> num1 = new ArrayList<>();
		List<Long> num2 = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			if(i%2 ==0) {
				num1.add(sc.nextLong());
				num.add(num1.get(num1.size()-1));
			}
			else {
				num2.add(sc.nextLong());
				num.add(num2.get(num2.size()-1));
			}
		}
		
		Collections.sort(num1);
		Collections.sort(num2);
		
		long biggest = num1.get(num1.size()-1);
		long nextBiggest = num2.get(num2.size()-1);

		while(true) {
			if(num.get(0)==biggest && num.get(num.size()-1)==nextBiggest) {
				break;
			}
			if(num.get(0)==nextBiggest && num.get(num.size()-1)==biggest) {
				break;
			}
			long temp1 = num.remove(0);
			num.add(temp1);
		}
		
		long total = biggest*nextBiggest;
		long toDelete = num.get(2)*num.get(3);
		total-=toDelete;
		
		System.out.println(total*N);
	}
}
