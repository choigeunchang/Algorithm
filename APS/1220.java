import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			
			int num = s.nextInt();
			int[][] arr = new int[num][num];
			for(int i=0; i<num; i++) {
				for(int j=0; j<num; j++)
					arr[i][j] = s.nextInt();
			}
			
			int count = 0;
			for(int j=0; j<num; j++) {
				
				for(int i=0; i<num-1; i++) {

					if(arr[i][j] == 1) {
						i++;
						while(arr[i][j] != 2) {
							i++;
							if(i>=num)
								break;
						}
						if(i>=num)
							break;
						else {
							if(arr[i][j] == 2)
								count++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}