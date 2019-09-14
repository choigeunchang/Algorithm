import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			LinkedList<Integer> people = new LinkedList<>();

			str = bf.readLine();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				people.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(people);
			
			int bread = 0;
			int time = 0;
			boolean result = true;
			
			while(!people.isEmpty()) {
				
				while(people.getFirst() < m + time) {
					
					if(bread == 0) {
						result = false;
						break;
					}
					
					bread--;
					people.remove();
					
					if(people.isEmpty())
						break;
				}
				time += m;
				bread += k;
			}
			
			System.out.println("#" + t + " " + (result ? "Possible" : "Impossible"));
		}
	}
}