import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
    static int[] sorted = new int[1000000];
    
	public static void main(String[] args) throws IOException {
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
		mergeSort(nums,0,nums.length-1);
		System.out.println(sorted[500000]);
	}
	static void mergeSort(int[] arr, int left, int right) {
    	if(left < right) {
    		int mid = (left + right) / 2;
    		mergeSort(arr,left,mid);
    		mergeSort(arr,mid+1,right);
    		merge(arr, left,right);
    	}
    }
 
    static void merge(int[] arr, int start, int end) {
    	int mid = (start+end) / 2;
    	int left = start;
    	int right = mid+1;
    	int index = start;
    	
    	while(left <= mid && right <= end) {
    		if(arr[left] <= arr[right]) {
    			sorted[index++] = arr[left++];
    		}else {
    			sorted[index++] = arr[right++];
    		}
    	}
    	while(left <= mid) {
    		sorted[index++] = arr[left++];
    	}
    	while(right <= end) {
    		sorted[index++] = arr[right++];
    	}
    	for(int i = start; i <= end; i++) {
    		arr[i] = sorted[i];
    	}
    }
}
