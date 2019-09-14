import java.io.*;
import java.util.*;

class time implements Comparable<time>{
	
	int start;
	int end;
	
	public time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(time t) {
		
		if(this.end == t.end)
			return Integer.compare(this.start, t.end);
		else
			return Integer.compare(this.end, t.end);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		time[] t = new time[n];
		
		for(int i=0; i<n; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			t[i] = new time(temp[0], temp[1]);
		}
		
		Arrays.sort(t);
		int count = 0;
		int end = -1;
		
		for(int i=0; i<n; i++) {
			if(t[i].start >= end) {
				end = t[i].end;
				count++;
			}		
		}
		System.out.println(count);
	}
}
