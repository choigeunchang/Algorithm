import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] visited;
	static ArrayList<Integer> ethras;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		ethras = new ArrayList<>();
		visited = new boolean[1000001];
		Prime();
		
		for(int t=1; t<=test_case; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int count = 0;

			for(int i=0; i<ethras.size(); i++) {
				
				if(ethras.get(i)>=a && ethras.get(i)<=b) {
					
					String temp = String.valueOf(ethras.get(i));
					for(int j=0; j<temp.length(); j++) {
						
						if(temp.charAt(j) == d + '0') {
							count++;
							break;
						}
					}
				}
			}

			bw.write("#" + t + " " + count + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void Prime() {
		
		for(int i=2; i<=1000000; i++) {
			for(int j=2; i*j<=1000000; j++)
				visited[i*j] = true;
		}
		
		for(int i=2; i<=1000000; i++) {
			if(!visited[i])
				ethras.add(i);
		}
	}
}