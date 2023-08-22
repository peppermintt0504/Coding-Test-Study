import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스 개수 
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // 주어질 정수의 개수
			int[] arr = new int[N]; // N만큼 항목 갖고있는 배열 만들기
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); // 배열에 값 넣기
			} 
			
			// 정렬해주자!
			for(int i = 0; i < N - 1; i++) { //0 ~ N-2 까지 봐줄게
				int minIdx = i; // 해당 인덱스를 일단 min이라 치고
				for(int j = i + 1; j < N; j++) { // i~N-1까지 중에
					if(arr[minIdx] > arr[j]) { // min에 해당하는 값보가 작으면 
						minIdx = j; // 갱신
					}
				}
				
				// 원래 있던 값이랑 바꿔줌
				int temp = arr[minIdx];
				arr[minIdx] = arr[i];
				arr[i] = temp;
			}
			
			System.out.print("#" + testCase + " ");
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}
		
	}
}