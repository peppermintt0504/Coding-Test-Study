import java.io.*;
import java.util.*;

class Solution
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static ArrayList<int[]> p;
	public static ArrayList<int[]> step;
	public static ArrayList<Person[]> p2 = new ArrayList<>();
	
	public static int step1Length;
	public static int step2Length;

	public static int answer = 10000;
	
	public static class Person implements Comparable<Person>{
		int x;
		int y;
		int distance;
		
		public Person() {
			// TODO Auto-generated constructor stub
		}

		public Person(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Person o) {
			
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			answer= 10000;
			p = new ArrayList<>();
			step = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int x = 0; x < N; x++) {
					if(temp[x] == 1) {
						int[] te = {x,i};
						p.add(te);
					}else if(temp[x] != 0) {
						int[] te = {x,i,temp[x]};
						step.add(te);
					}
				}
			}
			
			step1Length = step.get(0)[2];
			step2Length = step.get(1)[2];
			
			


			boolean[] visited = new boolean[p.size()];
			Person[] array = new Person[p.size()];
			
			for(int i = 0; i < p.size();i++) {
				int[] tempP = p.get(i);
				array[i] =(new Person(tempP[0],tempP[1],Math.abs(step.get(0)[0] - tempP[0]) + Math.abs(step.get(0)[1] - tempP[1])));
			}
			
			powerSet(array,visited,p.size(),0);
			
			bw.write("#" + Integer.toString(t) + " " + Integer.toString(answer+1) +"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int checkTime (Queue<Person> s1, Queue<Person> s2) throws IOException {
		int count = 0;
		
		int s1Count = 0;
		int s2Count = 0;
		
		int[] time = new int[100];
		
		
		while(!s1.isEmpty()) {
			Person target = s1.poll();
			int start = target.distance + 1;
			int d = 0;
			
			while(time[start + d] >= 3) {
				d++;
			}
			
			for(int t = 0; t < step1Length; t++) {
				time[t + start + d]++;
				if(t == step1Length-1) s1Count = t + start + d;
			}
			
		}
		
		time = new int[100];
		while(!s2.isEmpty()) {
			Person target = s2.poll();
			int start = target.distance + 1;
			int d = 0;
			
			while(time[start + d] >= 3) {
				d++;
			}
			
			for(int t = 0; t < step2Length; t++) {
				time[t + start + d]++;
				if(t == step2Length-1) s2Count = t + start + d;
			}
			
		}
		
		if(Math.max(s1Count, s2Count) < answer) answer = Math.max(s1Count, s2Count);
		
		return count;
	}
	
	static void powerSet(Person[] arr, boolean[] visited, int n, int idx) throws IOException {
	    if(idx == n) {
	    	print(arr, visited, n);
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(arr, visited, n, idx + 1);
	}
	
	static void print(Person[] arr, boolean[] visited, int n) throws IOException {
		PriorityQueue<Person> queue1 = new PriorityQueue<>();
		PriorityQueue<Person> queue2 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
            	
            	
            	
                queue1.add(new Person(arr[i].x,arr[i].y,Math.abs(step.get(0)[0] - arr[i].x) + Math.abs(step.get(0)[1] - arr[i].y)));
            else
            	queue2.add(new Person(arr[i].x,arr[i].y,Math.abs(step.get(1)[0] - arr[i].x) + Math.abs(step.get(1)[1] - arr[i].y)));
        }
        checkTime(queue1,queue2);
    }
}