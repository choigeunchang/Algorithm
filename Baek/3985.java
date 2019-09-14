import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class R{
	int start;
	int end;
	int count;
	
	public R() {}
	public R(int start, int end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
	}
}
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int roll = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		
		boolean[] cake = new boolean[roll+1];
		R[] r = new R[n+1];
		for(int i=1; i<=n; i++) {
			
			r[i] = new R();
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			r[i].start = Integer.parseInt(st.nextToken());
			r[i].end = Integer.parseInt(st.nextToken());
		}
		
		cake[0] = true;
		for(int i=1; i<=n; i++) {
			
			for(int j=r[i].start; j<=r[i].end; j++) {
				
				if(!cake[j]) {
					r[i].count++;
					cake[j] = true;
				}
			}
		}
		
		int ori = 0;
		int ori_idx = 0;
		for(int i=1; i<=n; i++) {
			
			int temp = r[i].end - r[i].start;
			if(temp > ori) {
				ori = temp;
				ori_idx = i;
			}
		}
		
		int max = 0;
		int max_idx = 0;
		for(int i=1; i<=n; i++) {
			if(r[i].count > max) {
				max = r[i].count;
				max_idx = i;
			}
		}
		
		System.out.println(ori_idx + "\n" + max_idx);
	}
}